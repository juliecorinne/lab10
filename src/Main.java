import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int carPick;
        char userInput = ' ';

        System.out.println("Here's a fancy list of cars for your viewing pleasure!");
        System.out.println();
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Ford", "Explorer", 2016, 27999.99));
        carList.add(new Car("Chevrolet", "Cruze", 2017, 21999.99));
        carList.add(new Car("Buick", "Envision", 2017, 60999.99));
        carList.add(new UsedCar("Chevrolet", "Silverado", 2000, 10899.99, 70000));
        carList.add(new UsedCar("Ford", "Escape", 2007, 12890.99, 50000));
        carList.add(new UsedCar("Chevrolet", "Corvette", 2005, 30999.99, 12000));

//        for (Car c: carList) {
//            System.out.println(c);
//        }

        for (int i = 0; i <carList.size() ; i++) {
            System.out.printf("%d. %s\n", i+1, carList.get(i).toString());
        }

        System.out.println();
        System.out.println("Which care would you like?");
        carPick = scan.nextInt();
        scan.nextLine();

        System.out.println(carList.get(carPick - 1));

        System.out.println("Would you like to buy this car? y/n");
        userInput = scan.next().charAt(0);;

        if (userInput == 'y' || userInput == 'Y') {
            System.out.println("Excellent! Our finance department will be in touch shortly.");
            System.out.println();

            carList.remove(carPick-1);

            for (int i = 0; i <carList.size() ; i++) {
                System.out.printf("%d. %s\n", i+1, carList.get(i).toString());
            }
        }

    }

}
