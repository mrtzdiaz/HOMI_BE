package mx.homi.homi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.homi.homi.model.Recetas;

@Repository
public interface RecetasRepository extends JpaRepository<Recetas, Long>{
	List<Optional<Recetas>>findByIdProducto(Long id);

}
