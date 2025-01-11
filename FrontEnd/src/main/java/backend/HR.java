package backend;

import java.util.Random;
import java.util.Date;

public class HR extends Boss {
    private Random rand = new Random();
    public void employeeAdd(Employee e){
        Employees.add(e);
        System.out.println("Dodano nowego pracownika");
    }

    public void employeeRemove(Employee e){
        Employees.remove(e);
        System.out.println("Usunięto pracownika z bazy danych");
    }

    public static void employeeUpdate(Employee e, String edit_type) {
        Random rand = new Random();
        Edit ed = new Edit();
        ed.toUpperCase();
        switch (edit_type) {
            case "NAZWISKO":
                System.out.print("Zmień nazwisko na: ");
                String surname = "Gaweł";
                e.setSurname(surname);
                ed.setEdit_date(String.valueOf(new Date()));
                ed.setEdit_id(Integer.toString(rand.nextInt(100000000)));
                ed.setEdit_name("Zmieniono nazwisko na " + surname);
                //ed = new Edit(new Date(), Integer.toString(rand.nextInt(100000000)), "Zmiana nazwy pracownika");
            case "WYPLATA":
                System.out.print("Zmień wypłatę na: ");
                Float salary = Float.valueOf(5000);
                e.setSalary(salary);
                ed.setEdit_date(String.valueOf(new Date()));
                ed.setEdit_id(Integer.toString(rand.nextInt(100000000)));
                ed.setEdit_name("Zmieniono wypłatę na " + salary);

            case "DNI WOLNE":
                System.out.print("Ile dni wolnych: ");
                Integer days_off = 4;
                e.setDaysOff(days_off);
                ed.setEdit_date(String.valueOf(new Date()));
                ed.setEdit_id(Integer.toString(rand.nextInt(100000000)));
                ed.setEdit_name("Zmieniono liczbę dni wolnych na: " + days_off);
        }
    }
}
