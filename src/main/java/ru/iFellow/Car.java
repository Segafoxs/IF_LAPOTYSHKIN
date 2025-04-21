package ru.iFellow;


public abstract class Car {
    private final String model;
    private final int yearManufacture;
    private final double engineCapacity;
    private final int enginePower;
    private final String transmission;
    private String color;
    private final int numberDoors;

    public Car(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color, int numberOfDoors)
    {
        this.model = model;
        this.yearManufacture = yearManufacture;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.transmission = transmission;
        setColor(color);
        this.numberDoors = numberOfDoors;
    }

    public String getModel() {
        return model;
    }

    public int getYearManufacture(){
        return yearManufacture;
    }

    public double getEngineCapacity(){
        return engineCapacity;
    }

    public int getEnginePower(){
        return enginePower;
    }

    public String getTransmission(){
        return transmission;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String newColor)
    {
        color = newColor;
    }

    public int getNumberDoors(){
        return numberDoors;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, объем двигателя: enginePower: %d, коробка передач: %s, color: %s, количество дверей: %d\n",
                model, yearManufacture, enginePower, transmission, color, numberDoors);
    }
}


class Suzuki extends Car {
    private final String typeDrive;
    private final String manufactureCountry;

    Suzuki(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
           int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    public String getTypeDrive(){
        return typeDrive;
    }

    public String getManufactureCountry(){
        return manufactureCountry;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                getModel(), getYearManufacture(), getManufactureCountry(), getEngineCapacity(), getEnginePower(), getTransmission(), getColor(), getNumberDoors(), getTypeDrive());
    }
}

class Honda extends Car {
    private final String typeDrive;
    private final String manufactureCountry;

    Honda(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
          int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    public String getTypeDrive(){
        return typeDrive;
    }

    public String getManufactureCountry(){
        return manufactureCountry;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                getModel(), getYearManufacture(), getManufactureCountry(), getEngineCapacity(), getEnginePower(), getTransmission(), getColor(), getNumberDoors(), getTypeDrive());
    }

}

class Vollkswagen extends Car
{
    private final String typeDrive;
    private final String manufactureCountry;

    Vollkswagen(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
                int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    public String getTypeDrive(){
        return typeDrive;
    }

    public String getManufactureCountry(){
        return manufactureCountry;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                getModel(), getYearManufacture(), getManufactureCountry(), getEngineCapacity(), getEnginePower(), getTransmission(), getColor(), getNumberDoors(), getTypeDrive());
    }
}

class Mazda extends Car
{
    private final String typeDrive;
    private final String manufactureCountry;

    Mazda(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
          int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    public String getTypeDrive(){
        return typeDrive;
    }

    public String getManufactureCountry(){
        return manufactureCountry;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                getModel(), getYearManufacture(), getManufactureCountry(), getEngineCapacity(), getEnginePower(), getTransmission(), getColor(), getNumberDoors(), getTypeDrive());
    }
}

class Subaru extends Car {

    private final String typeDrive;
    private final String manufactureCountry;

    Subaru(String model, int yearManufacture, double engineCapacity, int enginePower, String transmission, String color,
           int numberOfDoors, String manufactureCountry, String typeDrive)
    {
        super(model, yearManufacture, engineCapacity, enginePower, transmission, color, numberOfDoors);
        this.manufactureCountry = manufactureCountry;
        this.typeDrive = typeDrive;

    }

    public String getTypeDrive(){
        return typeDrive;
    }

    public String getManufactureCountry(){
        return manufactureCountry;
    }

    public void dysplayInfo()
    {
        System.out.printf("Модель: %s, год выпуска: %d, страна производства: %s, объем двигателя: %f, мощность двигателя: %d, коробка передач: %s, color: %s, количество дверей: %d, тип привода: %s\n",
                getModel(), getYearManufacture(), getManufactureCountry(), getEngineCapacity(), getEnginePower(), getTransmission(), getColor(), getNumberDoors(), getTypeDrive());
    }
}