package com.poltoid.Pokemooooni.Pokemon;

public class Ability {
    protected Integer dmg;
    protected Boolean stun;
    protected Boolean dodge;
    protected Integer cooldown;
    protected Integer currentCooldown;

    public Ability(Integer dmg, Boolean stun, Boolean dodge, Integer cooldown) {
        this.dmg = dmg;
        this.stun = stun;
        this.dodge = dodge;
        this.cooldown = cooldown;
        this.currentCooldown = 0;
    }

    @Override
    public String toString() {
        return "currentCooldown=" + currentCooldown;
    }
}
