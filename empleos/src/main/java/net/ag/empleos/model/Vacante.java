package net.ag.empleos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vacantes")
public class Vacante implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
private Integer id;
private String nombre;
private String descripcion;
private Date fecha;
Double salario;
private String estatus;
private String detalles;
private Integer destacado;
private String imagen="no-image.png";
/*Ignorar atribito para futuro Mapeo*/
//@Transient
@OneToOne
//idCategoria Nombre campo de llave foranea
@JoinColumn(name = "idCategoria")
private Categoria categoria;



public void resetimagen() {
	this.imagen=null;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
public String getEstatus() {
	return estatus;
}
public void setEstatus(String estatus) {
	this.estatus = estatus;
}
public String getDetalles() {
	return detalles;
}
public void setDetalles(String detalles) {
	this.detalles = detalles;
}
public String getImagen() {
	return imagen;
}
public void setImagen(String imagenlistar) {
	this.imagen = imagenlistar;
}
public Integer getDestacado() {
	return destacado;
}
public void setDestacado(Integer destacado) {
	this.destacado = destacado;
}


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public Double getSalario() {
	return salario;
}

public void setSalario(Double salario) {
	this.salario = salario;
}

@Override
public String toString() {
	return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
			+ ", salario=" + salario + ", estatus=" + estatus + ", detalles=" + detalles + ", destacado=" + destacado
			+ ", imagen=" + imagen + ", categoria=" + categoria + "]";
}








	
	
	
}
