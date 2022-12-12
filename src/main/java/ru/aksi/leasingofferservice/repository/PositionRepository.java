package ru.aksi.leasingofferservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aksi.leasingofferservice.model.Position;

import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {
}
