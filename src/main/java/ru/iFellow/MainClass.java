package ru.iFellow;
import java.util.*;


public class MainClass {
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        CarFabric.addCarList(cars);
        CheckCar.checkYearCar(cars);
        CheckCar.checkColorCar(cars);
        CheckCar.checkEnginePower(cars);
    }
}
