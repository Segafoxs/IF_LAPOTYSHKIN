package ru.iFellow;
import java.util.List;

public class CarFabric {

    public static void addCarList(List<Car> carList){

        carList.add(new Suzuki("sx4", 2005, 1.6, 110,
                "automat", "green", 5, "Japan","FWD"));
        carList.add(new Mazda("cx4", 2022, 2.0,150,
                "automat", "red", 5, "Japan","AWD"));
        carList.add(new Subaru("levorg", 2018, 1.8, 190,
                "variator", "green", 5, "Japan","4WD"));
        carList.add(new Vollkswagen("golf", 2018, 2.0, 180,
                "mechanics", "white", 3, "German","FWD"));
        carList.add(new Honda("civic", 2002, 1.6, 140,
                "variator", "red", 3, "Japan","FWD"));
        carList.add(new Subaru("impreza", 2002, 1.5, 100,
                "mechanics", "blue", 5, "Japan","4WD"));
        carList.add(new Vollkswagen("polo", 2011, 1.6, 110,
                "mechanics", "blue", 5, "German","FWD"));
        carList.add(new Mazda("mazda3", 2005, 1.6, 110,
                "mechanics", "green", 5, "Japan","FWD"));
        carList.add(new Honda("accord", 2007, 2.0, 150,
                "automat", "black", 5, "Japan","FWD"));
        carList.add(new Vollkswagen("amarok", 2018, 2.0, 180,
                "automat", "grey", 5, "German","4WD"));
    }
}