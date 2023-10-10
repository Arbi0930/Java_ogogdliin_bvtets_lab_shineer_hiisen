package biydaalt1;

import java.util.HashMap;
import java.util.Map;

import dataStructures.ArrayLinearList;

public class ParkingLot{

	private Map<String, Car> parkingMap;

    public ParkingLot() {
        this.parkingMap = new HashMap<String, Car>();
    }

    public void parkCar(String parkingNumber, Car car) {
        parkingMap.put(parkingNumber, car);
    }

    public void removeCar(String parkingNumber) {
        parkingMap.remove(parkingNumber);
    }

    public Car findCar(String carID) {
        for (Map.Entry<String, Car> entry : parkingMap.entrySet()) {
            if (entry.getValue().getCarID().equals(carID)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void printParkingLot() {
        for (Map.Entry<String, Car> entry : parkingMap.entrySet()) {
            System.out.println("Slot ID: " + entry.getKey() +
                    "; Car ID: " + entry.getValue().getCarID() +
                    "; Owner: " + entry.getValue().getOwner() +
                    "; Type: " + entry.getValue().getType());
        }
    }
}
