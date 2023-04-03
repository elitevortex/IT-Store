package main.models.devices;
import main.utils.*;

public class Printer extends Device {
    private int ppm;

    public Printer(String newName, String newDescription, int newPpm){
        super(newName, newDescription);

        try{
            setPpm(newPpm);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        setId(generateId());

    }

    public int getPpm() {
        return this.ppm;
    }

    public boolean setPpm(int newPpm){
        if ((Utils.intInRange(newPpm, 5, 20) == true)){
            this.ppm = newPpm;
            return true;
        }
        else{
            return false;
        }
    }

    public int generateId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100, 999);

    }

    public String toString(){
        return super.toString() + "PPM: " + getPpm();
    }
}
