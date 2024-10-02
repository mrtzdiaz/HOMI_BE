package mx.homi.homi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingresos")
public class Ingresos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private LocalDate fecha;
	@Column(nullable = false)
	private String canal;
	@Column(nullable = false)
	private Double cantidad;
	@Column(nullable = false)
	private Double total;
	@Column(nullable = false)
	private Integer tipo;
	@Column(nullable = false)
	private Double costo;
	@Column(nullable = true)
	private Long idProducto;
	
	public LocalDate getFecha() {
		return fecha;
	}//Obtener Fecha de Ingreso
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}//Actualizar fecha de Ingreso
	
	public Double getCantidad() {
		return cantidad;
	}//Obtener la cantidad vendida
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}//Actualizar la cantidad vendida
	
	public Double getTotal() {
		return total;
	}//Obtener el total vendido
	
	public void setTotal(Double total) {
		this.total = total;
	}//Actualizar el total vendido
	
	public Integer getTipo() {
		return tipo;
	}//Obtener el tipo de venta
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}//Actualizar el tipo de venta
	
	public Double getCosto() {
		return costo;
	}//Obtener el costo del producto
	
	public void setCosto(Double costo) {
		this.costo = costo;
	}//Actualizar el costo del producto
	
	public Long getIdProducto() {
		return idProducto;
	}//Obtener el id del producto
	
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}//Actualizar el id del producto
	
	public Long getId() {
		return id;
	}//Obtener el id del ingreso

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}
	
	
	
}
