package Sachmatu.klubas.Sachmatu.klubas.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
public class ViewPlayerDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private int age;

    private String experience;


}
