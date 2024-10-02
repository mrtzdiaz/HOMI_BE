package mx.homi.homi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Egresos;
import mx.homi.homi.repository.EgresosRepository;

@Service
public class EgresosService {
	private EgresosRepository eR;
	
	@Autowired
	public EgresosService(EgresosRepository egresosRepository) {
		this.eR = egresosRepository;
	}//Instancia del repositorio
	
	public List<Egresos> getAllEgresos(){
		return eR.findAll();
	}//Obtener todos los egresos
	
	public List<Egresos> getEgresosByFechas(String from, String to) {
		return eR.findByFechaBetween(LocalDate.parse(from), LocalDate.parse(to));
	}//Obtener egreso por Id
	
	public Egresos deleteEgresoById(Long Id) {
		Optional<Egresos> tmpEgreso = eR.findById(Id);
		if(tmpEgreso.isPresent()) {
			eR.deleteById(Id);
			return tmpEgreso.get();
		}
		else {
			System.out.println("No existe ese egreso");
			return null;
		}
	}//Eliminar egreso con Id
	
	public Egresos addEgresos(Egresos egreso) {
		eR.save(egreso);
		return egreso;
	}//Añadir egreso
	
	public Egresos updateEgresos(Long id, LocalDate fecha, String concepto, Double cantidad, Boolean pagado) {
		Optional<Egresos> tmpEgreso = eR.findById(id);
		if(tmpEgreso.isPresent()) {
			Egresos egreso = tmpEgreso.get();
			if(fecha != null) egreso.setFecha(fecha);
			if(concepto != null) egreso.setConcepto(concepto);
			if(cantidad != null) egreso.setCantidad(cantidad);
			if(pagado != null) egreso.setPagado(pagado);
			eR.save(egreso);
			return egreso;
		}else {
			System.out.println("No existe ese egreso");
			return null;
		}
	}//Actualizar un egreso
	
}
