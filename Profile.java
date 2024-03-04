package libreria;
import java.util.Date;

public class Profile {
    private String name;
    private String lastName;
    private Date birthdate;

    public Profile(String name, String lastName, Date birthdate) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }
}



