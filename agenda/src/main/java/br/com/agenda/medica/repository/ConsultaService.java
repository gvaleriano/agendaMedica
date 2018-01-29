package br.com.agenda.medica.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.medica.model.Consulta;
import br.com.agenda.medica.model.Medico;

@Service
public class ConsultaService {

	@Autowired
	ConsultaRepository cr;
	
	@Autowired
	MedicoRepository mr;
	
	//Consultas	
		public Consulta cadastrarConsulta(Consulta consulta) {
				return cr.save(consulta);
				
		}
			
		public List<Consulta> buscarConsultas(){
				
			return cr.findAll();
		}
			
		public void excluir(Consulta consulta) {
			cr.delete(consulta);
		}
			
		public Consulta buscaPorIdConsulta(Integer id) {
			
			return cr.findOne(id);
		}
			
		public void excluirConsulta(Consulta consulta) {
			cr.delete(consulta);
		}
		
		public List<Consulta> buscaPorData (String data) {
			
			return cr.findByDate(data);
		}
		
		public List<Consulta> buscaPorMedico (int id) {
			
			return cr.findByCrm(id);
		}
}
