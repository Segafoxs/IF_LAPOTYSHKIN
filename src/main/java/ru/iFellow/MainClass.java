package ru.iFellow;
import ru.iFellow.Car;
import ru.iFellow.CheckCar;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Suzuki("sx4", 2005, 1.6, 110,
                "automat", "green", 5, "Japan","FWD"));
        cars.add(new Mazda("cx4", 2022, 2.0,150,
                "automat", "red", 5, "Japan","AWD"));
        cars.add(new Subaru("levorg", 2018, 1.8, 190,
                "variator", "green", 5, "Japan","4WD"));
        cars.add(new Vollkswagen("golf", 2018, 2.0, 180,
                "mechanics", "white", 3, "German","FWD"));
        cars.add(new Honda("civic", 2002, 1.6, 140,
                "variator", "red", 3, "Japan","FWD"));
        cars.add(new Subaru("impreza", 2002, 1.5, 100,
                "mechanics", "blue", 5, "Japan","4WD"));
        cars.add(new Vollkswagen("polo", 2011, 1.6, 110,
                "mechanics", "blue", 5, "German","FWD"));
        cars.add(new Mazda("mazda3", 2005, 1.6, 110,
                "mechanics", "green", 5, "Japan","FWD"));
        cars.add(new Honda("accord", 2007, 2.0, 150,
                "automat", "black", 5, "Japan","FWD"));
        cars.add(new Vollkswagen("amarok", 2018, 2.0, 180,
                "automat", "grey", 5, "German","4WD"));


        //Вывод информации об автомобилях выпущенных после 2006г
        CheckCar.checkYearCar(cars);

        //Изменение зеленого цвета авто на красный
        CheckCar.checkColorCar(cars);

        //Вывод информации об автомобиле с двигателем мощностью 140 л.с. и выше
        CheckCar.checkEnginePower(cars);


    }
}