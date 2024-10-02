package mx.homi.homi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.homi.homi.model.Ingresos;

@Repository
public interface IngresosRepository extends JpaRepository<Ingresos, Long> {
	List<Ingresos> findByFechaBetween(LocalDate from, LocalDate to);
}
