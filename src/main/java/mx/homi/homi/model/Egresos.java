package mx.homi.homi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "egresos")
public class Egresos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long Id;
	@Column(nullable = false)
	private LocalDate fecha;
	@Column(nullable = false)
	private String concepto;
	@Column(nullable = false)
	private Double cantidad;
	@Column(nullable = false)
	private Boolean pagado;
	
	public LocalDate getFecha() {
		return fecha;
	}//Obtener fecha del egreso
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}//Actualizar fecha del egreso
	
	public String getConcepto() {
		return concepto;
	}//Obtener concepto del egreso
	
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}//Actualizar concepto del egreso
	
	public Double getCantidad() {
		return cantidad;
	}//Obtener cantidad del egreso
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}//Actualizar cantidad del egreso
	
	public Boolean getPagado() {
		return pagado;
	}//Obtender status del pago 
	
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}//Actualizar status del pago
	
	public Long getId() {
		return Id;
	}//Obtener Id del egreso
	
	
}
