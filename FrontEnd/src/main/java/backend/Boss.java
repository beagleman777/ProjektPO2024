package backend;
import javafx.util.Pair;

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

    public ArrayList<Employee> listAll() {
        for (Employee e : Employees) {
            e.printEmployeeInfo();
        }
        return Employees;
    }

    public Pair<ArrayList<Employee>, Filter> listSome(String search_name, String search) {
        search_name = search_name.toUpperCase();
        Random rand = new Random();
        ArrayList<Employee> Employees_Filtered = new ArrayList<>();
        Filter f = new Filter();
        Date date=new Date();
        switch (search_name) {
            case "IMIE":
                String name = search;
                Filter f1 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po imieniu");
                for (Employee e : Employees) {
                    if (e.getName().equals(name)){
                        Employees_Filtered.add(e);
                        f1.getIds().add(e.getIdNum());
                    }
                }
                f=f1;
                break;
            case "NAZWISKO":
                String surname = search;
                Filter f2 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po nazwisku");
                for (Employee e : Employees) {
                    if (e.getSurname().equals(surname)){
                        Employees_Filtered.add(e);
                        f2.getIds().add(e.getIdNum());
                    }
                }
                f=f2;
                break;
            case "PESEL":
                String pesel = search;
                Filter f3 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po PESEL'u");
                for (Employee e : Employees) {
                    if (e.getPesel().equals(pesel)){
                        Employees_Filtered.add(e);
                        f3.getIds().add(e.getIdNum());
                    }
                }
                f=f3;
                break;
            case "NARODOWOŚĆ":
                String nationality = search;
                Filter f4 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po narodowości");
                for (Employee e : Employees) {
                    if (e.getNationality().equals(nationality)){
                        Employees_Filtered.add(e);
                        f4.getIds().add(e.getIdNum());
                    }
                }
                f=f4;
                break;
            case "ADRES ZAMIESZKANIA":
                String address = search;
                Filter f5 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po adresie zamieszkania");
                for (Employee e : Employees) {
                    if (e.getAddress().equals(address)) {
                        Employees_Filtered.add(e);
                        f5.getIds().add(e.getIdNum());
                    }
                }
                f=f5;
                break;
            case "EMAIL":
                String email = search;
                Filter f6 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po emailu");
                for (Employee e : Employees) {
                    if (e.getEmail().equals(email)){
                        Employees_Filtered.add(e);
                        f6.getIds().add(e.getIdNum());
                    }
                }
                f=f6;
                break;
            case "TELEFON":
                String phone_number = search;
                Filter f7 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po numerze telefonu");
                for (Employee e : Employees) {
                    if (e.getPhone().equals(phone_number)) {
                        Employees_Filtered.add(e);
                        f7.getIds().add(e.getIdNum());
                    }
                }
                f=f7;
                break;
            case "DATA URODZENIA":
                String birth_date = search;
                Filter f8 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po dacie urodzenia");
                for (Employee e : Employees) {
                    if (e.getBirth_date().equals(birth_date)){
                        Employees_Filtered.add(e);
                        f8.getIds().add(e.getIdNum());
                    }

                }
                f=f8;
                break;
            case "WYPLATA":
                String salary = search;
                float floatSalary = Float.parseFloat(salary);
                Filter f9 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po wynagrodzeniu");
                for (Employee e : Employees) {
                    if (e.getSalary()==floatSalary){
                        Employees_Filtered.add(e);
                        f9.getIds().add(e.getIdNum());
                    }
                }
                f=f9;
                break;
            case "DNI WOLNE":
                String daysOff = search;
                int intDaysOff = Integer.parseInt(daysOff);
                Filter f10 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po dniach wolnych");
                for (Employee e : Employees) {
                    if (e.getDaysOff()==intDaysOff){
                        Employees_Filtered.add(e);
                        f10.getIds().add(e.getIdNum());
                    }
                }
                f=f10;
                break;
            case "STANOWISKO":
                String position = search;
                Filter f11 = new Filter(new Date().toString(), rand.nextInt(1000000000), "Filtrowanie rekordów po stanowisku");
                for (Employee e : Employees) {
                    if (e.getPosition().equals(position)){
                        Employees_Filtered.add(e);
                        f11.getIds().add(e.getIdNum());
                    }
                }
                f=f11;
                break;
        }
        for (Employee e : Employees_Filtered) {
            e.printEmployeeInfo();
        }
        return new Pair<>(Employees_Filtered, f);
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
