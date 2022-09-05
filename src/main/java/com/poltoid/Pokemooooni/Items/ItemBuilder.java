package com.poltoid.Pokemooooni.Items;

public class ItemBuilder {
    Item item;
    public ItemBuilder() {
        item = new Item();
    }

    public ItemBuilder setName(String name) {
        item.setName(name);
        return this;
    }

    public ItemBuilder setHP(Integer value) {
        item.setHPMod(value);
        return this;
    }

    public ItemBuilder setAttack(Integer value) {
        item.setAttackMod(value);
        return this;
    }

    public ItemBuilder setSpecialAttack(Integer value) {
        item.setSpecialAttackMod(value);
        return this;
    }

    public ItemBuilder setDef(Integer value) {
        item.setDefMod(value);
        return this;
    }

    public ItemBuilder setSpecialDef(Integer value) {
        item.setSpecialDefMod(value);
        return this;
    }

    public Item getItem() { return item; }
}
