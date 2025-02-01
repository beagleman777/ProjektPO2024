package backend;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Boss {
    private String login;
    private String password;
    protected ArrayList<Employee> Employees = new ArrayList<Employee>();
    public Boss(String login_, String password_) {
        login = login_;
        password = password_;
    }

    public Boss() {
        login = "";
        password = "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login_) {
        login = login_;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password_) {
        password = password_;
    }

    public void listAll() {
        for (Employee e : Employees) {
            e.printEmployeeInfo();
        }
    }

    public ArrayList<Employee> listSome(String search_name, String search) {
        search_name = search_name.toUpperCase();
        Random rand = new Random();
        ArrayList<Employee> Employees_Filtered = new ArrayList<>();
        switch (search_name) {
            case "IMIE":
                String name = search;
                for (Employee e : Employees) {
                    if (e.getName().equals(name))
                        Employees_Filtered.add(e);
                }
                Filter f1 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po imieniu");
                break;
            case "NAZWISKO":
                String surname = search;
                for (Employee e : Employees) {
                    if (e.getSurname().equals(surname))
                        Employees_Filtered.add(e);
                }
                Filter f2 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po nazwisku");
                break;
            case "PESEL":
                String pesel = search;
                for (Employee e : Employees) {
                    if (e.getPesel().equals(pesel))
                        Employees_Filtered.add(e);
                }
                Filter f3 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po PESEL'u");
                break;
            case "NARODOWOŚĆ":
                String nationality = search;
                for (Employee e : Employees) {
                    if (e.getNationality().equals(nationality))
                        Employees_Filtered.add(e);
                }
                Filter f4 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po narodowości");
                break;
            case "ADRES ZAMIESZKANIA":
                String address = search;
                for (Employee e : Employees) {
                    if (e.getAddress().equals(address))
                        Employees_Filtered.add(e);
                }
                Filter f5 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po adresie zamieszkania");
                break;
            case "EMAIL":
                String email = search;
                for (Employee e : Employees) {
                    if (e.getEmail().equals(email))
                        Employees_Filtered.add(e);
                }
                Filter f6 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po emailu");
                break;
            case "TELEFON":
                String phone_number = search;
                for (Employee e : Employees) {
                    if (e.getPhone().equals(phone_number))
                        Employees_Filtered.add(e);
                }
                Filter f7 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po numerze telefonu");
                break;
            case "DATA URODZENIA":
                String birth_date = search;
                for (Employee e : Employees) {
                    if (e.getBirth_date().equals(birth_date))
                        Employees_Filtered.add(e);
                }
                Filter f8 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po dacie urodzenia");
                break;
            case "WYPŁATA":
                String salary = search;
                for (Employee e : Employees) {
                    if (e.getEmail().equals(salary))
                        Employees_Filtered.add(e);
                }
                Filter f9 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po wynagrodzeniu");
                break;
            case "DNI WOLNE":
                String daysOff = search;
                for (Employee e : Employees) {
                    if (e.getEmail().equals(daysOff))
                        Employees_Filtered.add(e);
                }
                Filter f10 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po emailu");
                break;
            case "STANOWISKO":
                String position = search;
                for (Employee e : Employees) {
                    if (e.getEmail().equals(position))
                        Employees_Filtered.add(e);
                }
                Filter f11 = new Filter(new Date(), rand.nextInt(1000000000), "Filtrowanie rekordów po stanowisku");
                break;
        }
        for (Employee e : Employees_Filtered) {
            e.printEmployeeInfo();
        }
        return Employees_Filtered;
    }

    public void printInfo() {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }
    public ArrayList<Employee> getEmployees(){
        return Employees;
    }
    public void setEmployees(ArrayList<Employee> employees){
        Employees = employees;
    }
}
