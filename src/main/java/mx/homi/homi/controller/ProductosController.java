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

import mx.homi.homi.model.Productos;
import mx.homi.homi.service.ProductosService;

@RestController
@RequestMapping(path="/api/productos/")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductosController {
	private ProductosService productoServ;
	
	@Autowired
	public ProductosController(ProductosService productosService) {
		this.productoServ = productosService;
	}//Instanciar el objeto ProductoService
	
	@GetMapping
	public List<Productos> getAllProductos(){
		return productoServ.getAllProductos();
	}//Solicitud Get para obtener todos los Productos
	
	@GetMapping(path = "{idProducto}")
	public Optional<Productos> getProductoById(@PathVariable("idProducto") Long id){
		return productoServ.getProductoById(id);
	}//Solicitud Get para obtener un producto con el Id
	
	@DeleteMapping(path = "{idProducto}")
	public Optional<Productos> deleteProductoById(@PathVariable("idProducto") Long id){
		return productoServ.deleteProductoById(id);
	}//Solicitud Delete para eliminar un producto
	
	@PostMapping
	public Productos addProducto(@RequestBody Productos producto) {
		return productoServ.addProducto(producto);
	}
	
	@PutMapping(path = "{idProducto}")
	public Productos updateProducto(
			@PathVariable("idProducto") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) Double fijos,
			@RequestParam(required = false) String costos,
			@RequestParam(required = false) Double almacen) {
		return productoServ.updateProducto(id, nombre, fijos, costos, almacen);
	}
}
