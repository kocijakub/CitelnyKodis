package Gladiator;

import TryWithResourcesTest.FileManager;

import java.io.IOException;

public class GProcess {


    public static void simulateFight( Gladiator g1, Gladiator g2){
        System.out.println("A BATTLE IS STARTING");
        System.out.println(g1 + " vs " + g2 + "\n");
        while(g1.isAlive() && g2.isAlive()){
            attack(g1,g2);
            if(!g2.isAlive()){
                System.out.println("\n" + g1 + " WON THE BATTLE");
                logFight(g1.getName(),g2.getName(),g1.getName());
                break;
            }
            attack(g2,g1);
            if(!g1.isAlive()){
                System.out.println(g2 + " WON THE BATTLE");
                logFight(g1.getName(),g2.getName(),g2.getName());
                break;
            }
            battleStatus(g1,g2);

        }
    }
    private static void battleStatus(Gladiator g1, Gladiator g2){
        System.out.println("STATUS:\n" + g1.getName() + ": " + g1.getHealth() + "HP\n" + g2.getName() + ": " + g2.getHealth() + "HP");
    }

    private static void logFight(String g1, String g2, String winner){
        try(FileManager fm = new FileManager("GladiatorFightLog.txt")){
            fm.write(g1 + " VS " + g2 + " => " + winner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static void attack(Gladiator attacker, Gladiator defender){
        System.out.println(defender.getName() + " health -" + attacker.getWholeDamage());
        int attackDamage = defender.isArmor() ? attacker.getWholeDamage() / 2 : attacker.getWholeDamage();
        defender.setHealth(defender.getHealth() - attackDamage);
    }
}
