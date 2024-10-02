package mx.homi.homi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.homi.homi.model.Recetas;
import mx.homi.homi.service.RecetasService;

@RestController
@RequestMapping(path = "/api/recetas/")
@CrossOrigin(origins = "http://localhost:5173")
public class RecetasController {
	private RecetasService rS;
	
	@Autowired
	RecetasController(RecetasService recetasService) {
		this.rS = recetasService;
	}//Intancia del servicio
	
	@GetMapping
	public List<Recetas> getAllRecetas(){
		return rS.getAllRecetas();
	}//Obtener todas la recetas
	
	@GetMapping(path = "{idReceta}")
	public List<Optional<Recetas>> getRecetaById(@PathVariable("idReceta") Long id){
		return rS.getRecetasByid(id);
	}//Obtener receta por su id
	
	@DeleteMapping(path = "{idReceta}")
	public Recetas deleteRecetaById(@PathVariable("idReceta") Long id) {
		return rS.deleteRecetaById(id);
	}//Elinar receta por su Id
	
	@PostMapping
	public Recetas addRecetas(@RequestBody Recetas receta) {
		return rS.addReceta(receta);
	}//Añadir receta por su id
	
	@PutMapping(path = "{idReceta}")
	public Recetas updateReceta(
			@PathVariable("idReceta") Long id,
			@RequestParam(required = false) Double cantidad) {
		return rS.updateReceta(id, cantidad);
	}//Actualizar receta por su id
	
}
