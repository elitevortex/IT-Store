package main.models.devices;
import main.utils.*;

public class Printer extends Device {
    private int ppm = 0;

    public Printer(String newName, String newDescription, int newPpm) throws Exception{
        super(newName, newDescription);
        if(!setPpm(newPpm)) {
            throw new Exception("Incorrect range of ppm");
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
