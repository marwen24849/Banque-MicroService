package fsb.ucar.ClientService.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
