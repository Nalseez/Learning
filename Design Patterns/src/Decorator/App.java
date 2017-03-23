package Decorator;

import Decorator.Enemies.Decorator.ChainMailDecorator;
import Decorator.Enemies.Decorator.ExtraHealthDecorator;
import Decorator.Enemies.Enemy;
import Decorator.Enemies.Orc;
import Decorator.Enemies.Paladin;

/**
 * Created by Nalseez on 2/10/2017.
 */
public class App {

    public static void main(String[] args) {
        Enemy orcWithExtraHealth = new ExtraHealthDecorator(new Orc());
        System.out.print("OrcWithExtraHealth: ");
        System.out.println(orcWithExtraHealth);

        Enemy orcWithExtraHealthAndChainMail = new ChainMailDecorator(new ExtraHealthDecorator(new Orc()));
        System.out.print("OrcWithExtraHealthAndChainMail: ");
        System.out.println(orcWithExtraHealthAndChainMail);

        Enemy paladinWithExtraHealthAndChainMail = new ChainMailDecorator(new ExtraHealthDecorator(new Paladin()));

        System.out.print("PaladinWithExtraHealthAndChainMail: ");
        System.out.println(paladinWithExtraHealthAndChainMail);
    }

}
