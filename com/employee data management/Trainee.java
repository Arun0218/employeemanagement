 /**
 * Trainee Details.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class Trainee {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String bloodGroup;

    public Trainee() {}

    public Trainee(String id, String name, String phoneNumber,
                   String email, String bloodGroup) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.bloodGroup = bloodGroup;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String toString() {
        StringBuilder stringBuilderDetails = new StringBuilder();
        stringBuilderDetails.append("\nTrainee ID\t\t: ").append(id)
                            .append("\nName\t\t\t: ").append(name)
                            .append("\nPhone Number\t\t: ").append(phoneNumber)
                            .append("\nEmail\t\t\t: ").append(email)
                            .append("\nBlood Group\t\t: ").append(bloodGroup)
                            .append("\n");
        return stringBuilderDetails.toString();
    }
}