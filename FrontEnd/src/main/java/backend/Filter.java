package backend;

import java.util.Date;

public class Filter extends Employee {
    private Date search_date;
    private int search_id;
    private String search_name;
    public Filter(Date search_date_, int search_id_, String search_name_) {
        this.search_date = search_date_;
        this.search_id = search_id_;
        this.search_name = search_name_;
    }
    public Filter() {
        this.search_date = null;
        this.search_id = -1;
        this.search_name = null;
    }
    public Date getSearch_date() {
        return search_date;
    }
    public int getSearch_id() {
        return search_id;
    }
    public String getSearch_name() {
        return search_name;
    }
    public void setSearch_date(Date search_date_) {
        this.search_date = search_date_;
    }
    public void setSearch_id(int search_id_) {
        this.search_id = search_id_;
    }
    public void setSearch_name(String search_name_) {
        this.search_name = search_name_;
    }
}
