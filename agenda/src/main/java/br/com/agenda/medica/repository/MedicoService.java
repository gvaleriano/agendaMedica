package br.com.agenda.medica.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.medica.model.Medico;

@Service
public class MedicoService {
	
	@Autowired
	MedicoRepository mr;

		private List<Medico> medicos = new ArrayList<Medico>();
		private Integer id = 1;
		
	// Medicos	
		public Medico cadastrar(Medico medico) {
			
			return mr.save(medico);
			
		}
		
		public List<Medico> buscarTodos(){
			
			return mr.findAll();
		}
		
		public void excluir(Medico medico) {
			mr.delete(medico);
		}
		
		public Medico buscaPorId(Integer id) {
			
			return mr.findOne(id);
		}

		public List<Medico> findByEspec (String especialidade) {
			
			return mr.findByEspec(especialidade);
		}
		
		public Medico buscaPorCrm (String crm) {
			
			return mr.findByCrm(crm);
		}
}
