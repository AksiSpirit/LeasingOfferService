package ru.aksi.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aksi.server.dto.OfferStatistic;
import ru.aksi.server.model.Offer;
import ru.aksi.server.repository.ClientRepository;
import ru.aksi.server.repository.OfferRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    private OfferRepository offerRepository;
    private ClientRepository clientRepository;

    @Autowired
    public StatisticService(OfferRepository offerRepository, ClientRepository clientRepository) {
        this.offerRepository = offerRepository;
        this.clientRepository = clientRepository;
    }

    public OfferStatistic getOfferStatistic() {
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

        return new OfferStatistic(stuffStatistic, clientStatistic, clientSurnames);
    }
}
