package Decorator.Enemies;

/**
 * Created by Owner on 2/10/2017.
 */
public class Paladin implements Enemy {
    @Override
    public int getHealth() {
        return 200;
    }

    @Override
    public int getArmor() {
        return 100;
    }

    @Override
    public String getWeapons() {
        return "Sword and Shield";
    }
}
