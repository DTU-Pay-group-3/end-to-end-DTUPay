package behaviourtests.model;

import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
public class DTUPayAccount {

    private String id;
    private String firstName, lastName;
    private String cprNumber;
    private String accountNumber;

    public DTUPayAccount(String firstName, String lastName, String cprNumber, String accountNumber) {
        this.id = "";
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNumber = cprNumber;
        this.accountNumber = accountNumber;
    }

}