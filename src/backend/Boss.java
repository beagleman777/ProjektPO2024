package backend;

import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

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

    public void listSome(String search_name) {
        search_name = search_name.toUpperCase();
        Random rand = new Random();
        ArrayList<Employee> Employees_Filtered = new ArrayList<>();
        switch (search_name) {
            case "IMIE":
                String name = "Dwayne";
                for (Employee e : Employees) {
                    if (e.getName().equals(name))
                        Employees_Filtered.add(e);
                }
                Filter f1 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po imieniu");
            case "NAZWISKO":
                String surname = "Johnson";
                for (Employee e : Employees) {
                    if (e.getSurname().equals(surname))
                        Employees_Filtered.add(e);
                }
                Filter f2 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po nazwisku");
            case "PESEL":
                String pesel = "20390242023";
                for (Employee e : Employees) {
                    if (e.getPesel().equals(pesel))
                        Employees_Filtered.add(e);
                }
                Filter f3 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po PESEL'u");
            case "NARODOWOŚĆ":
                String nationality = "American";
                for (Employee e : Employees) {
                    if (e.getNationality().equals(nationality))
                        Employees_Filtered.add(e);
                }
                Filter f4 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po narodowości");
            case "ADRES ZAMIESZKANIA":
                String address = "WWE Performance Center 5055 Forsyth Commerce Road Suite 100 Orlando, FL 32807 USA";
                for (Employee e : Employees) {
                    if (e.getAddress().equals(address))
                        Employees_Filtered.add(e);
                }
                Filter f5 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po adresie zamieszkania");
            case "EMAIL":
                String email = "therock@studiofanmail.com";
                for (Employee e : Employees) {
                    if (e.getEmail().equals(email))
                        Employees_Filtered.add(e);
                }
                Filter f6 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po emailu");
            case "TELEFON":
                String phone_number = "5733089076";
                for (Employee e : Employees) {
                    if (e.getPhone().equals(phone_number))
                        Employees_Filtered.add(e);
                }
                Filter f7 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po numerze telefonu");
            case "DATA URODZENIA":
                String birth_date = "May 2 1972";
                for (Employee e : Employees) {
                    if (e.getBirth_date().equals(birth_date))
                        Employees_Filtered.add(e);
                }
                Filter f8 = new Filter(new Date(), Integer.toString(rand.nextInt(1000000000)), "Filtrowanie rekordów po dacie urodzenia");
        }
        for (Employee e : Employees_Filtered) {
            e.printEmployeeInfo();
        }
    }

    public void printInfo() {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }
}
