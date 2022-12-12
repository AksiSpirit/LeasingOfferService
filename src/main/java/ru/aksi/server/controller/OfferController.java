package ru.aksi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aksi.server.dto.NewOfferParameters;
import ru.aksi.server.dto.OfferStatistics;
import ru.aksi.server.model.Client;
import ru.aksi.server.model.Offer;
import ru.aksi.server.model.Stuff;
import ru.aksi.server.repository.ClientRepository;
import ru.aksi.server.repository.OfferRepository;
import ru.aksi.server.repository.StuffRepository;
import ru.aksi.server.service.OfferService;
import ru.aksi.server.service.StatisticsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {
    private OfferRepository offerRepository;
    private OfferService offerService;
    private ClientRepository clientRepository;
    private StuffRepository stuffRepository;
    private StatisticsService statisticsService;

    @Autowired
    public OfferController(OfferRepository offerRepository, OfferService offerService, ClientRepository clientRepository, StuffRepository stuffRepository, StatisticsService statisticsService) {
        this.offerRepository = offerRepository;
        this.offerService = offerService;
        this.clientRepository = clientRepository;
        this.stuffRepository = stuffRepository;
        this.statisticsService = statisticsService;
    }

    @GetMapping("")
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
    @GetMapping("/{offerId}")
    public Offer getOfferIdById(UUID offerId) {
        return offerRepository.findById(offerId).orElse(null);
    }

    @GetMapping("/statistics")
    public OfferStatistics getOfferStatistics() {
        return statisticsService.getOfferStatistic();
    }

    @PutMapping("")
    public Offer signNewOffer(@RequestBody NewOfferParameters offerParameters) {
        Client client = clientRepository.findById(offerParameters.getClientId()).orElseThrow();
        Stuff stuff = stuffRepository.findById(offerParameters.getStuffId()).orElseThrow();
        return offerService.signNewOffer(
                offerParameters.getStartDate(),
                offerParameters.getEndingDate(),
                client,
                stuff);
    }
}
