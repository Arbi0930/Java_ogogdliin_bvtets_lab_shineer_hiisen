package biydaalt1;

public class Car {
	private String carID;
    private String owner;
    private String type;

    public Car(String carID, String owner, String type) {
        this.carID = carID;
        this.owner = owner;
        this.type = type;
    }

    public String getCarID() {
        return carID;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }
}
