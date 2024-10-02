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

import mx.homi.homi.model.Basicos;
import mx.homi.homi.service.BasicosService;

@RestController
@RequestMapping(path = "/api/basicos/")
@CrossOrigin(origins = "http://localhost:5173")
public class BasicosController {
	private BasicosService bS;
	
	@Autowired
	BasicosController(BasicosService basicosService){
		this.bS = basicosService;
	}//Instancia del servicio de basicos
	
	@GetMapping
	public List<Basicos> getAll(){
		return bS.getAllBasicos();
	}//Regresar todos los basicos
	
	@GetMapping(path = "{idBasico}")
	public Optional<Basicos> getBasicoById(@PathVariable("idBasico") Long id) {
		return bS.getBasicosById(id);
	}//Obtener un producto basico por Id
	
	@DeleteMapping(path = "{idBasico}")
	public Basicos deleteBasicoById(@PathVariable("idBasico") Long id) {
		return bS.deleteBasicosById(id);
	}//Eliminar un producto basico por Id
	
	@PostMapping
	public Basicos addBasico(@RequestBody Basicos basico) {
		return bS.addBasico(basico);
	}//Añadir un producto basico
	
	@PutMapping(path = "{idBasicos}")
	public Basicos updateBasico(
			@PathVariable("idBasicos") Long Id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Double costo,
			@RequestParam(required = false) String unidad,
			@RequestParam(required = false) Double almacen) {
		return bS.updateBasico(Id, nombre, costo, unidad, almacen);
	}//Actualizar información de un producto basico
	
}
