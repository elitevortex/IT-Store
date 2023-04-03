package main.models.devices;
import main.models.devices.Device;
import main.utils.*;

public class Computer extends Device {
    private String manufacture;


    public Computer(String newName, String newDescription, String newManufacture) throws Exception {
        super(newName, newDescription);

        if (setManufacture(newManufacture)){
            // TODO
        }
        else{
            throw new Exception("Incorrect manufacture length");
        }
        setId(generateId());
    }

    public String getManufacture(){
        return this.manufacture;
    }

    public boolean setManufacture(String newManufacture){
        if ((Utils.stringInRange(newManufacture, 3, 15) == true)){
            this.manufacture = newManufacture;
            return true;
        }
        else{
            return false;
        }
    }

    public int generateId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100000, 9999999);
    }

    // toString concatinated with unique attribute
    public String toString(){
        return super.toString() + "manufacture: " + getManufacture();
    }


}
