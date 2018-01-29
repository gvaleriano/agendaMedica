package br.com.agenda.medica.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.medica.model.Consultorio;

@Service
public class ConsultorioService {
	@Autowired
	ConsultorioRepository cr;

	// Consultorios	
		public Consultorio cadastrar(Consultorio consultorio) {
			
			return cr.save(consultorio);
			
		}
		
		public List<Consultorio> buscarTodos(){
			
			return cr.findAll();
		}
		
		public void excluir(Consultorio consultorio) {
			cr.delete(consultorio);
		}
		
		public Consultorio buscaPorId(Integer id) {
			
			return cr.findOne(id);
		}
}
