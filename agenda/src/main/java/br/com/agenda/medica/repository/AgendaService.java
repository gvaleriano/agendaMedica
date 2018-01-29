package br.com.agenda.medica.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.medica.model.Agenda;
import br.com.agenda.medica.model.Consulta;
import br.com.agenda.medica.model.Consultorio;
import br.com.agenda.medica.model.Medico;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository ar;

	
		private List<Agenda> agendas = new ArrayList<Agenda>();
		private Agenda agenda;
		
	// Agenda Completa
		public Agenda cadastrar(Consulta consulta, Medico medico, Consultorio consultorio) {
			Agenda agenda = new Agenda();
			agenda.setConsulta(consulta);
			agenda.setMedico(medico);
			agenda.setConsultorio(consultorio);
			return ar.save(agenda);
			
		}
		
		public List<Agenda> buscarTodos(Medico medico,Consulta consulta){
			agenda.setConsulta(consulta);
			agenda.setMedico(medico);
			agendas.add(agenda);
			return agendas;
		}


		public void excluir(Agenda agenda) {
			ar.delete(agenda);
		}
		
		public Agenda buscaPorId(Integer id) {
			
			return ar.findOne(id);
		}
}
