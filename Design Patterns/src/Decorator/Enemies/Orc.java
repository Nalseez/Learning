package Decorator.Enemies;

/**
 * Created by Owner on 2/10/2017.
 */
public class Orc implements Enemy {
    @Override
    public int getHealth() {
        return 50;
    }

    @Override
    public int getArmor() {
        return 20;
    }

    @Override
    public String getWeapons() {
        return "Club";
    }


}
