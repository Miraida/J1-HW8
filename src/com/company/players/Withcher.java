package com.company.players;

public class Withcher extends Hero {
    public Withcher(int health, int damage) {
        super(health, damage,SuperAbility.WITCHER);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
          if (this.getHealth() > 0){
              for (int i = 0; i <heroes.length ; i++) {
                  if (heroes[i].getHealth() == 0 && heroes[i] != this){
                      heroes[i].setHealth(heroes[i].getHealth()+this.getHealth());
                      this.setHealth(0);
                      System.out.println("Witcher gave his life to "+heroes[i].getClass().getSimpleName());
                      break;
                  }
              }
          }
    }
}
