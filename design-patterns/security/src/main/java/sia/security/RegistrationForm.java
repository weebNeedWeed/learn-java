package sia.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;

    public User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setCity(city);
        user.setFullname(fullname);
        user.setStreet(street);
        user.setState(state);
        user.setUsername(username);
        user.setPhoneNumber(phoneNumber);
        user.setZip(zip);
        user.setPassword(encoder.encode(password));
        return user;
    }
}
