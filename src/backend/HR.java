package backend;

import java.util.Random;
import java.util.Date;

public class HR extends Boss {
    public void employeeAdd(Employee e) {
        Employees.add(e);
        System.out.println("Dodano nowego pracownika");
    }

    public void employeeRemove(Employee e) {
        Employees.remove(e);
        System.out.println("Usunięto pracownika z bazy danych");
    }

    public void employeeUpdate(Employee e, String edit_type) {
        edit_type = edit_type.toUpperCase();
        Random rand = new Random();
        switch (edit_type) {
            case "NAZWISKO":
                System.out.print("Zmień nazwisko na: ");
                String surname = "Gaweł";
                Employee.setSurname(surname);
                Edit e1 = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000)), "Zmiana nazwy pracownika");
            case "WYPLATA":
                System.out.print("Zmień wypłatę na: ");
                Float salary = 5000F;
                Employee.setSalary(salary);
                Edit e2 = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000)), "Zmiana wypłaty pracownika");

            case "DNI WOLNE":
                System.out.print("Ile dni wolnych: ");
                Integer days_off = 4;
                Employee.setDaysOff(days_off);
                Edit e3 = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000)), "Zmiana liczby dni wolnych pracownika");
        }

    }

}
