import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Employee {
    private Integer idNum;
    private String name;
    private String surname;
    private String pesel;
    private String nationality;
    private String address;
    private String email;
    private String phone;
    private String birth_date;
    private Float salary;
    private Integer daysOff;
    //String pattern = "dd-MM-yyyy";
    //LocalDateTime localDateTime;
    //localdatetime.pa
    // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Employee(int idNum_, String name_, String pesel_, String nationality_, String address_, String email_, String phone_, String birth_date_, Float salary_, Integer daysOff_) {
        idNum = idNum_;
        name = name_;
        pesel = pesel_;
        nationality = nationality_;
        address = address_;
        email = email_;
        phone = phone_;
        birth_date = birth_date_;
        salary = salary_;
        daysOff = daysOff_;
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
    public void setIdNum(Integer idNum_) {
        idNum = idNum_;
    }
    public String getName() {
        return name;
    }
    public void setName(String name_) {
        name = name_;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname_) {
        surname = surname_;
    }
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel_) {
        pesel = pesel_;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality_) {
        nationality = nationality_;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address_) {
        address = address_;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email_) {
        email = email_;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone_) {
        phone = phone_;
    }
    public String getBirth_date() {
        return birth_date;
    }
    public void setBirth_date(String birth_date_) {
        birth_date = birth_date_;
    }
    public Float getSalary() {
        return salary;
    }
    public void setSalary(Float salary_) {
        salary = salary_;
    }
    public Integer getDaysOff() {
        return daysOff;
    }
    public void setDaysOff(Integer daysOff_) {
        daysOff = daysOff_;
    }
}
