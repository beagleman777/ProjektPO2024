package backend;

public class Filter extends Employee {
    private String search_date;
    private int search_id;
    private String search_name;
    private Filter(String search_date_, int search_id_, String search_name_) {
        this.search_date = search_date_;
        this.search_id = search_id_;
        this.search_name = search_name_;
    }
    public String getSearch_date() {
        return search_date;
    }
    public int getSearch_id() {
        return search_id;
    }
    public String getSearch_name() {
        return search_name;
    }
    public void setSearch_date(String search_date_) {
        this.search_date = search_date_;
    }
    public void setSearch_id(int search_id_) {
        this.search_id = search_id_;
    }
    public void setSearch_name(String search_name_) {
        this.search_name = search_name_;
    }
}
