package ru.aksi.leasingofferservice.model;

import jakarta.persistence.Entity;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Entity
@Table(name = "office")
public class Office {
    private UUID id;
    private String address;
    private String lawAddress;
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

    public Office(UUID id,
                  String address,
                  String lawAddress,
                  Integer cabinetCount) {
        this.id = id;
        this.address = address;
        this.lawAddress = lawAddress;
        this.cabinetCount = cabinetCount;
    }
}
