package Employpay.Main;

public class FulltimeEmployee extends Employee {
    private double bonus;

    public FulltimeEmployee(String name, int id, double basesalary, double bonus) {
        super(name, id, basesalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public double calculatedpay(){
        return getBasesalary() + bonus;
    }
    //Updates info by calling parents and updating it with bonus
    public String displayinfo(){
       // return getName()+","+getId()+","+calculatedpay();
        return super.displayinfo()+bonus;
    }
    // it is not required but still if case to find bonus
    public String displayinfo(boolean showbonus){
        if(showbonus){
            return displayinfo();
        }
        return super.displayinfo();
    }
}
