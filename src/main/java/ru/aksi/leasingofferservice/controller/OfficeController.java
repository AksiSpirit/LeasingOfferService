package ru.aksi.leasingofferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aksi.leasingofferservice.model.Office;
import ru.aksi.leasingofferservice.repository.OfficeRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {
    private OfficeRepository officeRepository;
    @Autowired
    public OfficeController(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @GetMapping("")
    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }
    @GetMapping("/{officeId}")
    public Office getOfficeIdById(UUID officeId) {
        return officeRepository.findById(officeId).orElse(null);
    }
}
