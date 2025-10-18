package Gladiator;

import java.util.ArrayList;

public class GData {
    private ArrayList<Gladiator> list;

    public GData(){
        this.list = new ArrayList<>();
        list.add(new GladiatorBuilder(0,"Alex",5,1).armor().weaponDamage(20).build());
        list.add(new GladiatorBuilder(1,"Lukas",6,1).armor().build());
    }


    public ArrayList<Gladiator> getList(){
        return this.list;
    }

    public void addToList(Gladiator g) { list.add(g); }
    public void removeFromList(Gladiator g){
        list.remove(g);
    }
    public void removeFromList(int i){
        list.remove(i);
    }
    public Gladiator getByName(String name){
        for(Gladiator g : list){
            if (g.getName().equals(name)){
                return g;
            }
        }
        return null;
    }
    public Gladiator getById(int id){
        return list.get(id);
    }

    public boolean checkName(String name){
        for(Gladiator g : list){
            if (g.getName().equals(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Gladiator g = list.get(i);
            sb.append("[" + i + "] " + g + " (" + (g.getWeaponDamage() != 0 ? " has weapon," : "") + (g.isArmor() ? " has armor " : "") + ")" + " - " + (g.isAlive() ? "alive" : "dead") + "\n");
        }
        return sb.toString();
    }
}
