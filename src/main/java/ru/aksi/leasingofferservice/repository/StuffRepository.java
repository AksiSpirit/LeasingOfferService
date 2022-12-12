package ru.aksi.leasingofferservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aksi.leasingofferservice.model.Stuff;

import java.util.UUID;

@Repository
public interface StuffRepository extends JpaRepository<Stuff, UUID> {
}
