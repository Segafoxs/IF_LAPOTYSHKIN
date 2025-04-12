package ru.iFellow;
import java.util.List;

public abstract class Car {
    String model;
    int yearManufacture;
    double engineCapacity;
    int enginePower;
    String transmission;
    String color;
    int numberDoors;

    public Car(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color, int numberOfDoors)
    {
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.transmission = transmission;
        this.color = color;
        this.numberDoors = numberOfDoors;
    }

    void setColor(String color)
    {
        this.color = color;
    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, объем двигателя: enginePower: %d, коробка передач: %s, color: %s, количество дверей: %d\n",
                model, yearManufacture, enginePower, transmission, color, numberDoors);
    }


}


class Suzuki extends Car
{
    String typeDrive;
    String manufactureCountry;

    Suzuki(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
           int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                model, yearManufacture, manufactureCountry, engineCapacity, enginePower, transmission, color, numberDoors, typeDrive);
    }
}

class Honda extends Car
{
    String typeDrive;
    String manufactureCountry;

    Honda(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
          int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                model, yearManufacture, manufactureCountry, engineCapacity, enginePower, transmission, color, numberDoors, typeDrive);
    }

}

class Vollkswagen extends Car
{
    String typeDrive;
    String manufactureCountry;

    Vollkswagen(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
                int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                model, yearManufacture, manufactureCountry, engineCapacity, enginePower, transmission, color, numberDoors, typeDrive);
    }
}

class Mazda extends Car
{
    String typeDrive;
    String manufactureCountry;

    Mazda(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
          int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                model, yearManufacture, manufactureCountry, engineCapacity, enginePower, transmission, color, numberDoors, typeDrive);
    }
}

class Subaru extends Car {

    String typeDrive;
    String manufactureCountry;

    Subaru(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
           int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                model, yearManufacture, manufactureCountry, engineCapacity, enginePower, transmission, color, numberDoors, typeDrive);
    }
}