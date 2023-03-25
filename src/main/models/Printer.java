package main.models;
import main.utils.*;

public class Printer extends Device {
    private int ppm;

    public Printer(String newName, String newDescription,
                   int newPpm){
        super(newName, newDescription);
        this.ppm = newPpm;
        setId(generateId());

    }
    public String getName(){
        return super.getName();
    }

    public String getDescription(){
        return super.getDescription();
    }

    public int getPpm() {
        return this.ppm;
    }

    public void setName(String newName){
        super.setName(newName);
    }

    public void setDescription(String newDescription) {
        super.setDescription(newDescription);
    }

    public void setPpm(int newPpm){
        this.ppm = newPpm;
    }

    public int generateId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100, 999);

    }

    public String toString(){
        return super.toString() + "PPM: " + getPpm();
    }
}
