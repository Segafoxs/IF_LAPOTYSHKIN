package ru.iFellow;
import java.util.List;

public class CheckCar {
    public static void checkYearCar(List<Car> cars){

        for (Car item: cars)
        {
            if (item.getYearManufacture() > 2006)
            {
                item.dysplayInfo();
            }
            else
            {
                System.out.println("Устаревший авто");
            }
        }
    }

    public static void checkColorCar(List<Car> cars){
        for (Car item: cars)
        {
            if (item.getColor().equals("green"))
            {
                item.setColor("red");
                item.dysplayInfo();
            }
        }
    }

    public static void checkEnginePower(List<Car> cars){
        for (Car item: cars)
        {
            if (item.getEnginePower() >= 140)
            {
                item.dysplayInfo();
            }
            else {
                System.out.println("Медленный авто");
            }
        }
    }
}