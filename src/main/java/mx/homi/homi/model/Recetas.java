package mx.homi.homi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recetas")
public class Recetas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Double cantidad;
	@Column(nullable = true)
	private Long idProducto;
	@Column(nullable = true)
	private Long idBasico;
	
	public Double getCantidad() {
		return cantidad;
	}//Obtener cantidad
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}//Actualizar cantidad
	
	public Long getIdProducto() {
		return idProducto;
	}//Obtener Idproducto
	
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}//Actualizar idProducto
	
	public Long getIdBasico() {
		return idBasico;
	}//Obtener idBasico
	
	public void setIdBasico(Long idBasico) {
		this.idBasico = idBasico;
	}//Actualizar idBasico
	
	public Long getId() {
		return id;
	}//Obtener id de la receta
		
}
