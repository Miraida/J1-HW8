package com.company.players;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage,SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0 ){
            if (boss.getHealth()-25 <= 0) boss.setHealth(0);
            else boss.setHealth(boss.getHealth()-25);
        }
    }
}
