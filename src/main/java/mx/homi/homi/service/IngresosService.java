package mx.homi.homi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Ingresos;
import mx.homi.homi.repository.IngresosRepository;

@Service
public class IngresosService {
	private IngresosRepository iR;
	
	@Autowired
	IngresosService(IngresosRepository ingresosRepository){
		this.iR = ingresosRepository;
	}//Intancia del repositorio
	
	public List<Ingresos> getAllIngresos(){
		return iR.findAll();
	}//Obtener el listado de todas los ingresos
	
	public Optional<Ingresos> getIngresoById(Long id){
		return iR.findById(id);
	}//Obtener ingreso por el Id
	
	public List<Ingresos> getIngresosByDate(String from, String to){
		return iR.findByFechaBetween(LocalDate.parse(from), LocalDate.parse(to));
	}
	
	public Ingresos deleteIngresoById(Long id) {
		Optional<Ingresos> tmpIngreso = iR.findById(id);
		if(tmpIngreso.isPresent()) {
			Ingresos ingreso = tmpIngreso.get();
			iR.deleteById(id);
			return ingreso;
		}
		else {
			System.out.println("El id no existe");
			return null;
		}
	}//Eliminar ingreso por Id
	
	public Ingresos addIngreso(Ingresos ingreso) {
		iR.save(ingreso);
		return ingreso;
	}//Agregar ingreso
	
	public Ingresos updateIngreso(Long id, LocalDate fecha, Double cantidad, Double total, Double costo, Integer tipo, Long idProducto, String canal) {
		Optional<Ingresos> tmpIngreso = iR.findById(id);
		if(tmpIngreso.isPresent()) {
			Ingresos ingreso = tmpIngreso.get();
			if(fecha != null) ingreso.setFecha(fecha);
			if(cantidad != null) ingreso.setCantidad(cantidad);
			if(total != null) ingreso.setTotal(total);
			if(tipo != null) ingreso.setTipo(tipo);
			if(costo != null) ingreso.setCosto(costo);
			if(idProducto != null) ingreso.setIdProducto(idProducto);
			if(canal != null) ingreso.setCanal(canal);
			iR.save(ingreso);
			return ingreso;
		}
		else {
			System.out.println("No existe es Id");
			return null;
		}
	}//Actualizar ingreso
}
