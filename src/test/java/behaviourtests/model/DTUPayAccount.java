package behaviourtests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@Getter
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