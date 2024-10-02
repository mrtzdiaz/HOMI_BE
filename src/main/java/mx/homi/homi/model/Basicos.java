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
@Table(name = "basicos")
public class Basicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long Id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Double costo;
	@Column(nullable = false)
	private String unidad;
	@Column(nullable = false)
	private Double almacen;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idBasico")
	List<Recetas> basicos = new ArrayList<>();
	
	public String getNombre() {
		return nombre;
	}//Obtener nombre
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//Actualizar nombre
	
	public Double getCosto() {
		return costo;
	}//Obtener costo
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}//Actualizar costo
	
	public String getUnidad() {
		return unidad;
	}//Obtener unidad de medida
	
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}//Actualizar unidad de medida
	
	public Double getAlmacen() {
		return almacen;
	}//Obtener stock de almacen
	
	public void setAlmacen(Double almacen) {
		this.almacen = almacen;
	}//Actualizar stock de almacen
	
	public Long getId() {
		return Id;
	}//Obtener Id del producto

	@Override
	public String toString() {
		return "Basicos [Id=" + Id + ", nombre=" + nombre + ", costo=" + costo + ", unidad=" + unidad + ", almacen="
				+ almacen + "]";
	}//Metodo toString
		
}
