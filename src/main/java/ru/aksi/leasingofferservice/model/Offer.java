package ru.aksi.leasingofferservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import ru.aksi.leasingofferservice.model.util.LocalDateSerializer;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "DB_OFFER")
public class Offer {
    @Id
    private UUID id;
    @Column(name = "serial_number")
    @JsonProperty("serial_number")
    private String serialNumber;
    @Column(name = "sign_date")
    @JsonProperty("sign_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate signDate;
    @Column(name = "ending_date")
    @JsonProperty("ending_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endingDate;
    @Column(name = "start_date")
    @JsonProperty("start_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;
    @ManyToOne(targetEntity = Client.class, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(targetEntity = Stuff.class, optional = false)
    @JoinColumn(name = "stuff_id")
    private Stuff stuff;
    @ManyToOne(targetEntity = Office.class, optional = false)
    @JoinColumn(name = "office_id")
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
