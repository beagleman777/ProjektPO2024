package backend;
import java.util.ArrayList;

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

    public void listSome() {
        for (Employee e : Employees) {
            e.printEmployeeInfo();
        }
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
