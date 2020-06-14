package net.ag.empleos.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ag.empleos.model.Usuario;
import net.ag.empleos.repository.UsuarioRepository;
import net.ag.empleos.services.IUsuarioService;

@Service
@Primary
public class UsuarioServidejpa implements IUsuarioService {

	@Autowired
	private UsuarioRepository urepository;

	@Override
	public void salvar(Usuario usuario) {
		urepository.save(usuario);
	}

	@Override
	public List<Usuario> buscarTUsuarios() {
		return urepository.findAll();
	}

	@Override
	public Usuario buscarporID(Integer idUsuario) {
		
	Optional<Usuario> optional=	urepository.findById(idUsuario);
	if(optional.isPresent()) {
		return optional.get();
		
	}
		return null;
	}

	@Override
	public void eliminar(Integer isusuario) {
		urepository.deleteById(isusuario);
		
	}
	
	
	
	
	
}
