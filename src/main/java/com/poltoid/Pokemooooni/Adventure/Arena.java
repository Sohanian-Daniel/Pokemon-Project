package com.poltoid.Pokemooooni.Adventure;

import com.poltoid.Pokemooooni.Logger.Logger;
import com.poltoid.Pokemooooni.Pokemon.Pokemon;
import com.poltoid.Pokemooooni.Pokemon.PokemonFactory;
import com.poltoid.Pokemooooni.Pokemon.pokemonCommands.*;
import com.poltoid.Pokemooooni.Trainer.Trainer;
import com.poltoid.Pokemooooni.Trainer.TrainerAI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Arena {
    Logger logger = Logger.getInstance();

    private ArenaType type;

    // The 2 trainers, trainer 2 might not exist.
    private Trainer trainer1;
    private Trainer trainer2;

    // The 2 pokemons that fight in the arena
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon neutrel;

    private PokemonCommand trainerCommand;


    public enum ArenaType {
        Neutrel1, Neutrel2, Versus
    }

    public Arena(ArenaType type, Trainer trainer1, Trainer trainer2, Pokemon pokemon1, Pokemon pokemon2) {
        this.type = type;
        this.trainer1 = trainer1;
        this.trainer2 = trainer2;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public int fight() {
        // -2 trainer1 lost to neutrel
        // -3 trainer 2 lost to neutrel
        // -1 trainer2 wins, 0 draw, 1 trainer1 wins
        int result = 0;
        PokemonFactory factory = PokemonFactory.getInstance();
        switch(type) {
            case Neutrel1:
                neutrel = factory.createPokemon("Neutrel1");
                if(!neutrelFight(pokemon1, trainer1)) return -2;
                if(!neutrelFight(pokemon2, trainer2)) return -3;
                break;
            case Neutrel2:
                neutrel = factory.createPokemon("Neutrel2");
                if(!neutrelFight(pokemon1, trainer1)) return -2;
                if(!neutrelFight(pokemon2, trainer2)) return -3;
                break;
            case Versus:
                result = versusFight();
                break;
        }
        return result;
    }

    private boolean neutrelFight(Pokemon pokemon, Trainer trainer) {
        logger.log("Trainer " + trainer + " has encountered a " + neutrel.getName() + "!");
        logger.log(pokemon.getName() + " vs " + neutrel.getName());
        Pokemon pokemon1Clone = pokemon.clone();
        Pokemon neutrelClone = neutrel.clone();
        pokemon1Clone.applyItems(trainer1.getItems());
        // this assumes its a Neutrel fight so Pokemon1 cannot be stunned.
        PokemonCommand pokemonCommand2 = new PokemonAttackCommand(neutrelClone);

        // initial status
        logger.log(pokemon1Clone + "\n" + neutrelClone);
        // while both are alive they game
        while(pokemon1Clone.isAlive() && neutrelClone.isAlive()) {
            pokemon1Clone.updateStatus();

            pokemon1Clone.getCommand().execute(neutrelClone);

            if(!neutrelClone.isStunned()) {
                pokemonCommand2.execute(pokemon1Clone);
            }
            else {
                logger.log(neutrelClone.getName() + " is Stunned!");
                neutrelClone.setStunned(false);
            }

            // log status
            logger.log(pokemon1Clone + "\n" + neutrelClone);
        }
        // determine winner, stats, etc
        if(pokemon1Clone.isAlive()) {
            // we want to level up the "baseline" pokemon
            logger.log("Winner is " + pokemon.getName() + "\n");
            pokemon.levelUp();
            return true;
        } else if(neutrelClone.isAlive()) {
            logger.log("Winner is " + neutrelClone.getName() + "\n");
            logger.log(pokemon + " really just lost to a Neutrel... damn...");
            return false;
        } else {
            logger.log("Draw");
            return true;
        }
    }

    synchronized public void receiveCommand(PokemonCommand command) {
        trainerCommand = command;
        notify();
    }

    synchronized private int versusFight() {
        logger.log("Trainer " + trainer1 + " is butting heads against " + trainer2 + "!\nWho will win?");
        logger.log(pokemon1.getName() + " vs " + pokemon2.getName());
        Pokemon pokemon1Clone = pokemon1.clone();
        Pokemon pokemon2Clone = pokemon2.clone();

        pokemon1Clone.applyItems(trainer1.getItems());
        pokemon2Clone.applyItems(trainer2.getItems());

        TrainerAI trainerAI1 = new TrainerAI(this, pokemon1Clone);
        TrainerAI trainerAI2 = new TrainerAI(this, pokemon2Clone);

        // Players connected to server
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(trainerAI1);
        executor.execute(trainerAI2);

        logger.log(pokemon1Clone + "\n" + pokemon2Clone);

        while(pokemon1Clone.isAlive() && pokemon2Clone.isAlive()) {
            // Update cooldowns
            pokemon1Clone.updateStatus();
            pokemon2Clone.updateStatus();

            // Wait for actions from players and resolve their actions.
            resolveAction(pokemon2Clone, pokemon1Clone, trainerAI1);
            resolveAction(pokemon1Clone, pokemon2Clone, trainerAI2);

            // Log status of pokemons
            logger.log(pokemon1Clone + "\n" + pokemon2Clone);
        }
        // Match is over
        executor.shutdown();
        if(pokemon1Clone.isAlive()) {
            // we want to level up the "baseline" pokemon
            logger.log("Winner is " + pokemon1.getName());
            pokemon1.levelUp();
            return 1;
        } else if(pokemon2Clone.isAlive()) {
            logger.log("Winner is " + pokemon2.getName());
            pokemon2.levelUp();
            return -1;
        } else {
            logger.log("Draw");
            return 0;
        }
    }

    private void resolveAction(Pokemon pokemon1Clone, Pokemon pokemon2Clone, TrainerAI trainerAI) {
        trainerAI.signal();
        try {
            wait();
            // Check for stuns
            if(!pokemon2Clone.isStunned()) {
                trainerCommand.execute(pokemon1Clone);
            }
            else {
                pokemon2Clone.setStunned(false);
                logger.log(pokemon2Clone.getName() + " is Stunned!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
