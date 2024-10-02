package mx.homi.homi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.homi.homi.model.Basicos;

@Repository
public interface BasicosRepository extends JpaRepository<Basicos, Long>{
	Optional<Basicos>findByNombre(String nombre);
}
