package backend;

public class Edit extends Employee {
    private String edit_date;
    private String edit_id;
    private String edit_name;

    public Edit(String edit_date_, String edit_id_, String edit_name_) {
        edit_date = edit_date_;
        edit_id = edit_id_;
        edit_name = edit_name_;
    }

    public Edit(){
        edit_date = "";
        edit_id = "";
        edit_name = "";
    }
    public String printEdit(){
        return "Edit ID: " + getEdit_id() + ", Edit name: " + getEdit_name() + ", Edit date: " +  getEdit_date() + ", ID: " + getIdNum() + ", Name: " + getName() + ", Surname: " + getSurname() + ", Pesel: " + getPesel() + ", Nationality: " + getNationality() + ", Address: " + getAddress() + ", Email: " + getEmail() + ", Phone: " + getPhone() + ", Birth Date: " + getBirth_date() + ", Salary: " + getSalary() + ", Days Off: " + getDaysOff() + ", Position: " + getPosition();
    }

    public String getEdit_date() {
        return edit_date;
    }

    public String getEdit_id() {
        return edit_id;
    }

    public String getEdit_name() {
        return edit_name;
    }

    public void setEdit_date(String edit_date_) {
        edit_date = edit_date_;
    }

    public void setEdit_id(String edit_id_) {
        edit_id = edit_id_;
    }

    public void setEdit_name(String edit_name_) {
        edit_name = edit_name_;
    }
    //@Override
    public void toUpperCase(){
        edit_date = edit_date.toUpperCase();
        edit_id = edit_id.toUpperCase();
        edit_name = edit_name.toUpperCase();
    }
}
