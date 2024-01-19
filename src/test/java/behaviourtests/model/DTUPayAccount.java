package behaviourtests.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

//@Author Andreas
@Setter
@Getter
public class DTUPayAccount {

    private String id;
    private String firstName, lastName;
    private String cprNumber;
    private String accountNumber;

    public DTUPayAccount(){}

    public DTUPayAccount(String firstName, String lastName, String cprNumber, String accountNumber) {
        this.id = "";
        this.firstName = firstName;
        this.lastName = lastName;
        this.cprNumber = cprNumber;
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTUPayAccount that = (DTUPayAccount) o;
        return Objects.equals(id, that.id);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}