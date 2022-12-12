package ru.aksi.leasingofferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aksi.leasingofferservice.model.Stuff;
import ru.aksi.leasingofferservice.repository.StuffRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stuff")
public class StuffController {
    private StuffRepository stuffRepository;
    @Autowired
    public StuffController(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }

    @GetMapping("")
    public List<Stuff> getAllStuff() {
        return stuffRepository.findAll();
    }
    @GetMapping("/{stuffId}")
    public Stuff getStuffIdById(UUID stuffId) {
        return stuffRepository.findById(stuffId).orElse(null);
    }
}
