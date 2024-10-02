package mx.homi.homi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Double fijos;
	@Column(nullable = false)
	private String costos;
	@Column(nullable = false)
	private Double almacen;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idProducto")
	List<Ingresos> productos = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idProducto")
	List<Recetas> productosRecetas = new ArrayList<>();
	
	public Productos(){
		
	}//Constructor Vacio
	
	public Productos(String nombre, Double fijos, String costos, Double almacen){
		this.nombre = nombre;
		this.fijos = fijos;
		this.costos = costos;
		this.almacen = almacen;
	}//Constructor con parametros
	
	public Long getIdProductos() {
		return id;
	}//Obtener Id
	
	public String getNombre() {
		return nombre;
	}//Obtener Nombre
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//Actualizar nombre
	
	public Double getFijos() {
		return fijos;
	}//Obtener porcentaje de gastos fijos
	
	public void setFijos(Double fijos) {
		this.fijos = fijos;
	}//Actualizar porcentaje de gastos fijos
	
	public String getCostos(){
		return costos;
	}//Obtener lista de costos
	
	public void setCostos(String costos) {
		this.costos = costos;
	}//Actualizar lista de costos

	public Double getAlmacen() {
		return almacen;
	}//Obtener almacen

	public void setAlmacen(Double almacen) {
		this.almacen = almacen;
	}//Actualizar almacen

	@Override
	public String toString() {
		return "Producto [id= " + id + ", nombre=" + nombre + ", fijos=" + fijos + ", costos="
				+ costos + ", almacen=" + almacen + "]";
	}//Metodo to String

}//Modelo Productos
