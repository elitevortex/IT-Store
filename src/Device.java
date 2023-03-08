public class Device {
    private String name;
    private String description;

    // 2 Param construct
    public Device(String newName, String newDescription){
        this.name = newName;
        this.description = newDescription;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return description;
    }

    // Setters
    public void setName(String newName){
        this.name = newName;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    // To string method
    public String toString(){
      return "| name: " + this.getName() + " | description: " + this.getDescription() + " | ";
    }

}
