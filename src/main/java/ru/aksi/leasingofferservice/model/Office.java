package ru.aksi.leasingofferservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "DB_OFFICE")
public class Office {
    @Id
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "law_address")
    private String lawAddress;
    @Column(name = "cabinet_count")
    private Integer cabinetCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Office(UUID id, String name, String address, String lawAddress, Integer cabinetCount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lawAddress = lawAddress;
        this.cabinetCount = cabinetCount;
    }
}
