package ru.aksi.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "DB_OFFICE")
public class Office {
    @Id
    @JsonProperty("id")
    private UUID id;
    @Column(name = "address")
    private String address;
    @Column(name = "law_address")
    @JsonProperty("law_address")
    private String lawAddress;
    @Column(name = "cabinet_count")
    @JsonProperty("cabinet_count")
    private Integer cabinetCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawAddress() {
        return lawAddress;
    }

    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    public Integer getCabinetCount() {
        return cabinetCount;
    }

    public void setCabinetCount(Integer cabinetCount) {
        this.cabinetCount = cabinetCount;
    }

    public Office() {
    }

    public Office(UUID id, String address, String lawAddress, Integer cabinetCount) {
        this.id = id;
        this.address = address;
        this.lawAddress = lawAddress;
        this.cabinetCount = cabinetCount;
    }
}
