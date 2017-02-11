package Decorator.Enemies.Decorator;

import Decorator.Enemies.Enemy;

/**
 * Created by Owner on 2/10/2017.
 */
public class ExtraHealthDecorator extends EnemyDecorator {

    public ExtraHealthDecorator(Enemy enemy) {
        super(enemy);
    }

    @Override
    public int getHealth() {
        return super.getHealth() + 20;
    }

}
