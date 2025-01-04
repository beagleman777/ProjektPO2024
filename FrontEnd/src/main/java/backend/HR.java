import java.util.Random;
import java.util.Date;
package backend;

public class HR extends Boss{
    public void employeeAdd(Employee e){
        Employees.add(e);
        System.out.println("Dodano nowego pracownika");
    }

    public void employeeRemove(Employee e){
        Employees.remove(e);
        System.out.println("Usunięto pracownika z bazy danych");
    }

    public void employeeUpdate(Employee e, String edit_type){
        ed = ed.toUpperCase()
        switch(ed)
        case "NAZWISKO":
            System.out.print("Zmień nazwisko na: ");
            String surname = "Gaweł";
            Employee.setSurname(surname);
            Edit ed = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000000)), "Zmiana nazwy pracownika");
        case "WYPLATA":
            System.Out.print("Zmień wypłatę na: ");
            Float salary = 5000;
            Employee.setSalary(salary);
            Edit ed = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000000)), "Zmiana wypłaty pracownika");

        case "DNI WOLNE":
            System.Out.print("Ile dni wolnych: ");
            Integer days_off = 4;
            Employee.setDaysOff(days_off);
            Edit ed = new Edit(new Date(), Integer.toString(rand.nextInt(1000000000000)), "Zmiana liczby dni wolnych pracownika");
    }

}
