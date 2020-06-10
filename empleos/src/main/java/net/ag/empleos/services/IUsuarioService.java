package net.ag.empleos.services;

import java.util.List;

import net.ag.empleos.model.Usuario;

public interface IUsuarioService {
	void salvar (Usuario usuario);
	List<Usuario> buscarTUsuarios();
	Usuario buscarporID(Integer idUsuario);
	void eliminar (Integer isusuario);
}
