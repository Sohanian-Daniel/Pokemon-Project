package com.poltoid.Pokemooooni.Trainer;

import com.poltoid.Pokemooooni.Items.Item;
import com.poltoid.Pokemooooni.Items.ItemFactory;
import com.poltoid.Pokemooooni.Pokemon.Pokemon;
import com.poltoid.Pokemooooni.Pokemon.PokemonFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private Integer age;
    private List<Pokemon> pokemons;
    private List<Item> items;

    public List<Item> getItems() {
        List<Item> toEquip = new ArrayList<>();
        Random random = new Random();
        // gives up to 3 random numbers from 0 to items.size
        List<Integer> randomNumbers = random.ints(0, items.size())
                .distinct().limit(Math.min(3, items.size())).boxed().collect(Collectors.toList());
        for(Integer i:randomNumbers) {
            toEquip.add(items.get(i));
        }
        return toEquip;
    }

    public void readTrainer(String fileName) {
        File file = new File(fileName);
        this.pokemons = new ArrayList<>();
        this.items = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            this.name = br.readLine();
            this.age = Integer.parseInt(br.readLine());
            String[] pokemonList = br.readLine().split(", ");
            PokemonFactory pokemonFactory = PokemonFactory.getInstance();
            for(String pokemon:pokemonList) {
               this.pokemons.add(pokemonFactory.createPokemon(pokemon));
            }

            String[] itemList = br.readLine().split(", ");
            ItemFactory itemFactory = ItemFactory.getInstance();
            for(String item:itemList) {
                this.items.add(itemFactory.createItem(item));
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return name + " Age:" + age;
    }

    public Pokemon getPokemon(int index) {
        return pokemons.get(index);
    }

    public Pokemon getBestPokemon() {
        Pokemon bestPokemon = null;
        int max = 0;
        for(Pokemon pokemon:this.pokemons) {
            if(pokemon.statTotal() > max) {
                bestPokemon = pokemon;
                max = pokemon.statTotal();
            }
            // lexicographic order
            if(pokemon.statTotal() == max) {
               if(pokemon.getName().compareTo(bestPokemon.getName()) < 0) bestPokemon = pokemon;
           }
        }
        return bestPokemon;
    }
}
