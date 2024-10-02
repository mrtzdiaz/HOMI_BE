package mx.homi.homi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.homi.homi.model.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
	Optional<Productos>findByNombre(String Nombre);		
	
}//Repositorio Productos

