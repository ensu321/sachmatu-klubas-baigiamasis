package Sachmatu.klubas.Sachmatu.klubas;

import Sachmatu.klubas.Sachmatu.klubas.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SachmatuKlubasApplication {


	@Autowired
	private PlayerService playerService;
	public static void main(String[] args) {
		SpringApplication.run(SachmatuKlubasApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {

	}

}
