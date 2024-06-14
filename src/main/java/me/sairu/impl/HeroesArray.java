package me.sairu.impl;

public class HeroesArray implements Vector{

    private final String[] heroes;

    private int lastIndex;

    public HeroesArray(final int size) {

        heroes = new String[size];
        lastIndex = -1;
    }

    @Override
    public void add(final String hero) {
        if(lastIndex == this.heroes.length-1){
            System.err.println("Array is full");
        } else {
            lastIndex++;
            heroes[lastIndex] = hero;
        }
    }

    @Override
    public void print() {
        System.out.println("##########################################");
        if(lastIndex < 0){
            System.out.println("Array is empty");
            return;
        }
        for (int i = 0; i <= lastIndex; i++) {
            System.out.println(heroes[i]);
        }
        System.out.println("##########################################");

    }

    @Override
    public void remove(int index) {
        if(index >= 0 && index < lastIndex){
            shift(index);
            lastIndex--;
        }else {
            System.err.println("Invalid index");
        }
    }

    private void shift(final int index) {
        for (int i = index; i < lastIndex; i++) {
            heroes[i] = heroes[i+1];
        }
        heroes[lastIndex] = null;
    }
}
