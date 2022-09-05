package com.poltoid;

import com.poltoid.Pokemooooni.Adventure.Adventure;
import com.poltoid.Pokemooooni.Adventure.Arena;
import com.poltoid.Pokemooooni.Logger.*;
import com.poltoid.Pokemooooni.Trainer.Trainer;
import org.junit.Test;

public class AppTest 
{
    /**
     * Definitely absolutely 1000% rigorous I swear!
     */
    @Test
    public void Test1()
    {
        Logger logger = Logger.getInstance();
        logger.logToStdOut();
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test1-2/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test1-2/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test2()
    {
        // Same trainers, same Pokemons, checks if results are in fact randomised.
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result2.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test1-2/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test1-2/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test3()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result3.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test3/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test3/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test4()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result4.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test4/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test4/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test5()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result5.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test5/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test5/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test6()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result6.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test6/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test6/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test7()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result7.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test7/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test7/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test8()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result8.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test8/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test8/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test9()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result9.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test9/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test9/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }

    @Test
    public void Test10()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/result10.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/test10/trainer1");

        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/test10/trainer2");

        Adventure adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(0), trainer2.getPokemon(0));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(1), trainer2.getPokemon(1));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getPokemon(2), trainer2.getPokemon(2));
        adventure.startAdventure();

        adventure = new Adventure(trainer1, trainer2, trainer1.getBestPokemon(), trainer2.getBestPokemon());
        adventure.startAdventure();
    }


    @Test
    public void PikachuTest()
    {
        Logger logger = Logger.getInstance();
        logger.logToFile("src/test/out/pikachutest.out");
        Trainer trainer1 = new Trainer();
        trainer1.readTrainer("src/test/trainers/pikachutest/trainer1");
        Trainer trainer2 = new Trainer();
        trainer2.readTrainer("src/test/trainers/pikachutest/trainer1");

        Arena arena = new Arena(Arena.ArenaType.Neutrel1, trainer1, trainer2, trainer1.getPokemon(0), trainer1.getPokemon(0));
        int result = arena.fight();
    }

}
