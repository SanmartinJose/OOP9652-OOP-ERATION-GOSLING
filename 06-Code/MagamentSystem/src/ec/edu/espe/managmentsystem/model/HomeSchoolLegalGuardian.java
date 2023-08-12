package ec.edu.espe.managmentsystem.model;

/**
 *
 * @author PabloEZurita
 */
public class HomeSchoolLegalGuardian {

    int age;
    int id;
    int studentId;
    String phoneNumber;
    String name;
    String email;

    public HomeSchoolLegalGuardian(int age, int id, int studentId, String phoneNumber, String name, String email) {
        this.age = age;
        this.id = id;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
