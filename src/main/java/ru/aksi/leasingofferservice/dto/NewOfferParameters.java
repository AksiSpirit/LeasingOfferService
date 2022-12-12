package ru.aksi.leasingofferservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public class NewOfferParameters {
    @JsonProperty("clinet_id")
    private UUID clientId;
    @JsonProperty("stuff_id")
    private UUID stuffId;
    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("ending_date")
    private LocalDate endingDate;


    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getStuffId() {
        return stuffId;
    }

    public void setStuffId(UUID stuffId) {
        this.stuffId = stuffId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public NewOfferParameters() {}

    public NewOfferParameters(UUID clientId, UUID stuffId, LocalDate startDate, LocalDate endingDate) {
        this.clientId = clientId;
        this.stuffId = stuffId;
        this.startDate = startDate;
        this.endingDate = endingDate;
    }
}
