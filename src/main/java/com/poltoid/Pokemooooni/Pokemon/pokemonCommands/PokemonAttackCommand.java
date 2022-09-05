package com.poltoid.Pokemooooni.Pokemon.pokemonCommands;

import com.poltoid.Pokemooooni.Pokemon.Pokemon;

public class PokemonAttackCommand implements PokemonCommand {
    Pokemon pokemon;

    public PokemonAttackCommand(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void execute(Pokemon target) {
        this.pokemon.dealDamage(target);
    }
}
