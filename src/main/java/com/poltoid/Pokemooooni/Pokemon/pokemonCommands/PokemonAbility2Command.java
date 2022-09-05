package com.poltoid.Pokemooooni.Pokemon.pokemonCommands;

import com.poltoid.Pokemooooni.Pokemon.Pokemon;

public class PokemonAbility2Command implements PokemonCommand {
    Pokemon pokemon;

    public PokemonAbility2Command(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void execute(Pokemon target) {
        this.pokemon.useAbility2(target);
    }
}
