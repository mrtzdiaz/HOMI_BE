package mx.homi.homi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Recetas;
import mx.homi.homi.repository.RecetasRepository;

@Service
public class RecetasService {
	private RecetasRepository rR;
	
	@Autowired
	RecetasService(RecetasRepository recetasRepository){
		this.rR = recetasRepository;
	}//Instancia del repositorio
	
	public List<Recetas> getAllRecetas(){
		return rR.findAll();
	}//Obtener todas las recetas
	
	
	public List<Optional<Recetas>> getRecetasByid(Long id){
		return rR.findByIdProducto(id);
	}//Obtener una receta por el id del producto
	
	public Recetas deleteRecetaById(Long id) {
		Optional<Recetas> tmpRecetas = rR.findById(id);
		if(tmpRecetas.isPresent()) {
			Recetas recetas = tmpRecetas.get();
			rR.delete(recetas);
			return recetas;
		}
		else {
			System.out.println("El id no existe");
			return null;
		}
	}//Eliminar una receta por su id
	
	public Recetas addReceta(Recetas receta) {
		rR.save(receta);
		return receta;
	}//Añadir receta
	
	public Recetas updateReceta(Long id, Double cantidad) {
		Optional<Recetas> tmpRecetas = rR.findById(id);
		if(tmpRecetas.isPresent()) {
			Recetas receta = tmpRecetas.get();
			if(cantidad != null) receta.setCantidad(cantidad);
			rR.save(receta);
			return receta;
		}
		else {
			System.out.println("No se encuentra ese iD");
			return null;
		}
	}//Actualizar receta
	
}
