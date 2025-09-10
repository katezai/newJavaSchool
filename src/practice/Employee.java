package practice;

import java.time.LocalDate;

public class Employee {
    // instance fields (поля)
    private String name;
    private double salary;
    private LocalDate hireDay;

    // constructor
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDay = LocalDate.of(year, month, day);
    }
    // method
    public String getName() {
        return name;
    }
}



/*Random rand = new Random();
int isAvailable = rand.nextInt(1);
int isNotAvailable = rand.nextInt(1);

System.out.println("Данная модель " + tv.isAvailable());
System.out.println("Данная модель " + tv.isNotAvailable());

if (tv.isAvailable()) {
    System.out.println(" доступна в нашем магазине");
}
else if (tv.isNotAvailable()) {
    System.out.println(" не доступна в нашем магазине, приносим свои извинения");
}
*/
