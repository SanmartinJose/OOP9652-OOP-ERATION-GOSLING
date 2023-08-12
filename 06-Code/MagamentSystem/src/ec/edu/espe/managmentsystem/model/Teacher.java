package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author Sanmertin Jose, OOP-ERATION-GOSLING,DCC-ESPE
 */
public class Teacher {

    private int id;
    private int courseId;
    private String name;
    private int age;
    private String address;
    private String email;
    private String phoneNumber;

    public Teacher(int id, int courseId, String name, int age, String address, String email, String phoneNumber) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
