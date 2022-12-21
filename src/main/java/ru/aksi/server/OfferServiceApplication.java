package ru.aksi.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.aksi.server.model.*;
import ru.aksi.server.repository.*;
import ru.aksi.server.service.OfferService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@EnableJpaRepositories
@EnableWebMvc
@SpringBootApplication
public class OfferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfferServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDb(ClientRepository clientRepository,
									OfficeRepository officeRepository,
									PositionRepository positionRepository,
									StuffRepository stuffRepository,
									OfferRepository offerRepository,
									OfferService offerService) {
		return args -> {
			clientRepository.saveAll(List.of(
					new Client(UUID.randomUUID(), "Surname1", "Name1", "Patronymic1", false, LocalDate.of(1985, 11, 24), "INN1", "PassportSerial1", "Phone1"),
					new Client(UUID.randomUUID(), "Surname2", "Name2", "Patronymic2", true, LocalDate.of(1990, 5, 14), "INN2", "PassportSerial2", "Phone2"),
					new Client(UUID.randomUUID(), "Surname3", "Name3", "Patronymic3", false, LocalDate.of(1969, 4, 20), "INN3", "PassportSerial3", "Phone3")
			));
			officeRepository.saveAll(List.of(
					new Office(UUID.randomUUID(), "Улица Ахахаха, дом 13", "г. Мухосранск, улица Ахахаха, дом 13", 112),
					new Office(UUID.randomUUID(), "Улица Страданий, дом 666", "г. Мухосранск, улица Страданий, дом 666", 7)
			));
			positionRepository.saveAll(List.of(
					new Position(UUID.randomUUID(), "Работяга 1 уровня", 15000),
					new Position(UUID.randomUUID(), "Работяга 2 уровня", 20000),
					new Position(UUID.randomUUID(), "Работяга 3 уровня", 25000),
					new Position(UUID.randomUUID(), "Начальник", 300000),
					new Position(UUID.randomUUID(), "Депутат", 5000000)
			));
			stuffRepository.saveAll(List.of(
					new Stuff(UUID.randomUUID(), "Surname1", "Name1", "Patronymic1", true, LocalDate.of(1999, 2, 4), 1.4, positionRepository.findAll().get(0)),
					new Stuff(UUID.randomUUID(), "Surname2", "Name2", "Patronymic2", false, LocalDate.of(1983, 6, 17), 1.5, positionRepository.findAll().get(1)),
					new Stuff(UUID.randomUUID(), "Surname2", "Name2", "Patronymic2", true, LocalDate.of(1972, 12, 9), 1.1, positionRepository.findAll().get(2))
			));
			offerRepository.saveAll(List.of(
					new Offer(
							UUID.randomUUID(),
							offerService.generateSerialNumber(),
							LocalDate.of(2020, 5, 17),
							LocalDate.of(2021, 5, 18),
							LocalDate.of(2020, 5, 18),
							clientRepository.findAll().get(1),
							stuffRepository.findAll().get(0),
							officeRepository.findAll().get(0))
			));
		};
	}
}
