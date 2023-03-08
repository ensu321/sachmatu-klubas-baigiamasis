package Sachmatu.klubas.Sachmatu.klubas.Converters;

import Sachmatu.klubas.Sachmatu.klubas.DTO.AddPlayerDTO;
import Sachmatu.klubas.Sachmatu.klubas.DTO.ViewPlayerDTO;
import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class PlayerConverter {

    public static ViewPlayerDTO convertViewPlayerEntityToDTO(Player player) {
        ViewPlayerDTO viewPlayerDTO = null;
        if (player != null) {
            viewPlayerDTO = new ViewPlayerDTO();
            viewPlayerDTO.setId(player.getId());
            viewPlayerDTO.setEmail(player.getEmail());
            viewPlayerDTO.setLastName(player.getLastName());
            viewPlayerDTO.setFirstName(player.getFirstName());
            viewPlayerDTO.setGender((Long.toString(player.getPersonalCode()).charAt(0) % 2 == 0) ? "Moteris" : "Vyras");
            viewPlayerDTO.setAge(calculateAge(player.getPersonalCode()));
            viewPlayerDTO.setExperience(calculateExperience(player.getStartDate()));
        }
        return viewPlayerDTO;
    }

    public static List<ViewPlayerDTO> convertViewPlayerEntityListToDto(List<Player> playerList) {
        List<ViewPlayerDTO> viewPlayerDTOs = null;
        for (Player p : playerList) {
            if (viewPlayerDTOs == null) {
                viewPlayerDTOs = new ArrayList<>();
            }
            viewPlayerDTOs.add(PlayerConverter.convertViewPlayerEntityToDTO(p));
        }
        return viewPlayerDTOs;
    }


    public static int calculateAge(long personalCode) {
        String birthDateStr = Long.toString(personalCode).substring(1, 7);
        int year = Integer.parseInt("19" + birthDateStr.substring(0, 2));
        int month = Integer.parseInt(birthDateStr.substring(2, 4));
        int day = Integer.parseInt(birthDateStr.substring(4, 6));
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public static String calculateExperience(LocalDate startDate) {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(startDate, currentDate);

        int years = period.getYears();
        int months = period.getMonths();

        if (years > 0) {
            return years + " year" + (years > 1 ? "s" : "") + ", " + months + " month" + (months > 1 ? "s" : "");
        } else {
            return months + " month" + (months > 1 ? "s" : "");
        }
    }
}
