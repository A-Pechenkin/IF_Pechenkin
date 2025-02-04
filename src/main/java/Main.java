import java.util.ArrayList;
import java.util.List;

public class Main {
    //it's Main origin

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Audi(2015, "A6", "Sedan", true, "Blue", 2.0, 6.5));
        cars.add(new Audi(2019, "R8", "Coupe", true, "Red", 5.2, 3.7));

        cars.add(new Mazda(2000, "RX 7", "Coupe", false, "Black", 1.3, 7));
        cars.add(new Mazda(2012, "CX-5", "SUV", true, "Blue", 2.5, 8.7));

        cars.add(new Subaru(2005, "Impreza II", "Station wagon", false, "Grey", 2.5, 6.1));
        cars.add(new Subaru(2007, "WRX", "Sedan", false, "Green", 2.5, 6));

        cars.add(new Volvo(2021, "S60", "Sedan", true, "Black", 2.0, 4.6));
        cars.add(new Volvo(2017, "XC60", "SUV", true, "White", 2.0, 5.3));

        cars.add(new Ford(1999, "Crown Victoria", "Sedan", true, "White", 4.6, 8.9));
        cars.add(new Audi(2020, "F-450", "Pick-up", true, "Red", 6.7, 8.2));

        printCarsAfter2006(cars);
        changeColorToRed(cars);
        findFasterCar(cars);

    }

    public static void printCarsAfter2006(List<Car> cars)
    {
        int count = 0;
        for (Car car : cars)
        {
            count++;
            System.out.print("Автомобиль №" + count + ":\n");
            if (car.getYear() > 2006)
            {
                car.printInfo();
            }
            else
                System.out.println("Устаревший авто\n");
        }
    }

    public static void changeColorToRed(List<Car> cars)
    {
        for(Car car : cars)
        {
            if(car.getColor().equals("Green"))
            {
                car.setColor("Red");
                System.out.print("Авто перекрашенный из зеленого в красный: \n");
                car.printInfo();
            }
        }
    }

    public static void findFasterCar(List<Car> cars)
    {
        System.out.print("Авто с разгоном до 100 км/ч от 3 до 5 секунд:\n");
        for(Car car : cars)
        {
            if(car.getAccelerationTime() > 3.0 && car.getAccelerationTime() < 5.0)
            {
                System.out.print(car.getClass().getName() + " " + car.getModel() + "\n");
            }
        }
    }
}