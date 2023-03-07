public class Computer extends Device {
    private String manufacture;


    public Computer(String newName, String newDescription, String newManufacture){
        super(newName, newDescription);
        this.manufacture = newManufacture;
    }

    // Getters
    public String getName(){
        return super.getName();
    }

    public String getDescription(){
        return super.getDescription();
    }

    public String getManufacture(){
        return this.manufacture;
    }

    // Setters
    public void setName(String newName){
        super.setName(newName);
    }

    public void setDescription(String newDescription){
        super.setDescription(newDescription);
    }

    public void setManufacture(String newManufacture){
        this.manufacture = newManufacture;
    }

    // toString concatinated with unique attribute
    public String toString(){
        return super.toString() + "manufacture: " + getManufacture();
    }


}
