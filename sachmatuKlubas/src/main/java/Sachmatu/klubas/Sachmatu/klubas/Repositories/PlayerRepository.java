package Sachmatu.klubas.Sachmatu.klubas.Repositories;

import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long> {
}
