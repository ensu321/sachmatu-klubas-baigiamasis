package Sachmatu.klubas.Sachmatu.klubas.Services;

import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;
import Sachmatu.klubas.Sachmatu.klubas.Repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
