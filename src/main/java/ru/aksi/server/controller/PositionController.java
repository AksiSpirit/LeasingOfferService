package ru.aksi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aksi.server.model.Position;
import ru.aksi.server.repository.PositionRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
    private PositionRepository positionRepository;
    @Autowired
    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("")
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
    @GetMapping("/{positionId}")
    public Position getPositionIdById(UUID positionId) {
        return positionRepository.findById(positionId).orElse(null);
    }
}
