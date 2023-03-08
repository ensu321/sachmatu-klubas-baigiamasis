package Sachmatu.klubas.Sachmatu.klubas.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {

    private Long id;

    private Long personalCode;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDate startDate;

}
