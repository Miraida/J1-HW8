package com.company.players;

import com.company.game.RPG_Game;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage) {
        super(health, damage,SuperAbility.STUN);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

       // System.out.println("Thor randNUM is: "+randNum);
        if (this.getHealth() > 0 && RPG_Game.randNumOfThor == 3){
            for (int i = 0; i < heroes.length ; i++) {
                if (heroes[i].getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth()+50);
            }
            System.out.println("Thor stuned Boss!!!");
        }
    }
}
