package ru.aksi.leasingofferservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Set;

public class OfferStatistics {
    @JsonProperty("stuff_statistics")
    private Map<String, Integer> stuffStatistics;
    @JsonProperty("client_statistics")
    private Map<String, Integer> clientStatistics;
    @JsonProperty("client_surnames")
    private Set<String> clientSurnames;


    public Map<String, Integer> getStuffStatistics() {
        return stuffStatistics;
    }

    public void setStuffStatistics(Map<String, Integer> stuffStatistics) {
        this.stuffStatistics = stuffStatistics;
    }

    public Map<String, Integer> getClientStatistics() {
        return clientStatistics;
    }

    public void setClientStatistics(Map<String, Integer> clientStatistics) {
        this.clientStatistics = clientStatistics;
    }

    public Set<String> getClientSurnames() {
        return clientSurnames;
    }

    public void setClientSurnames(Set<String> clientSurnames) {
        this.clientSurnames = clientSurnames;
    }

    public OfferStatistics() {}

    public OfferStatistics(Map<String, Integer> stuffStatistics, Map<String, Integer> clientStatistics, Set<String> clientSurnames) {
        this.stuffStatistics = stuffStatistics;
        this.clientStatistics = clientStatistics;
        this.clientSurnames = clientSurnames;
    }
}
