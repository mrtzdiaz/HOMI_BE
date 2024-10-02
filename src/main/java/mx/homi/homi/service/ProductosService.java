package mx.homi.homi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.homi.homi.model.Productos;
import mx.homi.homi.repository.ProductosRepository;

@Service
public class ProductosService {
	
	private final ProductosRepository productosRepo;
	
	@Autowired
	public ProductosService(ProductosRepository productoRepository) {
		this.productosRepo = productoRepository;
	}//Constructor del Servicio
	
	public List<Productos> getAllProductos(){
		return productosRepo.findAll();
	}//Obtener el listado de todos los productos
	
	public Optional<Productos> getProductoById(Long Id) {
		return productosRepo.findById(Id);
	}//Obtener un producto por Id
	
	public Optional<Productos> getProductoByNombre(String nombre){
		return productosRepo.findByNombre(nombre);
	}//Obtener un producto por su nombre
	
	public Optional<Productos> deleteProductoById(Long Id){
		Optional<Productos> tmpProducto = productosRepo.findById(Id);
		if(tmpProducto.isPresent()) {
			productosRepo.deleteById(Id);;
		}
		return tmpProducto;
	}//Eliminar un producto por su Id
	
	public Productos addProducto(Productos producto){
		Optional<Productos> tmpProducto = productosRepo.findByNombre(producto.getNombre());
		if(!tmpProducto.isEmpty()) {
			System.out.println("El producto indicado ya existe");
			return null;
		}else {
			productosRepo.save(producto);
			return producto;
		}
	}//Añadir un nuevo producto
	
	public Productos updateProducto(Long Id, String nombre, Double fijos, String costos, Double almacen) {
		Optional<Productos> tmpProducto = productosRepo.findById(Id);
		if(tmpProducto.isPresent()) {
			Productos producto = tmpProducto.get();
			if(nombre != null) producto.setNombre(nombre);
			if(fijos != null) producto.setFijos(fijos);
			if(costos != null) producto.setCostos(costos);
			if(almacen != null) producto.setAlmacen(almacen);
			productosRepo.save(producto);
			return producto;
		}else {
			System.out.println("El producto no existe");
			return null;
		}
	}
	
}
