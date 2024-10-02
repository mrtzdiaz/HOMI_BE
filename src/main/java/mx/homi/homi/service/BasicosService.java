package mx.homi.homi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Basicos;
import mx.homi.homi.repository.BasicosRepository;

@Service
public class BasicosService {
	private BasicosRepository bR;
	
	@Autowired
	BasicosService(BasicosRepository basicosRepository){
		this.bR = basicosRepository;
	}//Intenciar repositorio de productos basicos
	
	public List<Basicos> getAllBasicos(){
		return bR.findAll();
	}//Obtener todos los productos basicos
	
	public Optional<Basicos> getBasicosById(Long Id){
		return bR.findById(Id);
	}//Obtener un solo producto por Id
	
	public Basicos deleteBasicosById(Long Id) {
		Optional<Basicos> tmpBasico = bR.findById(Id);
		if(tmpBasico.isPresent()) {
			bR.deleteById(Id);
			return tmpBasico.get();
		}
		else {
			System.out.println("No existe ese producto basico");
			return null;
		}
	}//Eliminar un producto con su Id
	
	public Basicos addBasico(Basicos basico) {
		Optional<Basicos> tmpBasico = bR.findByNombre(basico.getNombre());
		if(tmpBasico.isEmpty()) {
			bR.save(basico);
			return basico;
		}
		else {
			System.out.println("Ya existe un producto con ese nombre");
			return null;
		}
	}//Agregar un producto nuevo
	
	public Basicos updateBasico(Long id, String nombre, Double costo, String unidad, Double almacen) {
		Optional<Basicos> tmpBasico = bR.findById(id);
		if(tmpBasico.isPresent()) {
			Basicos basico = tmpBasico.get();
			if(nombre != null)  basico.setNombre(nombre);
			if(costo != null)  basico.setCosto(costo);
			if(unidad != null)  basico.setUnidad(unidad);
			if(almacen != null)  basico.setAlmacen(almacen);
			
			bR.save(basico);
			return basico;
		}
		else {
			System.out.println("No existe ese producto");
			return null;
		}
	}//Modificar Producto Basico
}
