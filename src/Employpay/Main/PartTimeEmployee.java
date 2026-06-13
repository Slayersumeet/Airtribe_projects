package Employpay.Main;

public class PartTimeEmployee extends Employee {
    private int hoursworked;
    private double hourlyrate;

    public PartTimeEmployee(String name, int id, double hourlyrate, int hoursworked) {
        super(name, id, 0);
        this.hourlyrate = hourlyrate;
        this.hoursworked = hoursworked;
    }

    public double getHourlyrate() {
        return hourlyrate;
    }

    public int getHoursworked() {
        return hoursworked;
    }

    public double calculatedpay(){
        return hoursworked * hourlyrate;
    }
}
