public class Boss {
    private String login;
    private String password;
    private Employee employee = new Employee();

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

    }

    public void listSome() {

    }
}
