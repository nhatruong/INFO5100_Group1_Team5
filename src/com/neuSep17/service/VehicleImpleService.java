package com.neuSep17.service;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Iterator;
        import java.io.File;

        import com.neuSep17.dto.Inventory;
        import com.neuSep17.dto.Vehicle;


//THIS CLASS IMPLEMENTS LOGIC TO ACCESS gmps-****-*** files

public class VehicleImpleService {
    //private Vehicle vehicle;
    private HashMap<String, Inventory> allInventory = new HashMap<String, Inventory>();

    public VehicleImpleService() { };

    public VehicleImpleService(File filepath)
    {
        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().contains("gmps-"))
            {
                String dealer = listOfFiles[i].getName();
                Inventory inventory = new Inventory(new File(filepath + "/" + dealer));
                allInventory.put(dealer, inventory);
            }
        }
    }


    public Inventory getAllVehicles(String dealerID){
        return allInventory.get(dealerID);
    }

    public Vehicle getAVehicle(String dealerId, String vehicleIdID) {
        Collection<Vehicle> vehs =  allInventory.get(dealerId).getVehicles();
        Vehicle veh = new Vehicle();
        for (Vehicle v : vehs)
            if (v.getID().equals(vehicleIdID))
            {
                veh = v;
                break;
            }
        return veh;
    }


    public Inventory searchVechile(String dealerID, HashMap<String, String> searchCretiria) throws NoSuchFieldException{
        ArrayList<Vehicle> results = new ArrayList<>();
        Inventory inventory = allInventory.get(dealerID);
        for (Vehicle v : inventory.getVehicles())
        {
            Iterator sc = searchCretiria.entrySet().iterator();
            while (sc.hasNext()) {
                Map.Entry e = (Map.Entry)sc.next();
                Class c = e.getClass();

                switch (e.getKey().toString()) {
                    case "category" :
                        if(v.getCategory().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                    case "year" :
                        String year = e.getValue().toString();
                        if(v.getYear() == Integer.parseInt(year)) {
                            results.add(v);
                        }
                        break;
                    case "make" :
                        if(v.getMake().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                    case "model" :
                        if(v.getModle().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                    case "trim" :
                        if(v.getTrim().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                    case "body type" :
                        if(v.getBodyType().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                    case "price" :
                        String price = e.getValue().toString();
                        if(v.getYear() == Double.parseDouble(price)) {
                            results.add(v);
                        }
                        break;
                    case "photo url" :
                        if(v.getPhotoURL().equals(e.getValue())) {
                            results.add(v);
                        }
                        break;
                }
	    }
        }
        return new Inventory(dealerID,results);
    }

	public boolean addVehicle(String dealerId, Vehicle v) {
		boolean isSuccess =false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	public Boolean updateVehicle(String dealerID, String vehicleID, HashMap<String, String> updateFieldsAndValues) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	public boolean deleteVehicle(String dealerID, String vehicleID) {
		boolean isSuccess=false;
		/**********************************
		*
		*	CODE HERE
		*
		 ************************************/
		return isSuccess;
	}
	
}
