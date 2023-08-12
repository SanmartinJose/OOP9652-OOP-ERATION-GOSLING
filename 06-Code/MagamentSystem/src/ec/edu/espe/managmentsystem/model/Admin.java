package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author Oswaldo Tipan
 */
public class Admin {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String charge;
    private String userName;
    private String password;

    public Admin(int id, String name, String phoneNumber, String email, String charge, String userName, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.charge = charge;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCharge() {
        return charge;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
