package ru.aksi.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aksi.server.model.Client;
import ru.aksi.server.model.Offer;
import ru.aksi.server.model.Stuff;
import ru.aksi.server.repository.OfferRepository;
import ru.aksi.server.repository.OfficeRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class OfferService {
    private Random random = new Random();
    private OfficeRepository officeRepository;
    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfficeRepository officeRepository, OfferRepository offerRepository) {
        this.officeRepository = officeRepository;
        this.offerRepository = offerRepository;
    }

    public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
        Offer offer = new Offer();
        offer.setId(UUID.randomUUID());
        offer.setSerialNumber(generateSerialNumber());
        offer.setSignDate(LocalDate.now());
        offer.setEndingDate(endingDate);
        offer.setStartDate(startDate);
        offer.setClient(client);
        offer.setStuff(stuff);
        offer.setOffice(officeRepository.findByName("Head Leasing Office"));
        offerRepository.save(offer);
        return offer;
    }

    public String generateSerialNumber() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddkkmmss");
        return String.format("%s%s", random.nextInt(1, 15000), LocalDateTime.now().format(formatter));
    }
}
