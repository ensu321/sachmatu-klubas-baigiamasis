package Sachmatu.klubas.Sachmatu.klubas.Services;

import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;
import Sachmatu.klubas.Sachmatu.klubas.Repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public void savePlayer(Player player) {
        this.playerRepository.saveAndFlush(player);
    }

    public List<Player> getAllPlayers() {
        return this.playerRepository.findAll();
    }

    public void deletePlayerById(Long id) {
        this.playerRepository.deleteById(id);
    }

    public Player getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (!player.isPresent()) {
            return null;
        }

        return player.get();
    }

    public void editPlayerById(Long id, Player player) {
        Optional<Player> oldPlayerOptional = playerRepository.findById(id);

        if (!oldPlayerOptional.isPresent()) {
            return;
        }

        Player oldPlayer = oldPlayerOptional.get();

        if (player.getFirstName() != null && !oldPlayer.getFirstName().equals(player.getFirstName())){
            oldPlayer.setFirstName(player.getFirstName());
        }

        if (player.getLastName() != null && !oldPlayer.getLastName().equals(player.getLastName())){
            oldPlayer.setLastName(player.getLastName());
        }

        if (player.getEmail() != null && !oldPlayer.getEmail().equals(player.getEmail())){
            oldPlayer.setEmail(player.getEmail());
        }

        if (player.getStartDate() != null && !oldPlayer.getStartDate().equals(player.getStartDate())){
            oldPlayer.setStartDate(player.getStartDate());
        }

        if (player.getPersonalCode() != null && !oldPlayer.getPersonalCode().equals(player.getPersonalCode())){
            oldPlayer.setPersonalCode(player.getPersonalCode());
        }

        playerRepository.saveAndFlush(oldPlayer);
    }

}
