package ru.aksi.leasingofferservice.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Offer {
    private UUID id;
    private String serialNumber;
    private LocalDate signDate;
    private LocalDate endingDate;
    private LocalDate startDate;
    private Client client;
    private Stuff stuff;
    private Office office;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }


    public Offer() {
    }

    public Offer(UUID id,
                 String serialNumber,
                 LocalDate signDate,
                 LocalDate endingDate,
                 LocalDate startDate,
                 Client client,
                 Stuff stuff,
                 Office office) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.signDate = signDate;
        this.endingDate = endingDate;
        this.startDate = startDate;
        this.client = client;
        this.stuff = stuff;
        this.office = office;
    }
}
