package Sachmatu.klubas.Sachmatu.klubas.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class AddPlayerDTO {


    private Long personalCode;


    private String firstName;


    private String lastName;


    private String email;


    private LocalDate startDate;

}
