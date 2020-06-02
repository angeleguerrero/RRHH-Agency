package net.ag.empleos.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.ag.empleos.model.Vacante;
import net.ag.empleos.repository.VacanteRepository;
import net.ag.empleos.services.IVacanteService;

@Service
@Primary
public class VacantesServicejpa implements IVacanteService{
	@Autowired
	private VacanteRepository vrepository;
	
	@Override
	public List<Vacante> buscarTodas() {
		
		return vrepository.findAll();
	}

	@Override
	public Vacante buscarPorID(Integer idvacante) {
		Optional<Vacante> optional =vrepository.findById(idvacante);
		if(optional.isPresent()) {
			return optional.get();
			
		}
		return null;
	}

	@Override
	public void salvar(Vacante vacante) {
		vrepository.save(vacante);
		
	}

}
