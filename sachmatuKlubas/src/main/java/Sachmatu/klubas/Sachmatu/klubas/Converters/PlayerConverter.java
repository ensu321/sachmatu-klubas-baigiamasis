package Sachmatu.klubas.Sachmatu.klubas.Converters;

import Sachmatu.klubas.Sachmatu.klubas.DTO.AddPlayerDTO;
import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class PlayerConverter {

    public static AddPlayerDTO convertPlayerEntityToDTO(Player player) {
        AddPlayerDTO addPlayerDTO = null;
        if (player != null) {
            addPlayerDTO = new AddPlayerDTO();
            addPlayerDTO.setEmail(player.getEmail());
            addPlayerDTO.setLastName(player.getLastName());
            addPlayerDTO.setFirstName(player.getFirstName());
            addPlayerDTO.setPersonalCode(player.getPersonalCode());
            addPlayerDTO.setStartDate(player.getStartDate());
        }
        return addPlayerDTO;
    }

    public static List<AddPlayerDTO> convertPlayerEntityListToDto(List<Player> playerList) {
        List<AddPlayerDTO> addPlayerDTO = null;
        for (Player p : playerList) {
            if (addPlayerDTO == null) {
                addPlayerDTO = new ArrayList<>();
            }
            addPlayerDTO.add(PlayerConverter.convertPlayerEntityToDTO(p));
        }
        return addPlayerDTO;
    }

}
