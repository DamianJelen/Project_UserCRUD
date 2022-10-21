package pl.damjel.usercrud.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String city;
    private String zipCode;
    private String street;
    private String streetNumber;
    private String pass;
}
