package com.poltoid.Pokemooooni.Adventure;

import com.poltoid.Pokemooooni.Logger.*;
import com.poltoid.Pokemooooni.Pokemon.Pokemon;
import com.poltoid.Pokemooooni.Trainer.Trainer;

import java.util.Random;

public class Adventure {
    Logger logger = Logger.getInstance();

    // The 2 trainers
    private Trainer trainer1;
    private Trainer trainer2;

    // The 2 pokemons that fight in the adventure
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public Adventure(Trainer trainer1, Trainer trainer2, Pokemon pokemon1, Pokemon pokemon2) {
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void startAdventure() {
        int result;
        // generates a random arenaType until it gets a versus fight.
        Arena.ArenaType arenaType;
        do {
            arenaType = Arena.ArenaType.values()[new Random().nextInt(Arena.ArenaType.values().length)];
            logger.log("New Arena created, type: " + arenaType);
            Arena arena = new Arena(arenaType, trainer1, trainer2, pokemon1, pokemon2);
            result = arena.fight();
            if(result == -2) {
                logger.log(trainer1 + " lost to a Neutrel\n" + trainer2 + " wins!");
            } if(result == -3) {
                logger.log(trainer2 + " lost to a Neutrel\n" + trainer1 + " wins!");
            }
        } while(arenaType != Arena.ArenaType.Versus);
    }
}
