package behaviourtests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.Value;

import java.math.BigDecimal;

@AllArgsConstructor
@Value
@Data
@Setter
public class Payment {

    String paymentId;
    String merchantID;
    String customerToken;
    String description;
    BigDecimal amount;

}