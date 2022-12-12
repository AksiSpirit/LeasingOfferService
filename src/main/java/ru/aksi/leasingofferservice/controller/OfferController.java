package ru.aksi.leasingofferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aksi.leasingofferservice.dto.NewOfferParameters;
import ru.aksi.leasingofferservice.dto.OfferStatistics;
import ru.aksi.leasingofferservice.model.Client;
import ru.aksi.leasingofferservice.model.Offer;
import ru.aksi.leasingofferservice.model.Stuff;
import ru.aksi.leasingofferservice.repository.ClientRepository;
import ru.aksi.leasingofferservice.repository.OfferRepository;
import ru.aksi.leasingofferservice.repository.StuffRepository;
import ru.aksi.leasingofferservice.service.OfferService;
import ru.aksi.leasingofferservice.service.StatisticsService;

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
