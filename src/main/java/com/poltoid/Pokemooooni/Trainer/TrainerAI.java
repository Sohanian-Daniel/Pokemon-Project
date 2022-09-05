package com.poltoid.Pokemooooni.Trainer;

import com.poltoid.Pokemooooni.Adventure.Arena;
import com.poltoid.Pokemooooni.Pokemon.Pokemon;

public class TrainerAI implements Runnable {
    final private Arena arena;
    final private Pokemon pokemon;

    boolean myTurn = false;

    public TrainerAI(Arena arena, Pokemon pokemon) {
        this.arena = arena;
        this.pokemon = pokemon;
    }

    synchronized public void signal() {
        notify();
        myTurn = true;
    }

    synchronized public void run() {
        while(true) {
            try {
                while(!myTurn) {
                    wait();
                }
                arena.receiveCommand(pokemon.getCommand());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myTurn = false;
            }
        }
    }
}
