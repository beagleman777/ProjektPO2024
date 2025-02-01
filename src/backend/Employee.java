package backend;

import javax.swing.*;

public class Employee {
    private static Integer idNum;
    private static String name;
    private static String surname;
    private static String pesel;
    private static String nationality;
    private static String address;
    private static String email;
    private static String phone;
    private static String birth_date;
    private static Float salary;
    private static Integer daysOff;

    //String pattern = "dd-MM-yyyy";
    //LocalDateTime localDateTime;
    //localdatetime.pa
    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Employee(int idNum_, String name_, String surname_, String pesel_, String nationality_, String address_, String email_, String phone_, String birth_date_, Float salary_, Integer daysOff_, String gender) {
        idNum = idNum_;
        name = name_;
        surname = surname_;
        pesel = pesel_;
        nationality = nationality_;
        address = address_;
        email = email_;
        phone = phone_;
        birth_date = birth_date_;
        salary = salary_;
        daysOff = daysOff_;
        if (Integer.parseInt(String.valueOf(pesel_.charAt(pesel_.length() - 1))) % 2 == 0) {
            gender = "Kobieta";
        }
        else {
            gender = "Mężczyzna";
        }

    }

    public Employee() {
        idNum = null;
        name = null;
        surname = null;
        pesel = null;
        nationality = null;
        address = null;
        email = null;
        phone = null;
        birth_date = null;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public static void setIdNum(Integer idNum_) {
        idNum = idNum_;
    }

    public String getName() {
        return name;
    }

    public static void setName(String name_) {
        name = name_;
    }

    public String getSurname() {
        return surname;
    }

    public static void setSurname(String surname_) {
        surname = surname_;
    }

    public String getPesel() {
        return pesel;
    }

    public static void setPesel(String pesel_) {
        pesel = pesel_;
    }

    public String getNationality() {
        return nationality;
    }

    public static void setNationality(String nationality_) {
        nationality = nationality_;
    }

    public String getAddress() {
        return address;
    }

    public static void setAddress(String address_) {
        address = address_;
    }

    public String getEmail() {
        return email;
    }

    public static void setEmail(String email_) {
        email = email_;
    }

    public String getPhone() {
        return phone;
    }

    public static void setPhone(String phone_) {
        phone = phone_;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public static void setBirth_date(String birth_date_) {
        birth_date = birth_date_;
    }

    public Float getSalary() {
        return salary;
    }

    public static void setSalary(Float salary_) {
        salary = salary_;
    }

    public Integer getDaysOff() {
        return daysOff;
    }

    public static void setDaysOff(Integer daysOff_) {
        daysOff = daysOff_;
    }

    public void printEmployeeInfo() {
        System.out.print("ID: " + getIdNum() + "   ");
        System.out.print("Name: " + getName() + "   ");
        System.out.print("Surname: " + getSurname() + "   ");
        System.out.print("Pesel: " + getPesel() + "   ");
        System.out.print("Nationality: " + getNationality() + "   ");
        System.out.print("Address: " + getAddress() + "   ");
        System.out.print("Email: " + getEmail() + "   ");
        System.out.print("Phone: " + getPhone() + "   ");
        System.out.print("Birth Date: " + getBirth_date() + "   ");
        System.out.print("Salary: " + getSalary() + "   ");
        System.out.print("Days Off: " + getDaysOff() + "\n");
    }
}
