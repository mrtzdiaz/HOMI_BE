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

import mx.homi.homi.model.Egresos;
import mx.homi.homi.service.EgresosService;

@RestController
@RequestMapping(path = "/api/egresos/")
@CrossOrigin(origins = "http://localhost:5173")
public class EgresosController {
	private EgresosService eS;
	
	@Autowired
	EgresosController(EgresosService egresosService){
		this.eS = egresosService;
	}//Instancia del service
	
	@GetMapping
	public List<Egresos> getAllEgresos(){
		return eS.getAllEgresos();
	}//Obtener todos los egresos
	
	@GetMapping(path = "{from}/{to}")
	public List<Egresos> getEgresoById(@PathVariable("from") String from, @PathVariable("to") String to) {
		return eS.getEgresosByFechas(from, to);
	}//Obtener un egreso por id
	
	@DeleteMapping(path = "{idEgreso}")
	public Egresos deleteEgresoById(@PathVariable("idEgreso") Long id) {
		return eS.deleteEgresoById(id);
	}//Elinar un egreso por id
	
	@PostMapping
	public Egresos addEgreso(@RequestBody Egresos egreso) {
		return eS.addEgresos(egreso);
	}//Añadir un egreso
	
	@PutMapping(path = "{idEgreso}")
	public Egresos updateEgresoById(
			@PathVariable("idEgreso") Long id,
			@RequestParam(required = false) LocalDate fecha,
			@RequestParam(required = false) String concepto,
			@RequestParam(required = false) Double cantidad,
			@RequestParam(required = false) Boolean pagado
			) {
		return eS.updateEgresos(id, fecha, concepto, cantidad, pagado);
	}//Actualizar egreso por Id
	
}
