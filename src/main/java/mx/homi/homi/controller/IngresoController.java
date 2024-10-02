package mx.homi.homi.controller;

import java.time.LocalDate;
import java.util.List;

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

import mx.homi.homi.model.Ingresos;
import mx.homi.homi.service.IngresosService;

@RestController
@RequestMapping(path = "/api/ingresos/")
@CrossOrigin(origins = "http://localhost:5173")
public class IngresoController {
	private IngresosService iS;
	
	@Autowired
	IngresoController(IngresosService ingresosService){
		this.iS = ingresosService;
	}//Instancia del servicio
	
	@GetMapping
	public List<Ingresos> getAllIngresos(){
		return iS.getAllIngresos();
	}//Obtener todos los ingresos
	
	@GetMapping(path = "{fechaFrom}/{fechaTo}")
	public List<Ingresos> getIngresoById(@PathVariable("fechaFrom") String from, @PathVariable("fechaTo") String to) {
		return iS.getIngresosByDate(from, to);
	}//Obtener ingreso por id
	
	@DeleteMapping(path = "{idIngresos}")
	public Ingresos deleteIngresoById(@PathVariable("idIngresos") Long id) {
		return iS.deleteIngresoById(id);
	}//Eliminar ingreso por id
	
	@PostMapping
	public Ingresos addIngreso(@RequestBody Ingresos ingreso) {
		return iS.addIngreso(ingreso);
	}//Añadir un Ingreso
	
	@PutMapping(path = "{idIngreso}")
	public Ingresos updateIngreso(
			@PathVariable("idIngreso") Long id,
			@RequestParam(required = false) LocalDate fecha,
			@RequestParam(required = false) Double cantidad,
			@RequestParam(required = false) Double costo,
			@RequestParam(required = false) Integer tipo,
			@RequestParam(required = false) Long idProducto,
			@RequestParam(required = false) Double total,
			@RequestParam(required = false) String canal) {
	return iS.updateIngreso(id, fecha, cantidad, total, costo, tipo, idProducto, canal);
	}
	
}
