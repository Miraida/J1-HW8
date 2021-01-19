package com.company.players;

import com.company.game.RPG_Game;

public class Tank extends Hero {
    public Tank(int health, int damage) {
        super(health, damage,SuperAbility.TANK);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int isHeroALife = 0;
        if (RPG_Game.randNumOfThor != 3){
            if (this.getHealth() > 0)
            {
               for (int i = 0; i < heroes.length; i++) {
                  if (heroes[i].getHealth() > 0)
                  {
                      heroes[i].setHealth(heroes[i].getHealth() + 10);
                      isHeroALife += 10;
                  }
               }
               if (this.getHealth() - isHeroALife < 0)
                   this.setHealth(0);
               else this.setHealth(this.getHealth() - isHeroALife);

              if (isHeroALife != 0)
              System.out.println("Tank get damage from Boss and save "+(isHeroALife/10-1) +"  heroes health to 10");
            }
        }
    }
}
