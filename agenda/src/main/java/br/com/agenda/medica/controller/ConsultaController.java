package br.com.agenda.medica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.medica.model.Agenda;
import br.com.agenda.medica.model.Consulta;
import br.com.agenda.medica.model.Consultorio;
import br.com.agenda.medica.model.Medico;
import br.com.agenda.medica.repository.AgendaService;
import br.com.agenda.medica.repository.ConsultaService;
import br.com.agenda.medica.repository.MedicoService;

@RestController
public class ConsultaController {
	
	@Autowired
	ConsultaService consultaService;
	
	@Autowired
	MedicoService medicoService;
	
	@Autowired
	AgendaService agendaService;
	
	//End Points
	@RequestMapping(method=RequestMethod.POST, value="/consultas", consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consulta> cadastrarConsultas(@RequestBody Consulta consulta) {
		
		Agenda ag = new Agenda();
		Medico med = new Medico();
		Consultorio con = new Consultorio();
		
		con.setId(consulta.getIdConsultorio());
		med = medicoService.buscaPorId(consulta.getIdMed());
		consulta.setConsultorio(con);
		consulta.setMedico(med);
		//TODO salvar agenda
//		ag = agendaService.cadastrar(consulta, med, con);
		Consulta salvaConsulta = consultaService.cadastrarConsulta(consulta);
		
		return new ResponseEntity<>(salvaConsulta, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/consultas/{param}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consulta>> buscarConsulta(@PathVariable String param) {
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		
		if(param.contains("medico")) {
			
			Consulta medConsulta = new Consulta();
			
			//remover _medico do parametro
			param = param.replace("_medico", "");
			Medico medico = medicoService.buscaPorCrm(param);
			medConsulta.setMedico(medico);
			
			listaConsulta.add(medConsulta);
			listaConsulta = consultaService.buscaPorMedico(medico.getId());
			
			return new ResponseEntity<>(listaConsulta, HttpStatus.OK);
		}else if(param.contains("date")) {
			
			//remover _select do parametro
			param = param.replace("_date", "");
			param = param.replace("-","/");
			listaConsulta = consultaService.buscaPorData(param);
			return new ResponseEntity<>(listaConsulta, HttpStatus.OK);
		}else {
			
			listaConsulta = consultaService.buscarConsultas();
			
			return new ResponseEntity<>(listaConsulta, HttpStatus.OK);
		}
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/consultas/{id}")
	public ResponseEntity<Medico> removerConsulta(@PathVariable Integer id) {
		
		
		Consulta idConsulta = consultaService.buscaPorIdConsulta(id);
		
		if(idConsulta == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		consultaService.excluirConsulta(idConsulta);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
