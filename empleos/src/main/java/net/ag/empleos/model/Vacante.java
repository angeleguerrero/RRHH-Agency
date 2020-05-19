package net.ag.empleos.model;

import java.util.Date;

public class Vacante {
private int id;
private String nombre;
private String descripcion;
private Date fecha;
double salario;
private String estatus;
private String detalles;
private Integer destacado;
private String imagenlistar;
private Categoria categoria;




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
public String getImagenlistar() {
	return imagenlistar;
}
public void setImagenlistar(String imagenlistar) {
	this.imagenlistar = imagenlistar;
}
public Integer getDestacado() {
	return destacado;
}
public void setDestacado(Integer destacado) {
	this.destacado = destacado;
}
public int getId() {
	return id;
}
public void setId(int id) {
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
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}
@Override
public String toString() {
	return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
			+ ", salario=" + salario + ", estatus=" + estatus + ", detalles=" + detalles + ", destacado=" + destacado
			+ ", imagenlistar=" + imagenlistar + ", categoria=" + categoria + "]";
}








	
	
	
}
