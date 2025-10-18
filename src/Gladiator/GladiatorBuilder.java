package Gladiator;

public class GladiatorBuilder {

    private int id;
    private String name;
    private int health;
    private int damage;

    private int weaponDamage = 0;
    private boolean armor = false;

    public GladiatorBuilder(int id, String name, int health, int damage){
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    public GladiatorBuilder weaponDamage(int dmg){
        this.weaponDamage = dmg;
        return this;
    }
    public GladiatorBuilder armor(){
        this.armor = true;
        return this;
    }

    public Gladiator build(){
        return new Gladiator(id, name, health,weaponDamage,armor);
    }
}
