package com.poltoid.Pokemooooni.Items;

public class ItemFactory {
    private static ItemFactory instance;

    private ItemFactory() {}

    public static ItemFactory getInstance() {
        if(instance == null) instance = new ItemFactory();
        return instance;
    }

    public enum TypeItem {
        Scut, Vesta, Sabiuta, Bagheta, Vitamine, Brad, Pelerina
    }

    public Item createItem(String item) {
        TypeItem typeItem = ItemFactory.TypeItem.valueOf(item);
        switch(typeItem) {
            case Scut:
                return new ItemBuilder()
                        .setName(item)
                        .setDef(2)
                        .setSpecialDef(2)
                        .getItem();
            case Vesta:
                return new ItemBuilder()
                        .setName(item)
                        .setHP(10)
                        .getItem();
            case Sabiuta:
                return new ItemBuilder()
                    .setName(item)
                    .setAttack(3)
                    .getItem();
            case Vitamine:
                return new ItemBuilder()
                        .setName(item)
                        .setHP(2)
                        .setAttack(2)
                        .setSpecialAttack(2)
                        .getItem();
            case Bagheta:
                return new ItemBuilder()
                        .setName(item)
                        .setSpecialAttack(3)
                        .getItem();
            case Brad:
                return new ItemBuilder()
                        .setName(item)
                        .setAttack(3)
                        .setDef(1)
                        .getItem();
            case Pelerina:
                return new ItemBuilder()
                        .setName(item)
                        .setSpecialDef(3)
                        .getItem();

        }
        throw new IllegalArgumentException("Unknown item type " + item);
    }

}
