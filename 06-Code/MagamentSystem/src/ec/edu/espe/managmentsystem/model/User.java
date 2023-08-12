package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class User {

    private int id;
    private String fullName;
    private String cellphone;
    private String email;
    private String typeOfUser;
    private String username;
    private String password;

    public User(int id, String fullName, String cellphone, String email, String typeOfUser, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.cellphone = cellphone;
        this.email = email;
        this.typeOfUser = typeOfUser;
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * @param cellphone the cellphone to set
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the typeOfUser
     */
    public String getTypeOfUser() {
        return typeOfUser;
    }

    /**
     * @param typeOfUser the typeOfUser to set
     */
    public void setTypeOfUser(String typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
