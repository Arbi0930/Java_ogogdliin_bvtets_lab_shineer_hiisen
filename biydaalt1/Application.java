package biydaalt1;

import java.io.File;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();

        while (true) {
            System.out.println("Цэс:");
            System.out.println("1. Бүх зогсоолыг хэвлэх");
            System.out.println("2. Машинаа тавих");
            System.out.println("3. Машин хайх");
            System.out.println("4. Шинэ зогсоол нэмнэ үү");
            System.out.println("5. Зогсоолыг устгах");
            System.out.println("6. Машин гаргах");
            System.out.println("7. Гарах");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    parkingLot.printParkingLot();
                    break;
                case 2:
                    System.out.println("Зогсоолын дугаар оруулна уу:");
                    String parkingNumber = scanner.nextLine();
                    System.out.println("Машины ID-г оруулна уу:");
                    String carID = scanner.nextLine();
                    System.out.println("Эзэмшигчийг оруулна уу:");
                    String owner = scanner.nextLine();
                    System.out.println("Машины төрлийг оруулна уу:");
                    String type = scanner.nextLine();
                    parkingLot.parkCar(parkingNumber, new Car(carID, owner, type));
                    break;
                case 3:
                    System.out.println("Хайх машины ID-г оруулна уу:");
                    String searchCarID = scanner.nextLine();
                    Car foundCar = parkingLot.findCar(searchCarID);
                    if (foundCar != null) {
                        System.out.println("Машин олдсон - Слот ID: " + searchCarID +
                                "; Машины ID: " + foundCar.getCarID() +
                                "; Эзэмшигч: " + foundCar.getOwner() +
                                "; Төрөл: " + foundCar.getType());
                    } else {
                        System.out.println("Машин олдсонгүй.");
                    }
                    break;
                case 4:
                    System.out.println("Шинэ зогсоолын дугаар оруулна уу:");
                    String newParkingNumber = scanner.nextLine();
                    System.out.println("Шинэ машины ID оруулна уу:");
                    String newCarID = scanner.nextLine();
                    System.out.println("Шинэ эзэмшигчийг оруулна уу:");
                    String newOwner = scanner.nextLine();
                    System.out.println("Шинэ машины төрлийг оруулна уу:");
                    String newType = scanner.nextLine();
                    parkingLot.parkCar(newParkingNumber, new Car(newCarID, newOwner, newType));
                    System.out.println("Шинэ зогсоол амжилттай нэмэгдсэн.");
                    break;
                case 5:
                    System.out.println("Устгахын тулд зогсоолын дугаар оруулна уу:");
                    String deleteParkingNumber = scanner.nextLine();
                    if (parkingLot.findCar(deleteParkingNumber) == null) {
                        parkingLot.removeCar(deleteParkingNumber);
                        System.out.println("Машины зогсоолыг амжилттай устгасан.");
                    } else {
                        System.out.println("Устгах боломжгүй. Зогсоол нь машинтай.");
                    }
                    break;
                case 6:
                    System.out.println("Гарах машины ID-г оруулна уу:");
                    String takeOutCarID = scanner.nextLine();
                    Car carToTakeOut = parkingLot.findCar(takeOutCarID);
                    if (carToTakeOut != null) {
                        parkingLot.removeCar(takeOutCarID);
                        System.out.println("Машин гарлаа.");
                    } else {
                        System.out.println("Зогсоолоос машин олдсонгүй.");
                    }
                    break;
                case 7:
                    System.out.println("EASY PEAZY");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
