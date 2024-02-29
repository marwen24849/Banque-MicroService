package fsb.ucar.ClientService.entites;

import fsb.ucar.ClientService.enums.AccountType;
import fsb.ucar.ClientService.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Transient
    private Customer customer;

    private long customerId;


}
