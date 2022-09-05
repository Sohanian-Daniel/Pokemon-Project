package com.poltoid.Pokemooooni.Pokemon;

// Singleton and Factory design patterns
public class PokemonFactory {
    private static PokemonFactory instance;

    private PokemonFactory() {}

    public static PokemonFactory getInstance() {
        if(instance == null) instance = new PokemonFactory();
        return instance;
    }

    public enum TypePokemon {
        Neutrel1, Neutrel2, Pikachu, Bulbasaur, Charmander, Squirtle, Snorlax, Vulpix, Eevee, Jigglypuff, Meowth, Psyduck
    }

    public Pokemon createPokemon(String pokemon) {
        TypePokemon typePokemon = PokemonFactory.TypePokemon.valueOf(pokemon);
        switch(typePokemon) {
            case Neutrel1:
                return new PokemonBuilder()
                        .setName("Neutrel1")
                        .setStats(10, 3, 1 ,1)
                        .getPokemon();
            case Neutrel2:
                return new PokemonBuilder()
                        .setName("Neutrel2")
                        .setStats(20, 4, 1 ,1)
                        .getPokemon();
            case Pikachu:
                return new PokemonBuilder()
                        .setName("Pikachu")
                        .hasSpecial()
                        .setStats(35, 4, 2, 3)
                        .addAbility(6, false, false, 4)
                        .addAbility(4, true, true, 5)
                        .getPokemon();
            case Bulbasaur:
                return new PokemonBuilder()
                        .setName("Bulbasaur")
                        .hasSpecial()
                        .setStats(42, 5, 3, 1)
                        .addAbility(6, false, false, 4)
                        .addAbility(5, false, false, 3)
                        .getPokemon();
            case Charmander:
                return new PokemonBuilder()
                        .setName("Charmander")
                        .setStats(50, 4, 3, 2)
                        .addAbility(4, true, false, 4)
                        .addAbility(7, false, false, 6)
                        .getPokemon();
            case Squirtle:
                return new PokemonBuilder()
                        .setName("Squirtle")
                        .hasSpecial()
                        .setStats(60, 3, 5, 5)
                        .addAbility(4, false, false, 3)
                        .addAbility(2, true, false, 2)
                        .getPokemon();
            case Snorlax:
                return new PokemonBuilder()
                        .setName("Snorlax")
                        .setStats(62, 3, 6, 4)
                        .addAbility(4, true, false, 5)
                        .addAbility(0, false, true, 5)
                        .getPokemon();
            case Vulpix:
                return new PokemonBuilder()
                        .setName("Vulpix")
                        .setStats(36, 5, 2, 4)
                        .addAbility(8, true, false, 6)
                        .addAbility(2, false, true, 7)
                        .getPokemon();
            case Eevee:
                return new PokemonBuilder()
                        .setName("Eevee")
                        .hasSpecial()
                        .setStats(39, 4, 3, 3)
                        .addAbility(5, false, false, 3)
                        .addAbility(3, true, false, 3)
                        .getPokemon();
            case Jigglypuff:
                return new PokemonBuilder()
                        .setName("Jigglypuff")
                        .setStats(34, 4, 2, 3)
                        .addAbility(4, true, false, 4)
                        .addAbility(3, true, false, 4)
                        .getPokemon();
            case Meowth:
                return new PokemonBuilder()
                        .setName("Meowth")
                        .setStats(41, 3, 4, 2)
                        .addAbility(5, false, true, 4)
                        .addAbility(1, false, true, 3)
                        .getPokemon();
            case Psyduck:
                return new PokemonBuilder()
                        .setName("Psyduck")
                        .setStats(43, 3, 3, 3)
                        .addAbility(2, false, false, 4)
                        .addAbility(2, true, false, 5)
                        .getPokemon();
        }
        throw new IllegalArgumentException("Unknown pokemon type " + pokemon);
    }
}
