package Sachmatu.klubas.Sachmatu.klubas.Controllers;

import Sachmatu.klubas.Sachmatu.klubas.Converters.PlayerConverter;
import Sachmatu.klubas.Sachmatu.klubas.DTO.AddPlayerDTO;
import Sachmatu.klubas.Sachmatu.klubas.DTO.ViewPlayerDTO;
import Sachmatu.klubas.Sachmatu.klubas.Entities.Player;
import Sachmatu.klubas.Sachmatu.klubas.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public ResponseEntity<String> savePlayer(@RequestBody Player player) {
        try {
            this.playerService.savePlayer(player);
            return ResponseEntity.ok("Product saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving player: " + e.getMessage());
        }
    }

    @GetMapping
    public List<ViewPlayerDTO> getPlayers() {
        return PlayerConverter.convertViewPlayerEntityListToDto(this.playerService.getAllPlayers());
    }
    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable Long id){
        this.playerService.deletePlayerById(id);
    }

}
