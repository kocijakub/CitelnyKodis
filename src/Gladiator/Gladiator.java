package Gladiator;

public class Gladiator {

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public int getWholeDamage(){
        return damage + weaponDamage;
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }

    public boolean isArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    private int id;
    private String name;
    private int health;
    private int damage;
    private int weaponDamage;
    private boolean armor;

    public Gladiator(int id, String name, int health, int weaponDamage, boolean armor){
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = 5;
        this.weaponDamage = weaponDamage;
        this.armor = armor;
    }

    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
