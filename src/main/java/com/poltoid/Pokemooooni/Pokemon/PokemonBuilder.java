package com.poltoid.Pokemooooni.Pokemon;

// Builder and Fluent Interface
class PokemonBuilder {
    private Integer abilityCount;
    protected Pokemon pokemon;

    public PokemonBuilder() {
        this.pokemon = new Pokemon();
        abilityCount = 0;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public PokemonBuilder hasSpecial() {
        this.pokemon.setSpecial(true);
        return this;
    }

    public PokemonBuilder setName(String name) {
        this.pokemon.setName(name);
        return this;
    }

    public PokemonBuilder setStats(Integer HP, Integer attack, Integer def, Integer specialDef) {
        this.pokemon.setHP(HP);
        this.pokemon.setDef(def);
        this.pokemon.setSpecialDef(specialDef);

        if(pokemon.hasSpecial()) {
            this.pokemon.setSpecialAttack(attack);
        }
        else this.pokemon.setNormalAttack(attack);
        return this;
    }

    public PokemonBuilder addAbility(Integer dmg, Boolean stun, Boolean dodge, Integer cooldown) {
        if(abilityCount == 2) throw new IllegalArgumentException("Pokemons have up to 2 abilities.");
        Ability ability = new Ability(dmg, stun, dodge, cooldown);

        if(abilityCount == 1) this.pokemon.setAbility2(ability);
        else this.pokemon.setAbility1(ability);

        abilityCount++;
        return this;
    }

}
