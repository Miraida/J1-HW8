package com.company.game;

import com.company.players.*;

import java.util.Random;

public class RPG_Game {
     static int s = 1;
   public  static int randNumOfThor;
    public static void start(){
        Boss boss = new Boss(700,50);
        Warrior warrior = new Warrior(250,10);
        Golem golem = new Golem(260,10);
        Medic medic = new Medic(230,0,30);
        Magic magic = new Magic(270,10);
        Thor thor = new Thor(280,5);
        Tank tank = new Tank(300,2);
        Withcher withcher = new Withcher(290,0);
        Hero[] heroes = {warrior,golem,magic,medic,thor,tank,withcher};

        printStatistics(boss,heroes);
        while (!isFinished(boss,heroes)){
            round(boss,heroes);
        }
    }
    private static void round(Boss boss, Hero[] heroes){
        System.out.println(s+" round was started!!!");

        Random random = new Random();
        randNumOfThor = random.nextInt(5);

        bossHits(boss,heroes);
        heroesHits(boss,heroes);
        applySuper(boss,heroes);

        printStatistics(boss,heroes);
        s++;

    }
    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Boss health: "+boss.getHealth());
        for (int i = 0; i <heroes.length ; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()+" health: "+heroes[i].getHealth());
        }
        System.out.println("___________________________________");
        System.out.println();
    }

    private static Boolean isFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;}
        }
        if (allHeroesDead) System.out.println("Boss won!!!");

        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0)
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i].getHealth() - boss.getDamage() <= 0) heroes[i].setHealth(0);
                else heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }


    }
    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                if (boss.getHealth()-heroes[i].getDamage() <= 0){ boss.setHealth(0); }
                else boss.setHealth(boss.getHealth()- heroes[i].getDamage());
            }
        }
    }
    private static void applySuper(Boss boss, Hero[] heroes){
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0){
                heroes[i].applySuperAbility(boss,heroes);
            }
        }
    }

}
