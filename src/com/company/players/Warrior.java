package com.company.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage,SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] hero) {
        Random random = new Random();
        int randNum = random.nextInt(2)+2;
        this.setDamage(10);
        this.setDamage(this.getDamage() * randNum);
        System.out.println("Warrior damage "+this.getDamage()+" randNum: "+randNum);
    }
}
