package com.poltoid.Pokemooooni.Items;

public class Item {
    private String name;
    private Integer HPMod;
    private Integer attackMod;
    private Integer specialAttackMod;
    private Integer defMod;
    private Integer specialDefMod;

    public Item() {
        this.name = null;
        this.HPMod = 0;
        this.attackMod = 0;
        this.specialAttackMod = 0;
        this.defMod = 0;
        this.specialDefMod = 0;
    }

    public Integer getHPMod() {
        return HPMod;
    }

    public Integer getAttackMod() {
        return attackMod;
    }

    public Integer getSpecialAttackMod() {
        return specialAttackMod;
    }

    public Integer getDefMod() {
        return defMod;
    }


    public Integer getSpecialDefMod() {
        return specialDefMod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHPMod(Integer HPMod) {
        this.HPMod = HPMod;
    }

    public void setAttackMod(Integer attackMod) {
        this.attackMod = attackMod;
    }

    public void setSpecialAttackMod(Integer specialAttackMod) {
        this.specialAttackMod = specialAttackMod;
    }

    public void setDefMod(Integer defMod) {
        this.defMod = defMod;
    }

    public void setSpecialDefMod(Integer specialDefMod) {
        this.specialDefMod = specialDefMod;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
