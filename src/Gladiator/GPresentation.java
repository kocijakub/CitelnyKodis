package Gladiator;

import java.util.Scanner;

public class GPresentation {
    private static int idCount = 1;
    private static final GData data = new GData();
    private static final Scanner scan = new Scanner(System.in);

    public static void simulateArenaGame(){
        System.out.println("Welcome to Gladiator Fights!");
        while(true){
            System.out.println("""
                    Choose your action:
                    [1] - add gladiator
                    [2] - remove gladiator
                    [3] - show a list of gladiators
                    [4] - simulate fight
                    [5] - exit program
                    """);

            try{
                switch (scan.nextInt()){
                    case 1 -> addGladiator();
                    case 2 -> removeGladiator();
                    case 3 -> getListOfGladiators();
                    case 4 -> simulateFight();
                    case 5 -> System.exit(0);
                }
            }catch (RuntimeException e){
                System.out.println("Invalid input");
            }
        }


    }

    private static void addGladiator(){
        scan.nextLine();

        String name;
        int health = 0;
        int damage = 0;
        int wDamage = 0;
        boolean armor = false;
        Gladiator g;
        System.out.println("Select a name for your warrior.");
        while(true){
            name = scan.nextLine();
            if(data.checkName(name) && name != null){
                break;
            }
            System.out.println("Name already exists among the warrior, try another one.");
        }

        System.out.println("Set health to warrior " + name);
        try{
            health = scan.nextInt();
        }catch (RuntimeException e){
            System.out.println("Invalid input.");
        }

        System.out.println("Set damage to warrior " + name);
        try{
            damage = scan.nextInt();
        }catch (RuntimeException e){
            System.out.println("Invalid input.");
        }

        System.out.println("Do you want to set a weapon to " + name + "?\n[1] - yes, [0] - no");
        boolean question = false;
        try{
            if(scan.nextInt() == 1){
                question = true;
            }
        }catch (RuntimeException e){
            System.out.println("Invalid input.");
        }
        if(question){
            System.out.println("Set weapon damage to warrior " + name);
            try{
                wDamage = scan.nextInt();
            }catch (RuntimeException e){
                System.out.println("Invalid input.");
            }
        }

        System.out.println("Do you want " + name + "to have an armor?\n[1] - yes, [0] - no");
        try{
            if(scan.nextInt() == 1){
                armor = true;
            }
        }catch (RuntimeException e){
            System.out.println("Invalid input.");
        }

        if(wDamage != 0 && armor){
            g = new GladiatorBuilder(idCount,name,health,damage).weaponDamage(wDamage).armor().build();
        }
        else if(wDamage != 0){
            g = new GladiatorBuilder(idCount,name,health,damage).weaponDamage(wDamage).build();
        }
        else if(armor){
            g = new GladiatorBuilder(idCount,name,health,damage).armor().build();
        }
        else{
            g = new GladiatorBuilder(idCount,name,health,damage).build();
        }
        idCount++;
        System.out.println("A new warrior has been created.");
        data.addToList(g);
    }
    private static void removeGladiator(){
        scan.nextLine();
        Gladiator g;
        while(true){
            System.out.println("Select a fighter you want to remove\n" + data);
            try{
                g = data.getById(scan.nextInt());
                data.removeFromList(g);
                System.out.println("Gladiator " + g.getName() + " was removed");
                break;
            }catch (RuntimeException e){
                System.out.println("Invalid input.");
            }
        }

    }
    private static void getListOfGladiators(){
        System.out.println(data);
    }

    private static void simulateFight(){
        scan.nextLine();
        Gladiator g1;
        Gladiator g2;
        while(true){
            System.out.println("Select the first figher\n");
            getListOfGladiators();
            try{
                g1 = data.getById(scan.nextInt());
                if(!g1.isAlive()){
                    System.out.println("This gladiator is dead, use another one");
                }
                else{
                    break;
                }
            }catch (RuntimeException e){
                System.out.println("Invalid input.");
            }
        }
        while(true){
            System.out.println("Select the second figher\n");
            getListOfGladiators();
            try{
                g2 = data.getById(scan.nextInt());
                if(!g2.isAlive()){
                    System.out.println("This gladiator is dead, choose another one");
                }
                else if(g1.equals(g2)){
                    System.out.println("You already selected this gladiator, choose another one");
                }
                else{
                    break;
                }
            }catch (RuntimeException e){
                System.out.println("Invalid input.");
            }
        }
        GProcess.simulateFight(g1,g2);
    }
}
