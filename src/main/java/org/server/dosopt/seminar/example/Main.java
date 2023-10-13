package org.server.dosopt.seminar.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Poketmon pikachu = new Poketmon("피카츄",PoketmonType.ELECTRIC);
        System.out.println(pikachu.getName());
        System.out.println(pikachu.getType());


    }
}