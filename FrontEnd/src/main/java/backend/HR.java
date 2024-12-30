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

    public void employeeUpdate(Employee e, Edit ed){

    }

}
