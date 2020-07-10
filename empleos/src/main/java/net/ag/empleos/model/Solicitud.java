package net.ag.empleos.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Solicitudes")
public class Solicitud {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment MYSQL	
	private Integer id;
	private Date fecha;
	private String comentarios;
	private String archivos; // El nombre del archivo PDF, DOCX del CV.
	
	
	@OneToOne
	@JoinColumn(name="idVacante") // foreignKey en la tabla de solicitudes
	private Vacante vacante;

	@OneToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario; // foreignKey en la tabla de usuarios


	//public Solicitud() {}




public Usuario getUsuario() {
	return usuario;
}
@Override
public String toString() {
	return "Solicitud [id=" + id + ", fecha=" + fecha + ", comentarios=" + comentarios + ", archivos=" + archivos
			+ ", vacante=" + vacante + ", usuario=" + usuario + "]";
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getComentarios() {
	return comentarios;
}
public void setComentarios(String comentarios) {
	this.comentarios = comentarios;
}
public String getArchivos() {
	return archivos;
}
public void setArchivos(String archivos) {
	this.archivos = archivos;
}










}
