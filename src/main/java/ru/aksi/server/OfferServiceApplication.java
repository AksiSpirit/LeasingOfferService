package ru.aksi.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.aksi.server.model.Client;
import ru.aksi.server.model.Office;
import ru.aksi.server.model.Position;
import ru.aksi.server.model.Stuff;
import ru.aksi.server.repository.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AutoConfiguration
@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class OfferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDb(ClientRepository clientRepository,
									OfferRepository offerRepository,
									OfficeRepository officeRepository,
									PositionRepository positionRepository,
									StuffRepository stuffRepository) {
		return args -> {
			clientRepository.saveAll(List.of(
					new Client(UUID.randomUUID(), "Surname1", "Name1", "Patronymic1", false, LocalDate.now().minusYears(2), "228777", "6969696969", "88005553535"),
					new Client(UUID.randomUUID(), "Surname2", "Name2", "Patronymic2", true, LocalDate.now().minusYears(7), "46757547", "3===D", "245234567"),
					new Client(UUID.randomUUID(), "Surname3", "Name3", "Patronymic3", false, LocalDate.now().minusYears(22), "7865434", "000000", "0000000000005")
			));
			officeRepository.saveAll(List.of(
					new Office(UUID.fromString("22b30e4e-3406-4881-88e2-3913f51e2782"), "Улица Ахахаха, дом 34", "г. Мухосранск, улица Ахахаха, дом 13", 112),
					new Office(UUID.randomUUID(), "Улица Страданий, дом 13", "г. Мухосранск, улица Страданий, дом 666", 7)
			));
			positionRepository.saveAll(List.of(
					new Position(UUID.fromString("538b8667-676d-4fe9-b79f-8eceebdbcb45"), "Работяга 1 уровня", 15000),
					new Position(UUID.fromString("3ac4ce02-21cc-456f-b189-4503ea711fe8"), "Работяга 2 уровня", 20000),
					new Position(UUID.randomUUID(), "Работяга 3 уровня", 25000),
					new Position(UUID.randomUUID(), "Начальник", 300000),
					new Position(UUID.randomUUID(), "Депутат", 5000000)
			));
			stuffRepository.saveAll(List.of(
					new Stuff(UUID.randomUUID(), "Surname1", "Name1", "Patronymic1", true, LocalDate.now().minusYears(3), 1.0, new Position(UUID.fromString("538b8667-676d-4fe9-b79f-8eceebdbcb45"), "Работяга 1 уровня", 15000)),
					new Stuff(UUID.randomUUID(), "Surname2", "Name2", "Patronymic2", false, LocalDate.now().minusYears(5), 1.5, new Position(UUID.fromString("3ac4ce02-21cc-456f-b189-4503ea711fe8"), "Работяга 2 уровня", 20000))
			));
		};
	}
}
