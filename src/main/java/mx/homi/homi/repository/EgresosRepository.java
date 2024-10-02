package mx.homi.homi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.homi.homi.model.Egresos;

@Repository
public interface EgresosRepository extends JpaRepository<Egresos, Long> {
	List<Egresos> findByFechaBetween(LocalDate from, LocalDate to);
}
