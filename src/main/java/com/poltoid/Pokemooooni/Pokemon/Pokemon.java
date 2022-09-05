package com.poltoid.Pokemooooni.Pokemon;
import com.poltoid.Pokemooooni.Logger.*;
import com.poltoid.Pokemooooni.Items.Item;
import com.poltoid.Pokemooooni.Pokemon.pokemonCommands.*;

import java.util.List;

public class Pokemon {
    private String name;
    private Integer HP;
    private Integer normalAttack;
    private Integer specialAttack;
    private Integer def;
    private Integer specialDef;
    private Ability ability1;
    private Ability ability2;
    private boolean hasSpecial;
    private boolean isStunned;
    private boolean isDodging;

    Logger logger = Logger.getInstance();

    public Pokemon() {
        this.hasSpecial = false; this.isStunned = false;
    }

    public void applyItems(List<Item> items) {
        for(Item item:items) {
            logger.log(this.name + " has applied the " + item);
            this.HP += item.getHPMod();
            if(this.hasSpecial) {
                this.specialAttack += item.getSpecialAttackMod();
            } else {
                this.normalAttack += item.getAttackMod();
            }
            this.def += item.getDefMod();
            this.specialDef += item.getSpecialDefMod();
        }
    }

    public boolean isAlive() {
        return this.HP > 0;
    }

    public void receiveDamage(Integer damageDealt) {
        this.HP = Math.max(this.HP - damageDealt, 0);
    }

    public void dealDamage(Pokemon target) {
        logger.log(this.name + " has used Normal Attack!");
        if(target.isDodging) return;
        int damageDealt;
        // Minimum damage is 1.
        if(this.hasSpecial) {
            damageDealt = Math.max(this.specialAttack - target.specialDef, 1);
        } else {
            damageDealt = Math.max(this.normalAttack - target.def, 1);
        }
        target.receiveDamage(damageDealt);
    }

    public void useAbility1(Pokemon target) {
        logger.log(this.name + " has used Ability1!");
        useAbility(target, ability1);
    }

    public void useAbility2(Pokemon target) {
        logger.log(this.name + " has used Ability2!");
        useAbility(target, ability2);
    }

    private void useAbility(Pokemon target, Ability ability) {
        ability.currentCooldown = ability.cooldown;
        if(ability.dodge) {
            this.isDodging = true;
            logger.log(this.name + " is dodging!");
        }
        // if the target is currently dodging, nothing else happens
        if(target.isDodging) return;
        if(ability.stun) target.setStunned(true);
        Integer damageDealt = ability.dmg;
        target.receiveDamage(damageDealt);
    }

    public PokemonCommand getCommand() {
        // generates a random number between 0 and 2
        // if its 0 or 1 it will use one of the two abilities
        // switch cascade helped out here
        // if it generates a 2 it will go to default.
        int randomNumber = (int) Math.round(Math.random() * 2);
        switch(randomNumber) {
            case 0:
                if(ability1.currentCooldown == 0) return new PokemonAbility1Command(this);
            case 1:
                if(ability2.currentCooldown == 0) return new PokemonAbility2Command(this);
            default:
                return new PokemonAttackCommand(this);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(Integer HP) {
        this.HP = HP;
    }

    public void setNormalAttack(Integer normalAttack) {
        this.normalAttack = normalAttack;
    }

    public void setSpecialAttack(Integer specialAttack) {
        this.specialAttack = specialAttack;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public void setSpecialDef(Integer specialDef) {
        this.specialDef = specialDef;
    }

    public void setAbility1(Ability ability1) {
        this.ability1 = ability1;
    }

    public void setAbility2(Ability ability2) {
        this.ability2 = ability2;
    }

    public void setSpecial(boolean b) {
        this.hasSpecial = b;
    }

    public boolean hasSpecial() { return this.hasSpecial; }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public void levelUp() {
        // +1 to all stats
        if(this.hasSpecial) this.specialAttack++;
        else this.normalAttack++;
        this.HP++;
        this.def++;
        this.specialDef++;
        logger.log(this.name + " gains +1 HP, +1 DMG, +1 DEF, +1 SDEF");
    }

    public void updateStatus() {
        if(this.ability1.currentCooldown != 0) this.ability1.currentCooldown--;
        if(this.ability2.currentCooldown != 0) this.ability2.currentCooldown--;
        if(this.isDodging) this.isDodging = false;
    }

    @Override
    public Pokemon clone() {
        PokemonBuilder clone = new PokemonBuilder();
        if(this.hasSpecial) clone.hasSpecial().setStats(this.HP, this.specialAttack, this.def, this.specialDef);
        else clone.setStats(this.HP, this.normalAttack, this.def, this.specialDef);
        clone.setName(this.name);
        if(this.ability1 != null) clone.addAbility(this.ability1.dmg, this.ability1.stun, this.ability1.dodge, this.ability1.cooldown);
        if(this.ability2 != null) clone.addAbility(this.ability2.dmg, this.ability2.stun, this.ability2.dodge, this.ability2.cooldown);
        return clone.getPokemon();
    }

    @Override
    public String toString() {
        String string = name + " HP " + HP;
        if(hasSpecial) string = string + " SATK " + specialAttack;
        else string = string + " ATK " + normalAttack;
        return string +
                " DEF " + def +
                " SDEF " + specialDef + "\n" +
                " Ability1 " + ability1 + "\n" +
                " Ability2 " + ability2 + "\n";
    }

    public String getName() {
        return name;
    }

    public int statTotal() {
        if(this.hasSpecial) return this.HP + this.specialAttack + this.def + this.specialDef;
        else return this.HP + this.normalAttack + this.def + this.specialDef;
    }

}
