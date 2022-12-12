package ru.aksi.leasingofferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aksi.leasingofferservice.dto.OfferStatistics;
import ru.aksi.leasingofferservice.model.Offer;
import ru.aksi.leasingofferservice.repository.ClientRepository;
import ru.aksi.leasingofferservice.repository.OfferRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticsService {
    private OfferRepository offerRepository;
    private ClientRepository clientRepository;

    @Autowired
    public StatisticsService(OfferRepository offerRepository, ClientRepository clientRepository) {
        this.offerRepository = offerRepository;
        this.clientRepository = clientRepository;
    }

    public OfferStatistics getOfferStatistic() {
        List<Offer> offers = offerRepository.findAll();
        Map<String, Integer> stuffStatistic = new HashMap<>();
        Map<String, Integer> clientStatistic = new HashMap<>();

        for (Offer offer: offers) {
            if (stuffStatistic.containsKey(offer.getStuff().getSurname())) {
                int cur = stuffStatistic.get(offer.getStuff().getSurname());
                stuffStatistic.remove(offer.getStuff().getSurname());
                stuffStatistic.put(offer.getStuff().getSurname(), cur + 1);
            } else stuffStatistic.put(offer.getStuff().getSurname(), 1);

            if (clientStatistic.containsKey(offer.getClient().getSurname())) {
                int cur = clientStatistic.get(offer.getClient().getSurname());
                clientStatistic.remove(offer.getClient().getSurname());
                clientStatistic.put(offer.getClient().getSurname(), cur + 1);
            } else clientStatistic.put(offer.getClient().getSurname(), 1);
        }

        Set<String> clientSurnames = clientRepository.findAll()
                .stream()
                .map(client -> {
                    return client.getSurname();
                })
                .collect(Collectors.toSet());

        return new OfferStatistics(stuffStatistic, clientStatistic, clientSurnames);
    }
}
