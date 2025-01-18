package backend;

import java.util.Date;

public class Edit extends Employee {
    private Date edit_date;
    private String edit_id;
    private String edit_name;

    public Edit(Date edit_date_, String edit_id_, String edit_name_) {
        edit_date = edit_date_;
        edit_id = edit_id_;
        edit_name = edit_name_;
    }

    public Date getEdit_date() {
        return edit_date;
    }

    public String getEdit_id() {
        return edit_id;
    }

    public String getEdit_name() {
        return edit_name;
    }

    public void setEdit_date(Date edit_date_) {
        edit_date = edit_date_;
    }

    public void setEdit_id(String edit_id_) {
        edit_id = edit_id_;
    }

    public void setEdit_name(String edit_name_) {
        edit_name = edit_name_;
    }
}
