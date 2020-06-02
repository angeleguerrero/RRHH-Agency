package net.ag.empleos.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Incrementar MYSQL
	
	
	private Integer id;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;
	private Date fecharegistro;
	
	
	@ManyToMany(fetch = FetchType.EAGER) //Para salvar la consulta de los diferentes perfiles del usuario //Relacion Mucho a Mucho
	@JoinTable(name = "usuarioperfil", 
	joinColumns = @JoinColumn(name="idUsuario"), //Primera llave foranea seria la de la clase principal que se trabaja en el momento
	inverseJoinColumns = @JoinColumn(name="idPerfil")
	)
	private List<Perfil>perfiles;
	//******************************************************
	
	//Para agregar Perfiles correspondientes a un usuarios
	public void agregarUsuario(Perfil tempPerfil) {
		if (perfiles== null) {
			perfiles= new LinkedList<Perfil>();
			
		}
			perfiles.add(tempPerfil);
			
		
		
	}
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String possword) {
		this.password = possword;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer status) {
		this.estatus = status;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}


	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}




	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email
				+ ", password=" + password + ", estatus=" + estatus + ", fecharegistro=" + fecharegistro + ", perfiles="
				+ perfiles + "]";
	}



	
	
	
	
}
