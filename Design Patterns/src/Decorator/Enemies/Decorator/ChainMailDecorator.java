package Decorator.Enemies.Decorator;

import Decorator.Enemies.Enemy;

/**
 * Created by Owner on 2/10/2017.
 */
public class ChainMailDecorator extends EnemyDecorator {

    public ChainMailDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public int getArmor() {
        return super.getArmor() + 20;
    }


}
