package backend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
@JsonIgnoreProperties({"idNum", "name", "surname", "pesel", "nationality", "address", "email", "phone", "birth_date", "salary", "daysOff", "position"})
public class Filter extends Employee {
    private String dateString;
    @JsonIgnore
    private Date search_date;
    private int search_id;
    private String search_name;
    private ArrayList<Integer> ids = new ArrayList<>();
    public Filter(String search_dateString, int search_id_, String search_name_) {
        this.dateString = search_dateString;
        this.search_id = search_id_;
        this.search_name = search_name_;
    }
    public Filter() {
        this.search_date = null;
        this.search_id = -1;
        this.search_name = null;
    }
    public String printFilter(){
        String result="Search ID: ";
        result=result + String.valueOf(this.search_id);
        result=result + ", Search name: " + this.search_name + ", Search date: " + this.dateString + ", IDs: ";
        for(int i=0; i<ids.size()-1; i++){
            result+=ids.get(i)+", ";
        }
        result=result+ids.get(ids.size()-1);
        return result;
    }
    public Date getSearch_date() {
        return search_date;
    }
    public int getSearch_id() {
        return search_id;
    }
    public String getSearch_dateString() {
        return dateString;
    }
    public String getSearch_name() {
        return search_name;
    }
    public void setSearch_date(Date search_date_) {
        this.search_date = search_date_;
    }
    public void setSearch_dateString(String search_dateString) {
        this.dateString = search_dateString;
    }
    public void setSearch_id(int search_id_) {
        this.search_id = search_id_;
    }
    public void setSearch_name(String search_name_) {
        this.search_name = search_name_;
    }
    public ArrayList<Integer> getIds() {
        return ids;
    }
    public void setIds(ArrayList<Integer> ids) {
        this.ids = ids;
    }
}
