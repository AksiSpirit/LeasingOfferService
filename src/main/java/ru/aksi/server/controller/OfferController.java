package ru.aksi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.aksi.server.dto.NewOfferParameters;
import ru.aksi.server.dto.OfferStatistic;
import ru.aksi.server.model.Client;
import ru.aksi.server.model.Offer;
import ru.aksi.server.model.Stuff;
import ru.aksi.server.repository.ClientRepository;
import ru.aksi.server.repository.OfferRepository;
import ru.aksi.server.repository.StuffRepository;
import ru.aksi.server.service.OfferService;
import ru.aksi.server.service.StatisticService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {
    private OfferRepository offerRepository;
    private OfferService offerService;
    private ClientRepository clientRepository;
    private StuffRepository stuffRepository;
    private StatisticService statisticService;

    @Autowired
    public OfferController(OfferRepository offerRepository, OfferService offerService, ClientRepository clientRepository, StuffRepository stuffRepository, StatisticService statisticService) {
        this.offerRepository = offerRepository;
        this.offerService = offerService;
        this.clientRepository = clientRepository;
        this.stuffRepository = stuffRepository;
        this.statisticService = statisticService;
    }

    @GetMapping("")
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
    @GetMapping("/{offerId}")
    public Offer getOfferIdById(UUID offerId) {
        return offerRepository.findById(offerId).orElse(null);
    }

    @GetMapping("/statistic")
    public OfferStatistic getOfferStatistic() {
        return statisticService.getOfferStatistic();
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
