package Employpay.Main;

public class Employee {
    private String name;
    private int id;
    private double basesalary;

    public Employee(String name, int id, double basesalary) {
        this.name = name;
        this.id = id;
        this.basesalary = basesalary;
    }

    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }

    public double getBasesalary() {
        return basesalary;
    }

    public double calculatedpay(){
        return basesalary;
    }
    public String displayinfo(){
        return name+","+id+","+calculatedpay();
    }
}
