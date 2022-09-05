package com.poltoid.Pokemooooni.Pokemon.pokemonCommands;

import com.poltoid.Pokemooooni.Pokemon.Pokemon;

public class PokemonAbility1Command implements PokemonCommand {
    Pokemon pokemon;

    public PokemonAbility1Command(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public void execute(Pokemon target) {
        this.pokemon.useAbility1(target);
    }
}
