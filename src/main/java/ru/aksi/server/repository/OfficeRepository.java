package ru.aksi.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aksi.server.model.Office;

import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository<Office, UUID> {
}
