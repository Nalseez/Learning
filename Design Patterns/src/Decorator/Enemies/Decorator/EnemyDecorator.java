package Decorator.Enemies.Decorator;

import Decorator.Enemies.Enemy;

/**
 * Created by Owner on 2/10/2017.
 */
public abstract class EnemyDecorator implements Enemy {

    private Enemy enemy;

    public EnemyDecorator(Enemy enemy){
        this.enemy = enemy;
    }

    @Override
    public int getHealth() {
        return enemy.getHealth();
    }

    @Override
    public int getArmor() {
        return enemy.getArmor();
    }

    @Override
    public String getWeapons() {
        return enemy.getWeapons();
    }

    @Override
    public String toString(){
        return "Health: " + this.getHealth() + ", Armor: " + this.getArmor() + ", Weapons: " + this.getWeapons();
    }
}
