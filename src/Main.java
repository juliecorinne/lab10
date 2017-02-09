import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int carPick;
        String userInput;

        System.out.println("Here's a fancy list of cars for your viewing pleasure!");
        System.out.println();
        ArrayList<Car> carList = new ArrayList<Car>();

        listOfCars(carList);

        do {

            displayCars(carList);
            System.out.println();

            System.out.println("Which car would you like?");
            carPick = rangeValidator();

            System.out.println(carList.get(carPick - 1));
            //extracts the line the user selected
            System.out.println();

            System.out.println("Would you like to buy this car? y/n");
            userInput = scan.nextLine();

            askToBuyCar(carPick, userInput, carList);

            System.out.println("Do you want to continue? y/n");
            userInput = scan.nextLine();
        } while (userInput.equalsIgnoreCase("y"));

        System.out.println();
        System.out.println("Goodbye!");

    }

    public static void listOfCars(ArrayList<Car> carList) {

        carList.add(new Car("Ford", "Explorer", 2016, 27999.99));
        carList.add(new Car("Chevrolet", "Cruze", 2017, 21999.99));
        carList.add(new Car("Buick", "Envision", 2017, 60999.99));
        carList.add(new UsedCar("Chevrolet", "Silverado", 2000, 10899.99, 70000));
        carList.add(new UsedCar("Ford", "Escape", 2007, 12890.99, 50000));
        carList.add(new UsedCar("Chevrolet", "Corvette", 2005, 15999.99, 12000));

    }

    public static void askToBuyCar(int carPick, String userInput, ArrayList<Car> carList) {

        if (userInput.equalsIgnoreCase("y")) {

            System.out.println("Excellent! Our finance department will be in touch shortly.");
            System.out.println();
            carList.remove(carPick - 1);
            //removes the car that the user selected yes to purchase
            displayCars(carList);
            System.out.println();

        } else {

            System.out.println();
            System.out.println("Fine. We didn't want you to buy a car anyway.");
            System.out.println("Buh-Bye now.");
            System.out.println();

        }

        //above if else statement determines if user wants to buy car, then asks if they want to continue
    }

    public static void displayCars(ArrayList<Car> carList) {

        for (int i = 0; i < carList.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, carList.get(i).toString());
        }

        //formats and displays the number of cars, along with a description of each
        //%d. creates a . next to each #, i + 1 makes the numbers get higher along with the list

    }

    public static int rangeValidator() {

        Scanner scan = new Scanner(System.in);

        int input = scan.nextInt();

        while (input < 1 || input > 6) {

            System.out.println("please enter a number between 1 and 6!");
            input = scan.nextInt();
            scan.nextLine();
        }

        return input;

        //validates that the user is inputting a valid number

    }
}
