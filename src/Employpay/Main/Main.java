package Employpay.Main;

public class Main {
    public static void main(String[] args){

        Employee[] employees={new FulltimeEmployee("raj", 21241675,41000,25000),
                                new PartTimeEmployee("bob",21241676,2500,250)};
        for(Employee employee: employees){
            System.out.println(employee.displayinfo());
        }

    }
}
