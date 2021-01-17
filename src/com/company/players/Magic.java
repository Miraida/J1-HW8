package com.company.players;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage,SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0){
            for (int i = 0; i < heroes.length ; i++) {
                if (heroes[i].getHealth() > 0  && !heroes[i].getClass().getSimpleName().equals("Witcher") && !heroes[i].getClass().getSimpleName().equals("Medic")){
                    heroes[i].setDamage(heroes[i].getDamage()+2);
                }
            }
            System.out.println("Magic increase damage of Heroes to 2");
        }
    }
}
