package models;

abstract public class Device {
    private int id;
    private String name;
    private String description;

    // 2 Param construct
    public Device(String newName, String newDescription){
        this.name = newName;
        this.description = newDescription;
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

    public void setName(String newName){
        this.name = newName;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    public abstract int generateId();
//
    // To string method
    public String toString(){
      return "| name: " + this.getName() + " | description: " + this.getDescription() + " | ";
    }

}
