public abstract class Car {
    private final int year;
    private final String model;
    private final String type;
    private final boolean isAutomatic;
    private String color;
    private double engineVolume;
    private double accelerationTo100;

    public Car(int year, String model, String type, boolean isAutomatic, String color, double engineVolume, double accelerationTo100)
    {
        this.year = year;
        this.model = model;
        this.type = type;
        this.isAutomatic = isAutomatic;
        this.color = color;
        this.engineVolume = engineVolume;
        this.accelerationTo100 = accelerationTo100;
    }

    public void printInfo(){
        System.out.println("Brand: " + getClass().getName());
        System.out.println("Year of production: " + year);
        System.out.println("Model: " + model);
        System.out.println("Type: " + type);
        System.out.println("Transmission: " + (isAutomatic ? "Automatic" : "Manual"));
        System.out.println("Color: " + color);
        System.out.println("Engine Volume: " + engineVolume + " L");
        System.out.println("Acceleration 0-100 km/h: " + accelerationTo100 + " s\n");
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String newColor)
    {
        color = newColor;
    }

    public int getYear()
    {
        return this.year;
    }

    public String getModel()
    {
        return this.model;
    }

    public double getAccelerationTime()
    {
        return  this.accelerationTo100;
    }
}

