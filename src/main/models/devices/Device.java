package main.models.devices;
import main.utils.Utils;

abstract public class Device {
    private int id;
    private String name;
    private String description;

    // 2 Param construct
    public Device(String newName, String newDescription){
        try {
            setName(newName);
            setDescription(newDescription);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

        }
    }

    // Getters
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return description;
    }

    // Setters
    public void setId(int newId){
        this.id = newId;
    }

    public boolean setName(String newName){
        if ((Utils.stringInRange(newName, 3, 15) == true) ){
            this.name = newName;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setDescription(String newDescription){
        if ((Utils.stringInRange(newDescription, 5, 20) == true)){
            this.description = newDescription;
            return true;
        }
        else{
            return false;
        }
    }

    public abstract int generateId();
//
    // To string method
    public String toString(){
      return "| name: " + this.getName() + " | description: " + this.getDescription() + " | ";
    }

}
