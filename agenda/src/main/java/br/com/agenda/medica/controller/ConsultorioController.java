package br.com.agenda.medica.controller;

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

import br.com.agenda.medica.model.Consultorio;
import br.com.agenda.medica.model.Medico;
import br.com.agenda.medica.repository.ConsultorioService;

@RestController
public class ConsultorioController {
	
	@Autowired
	ConsultorioService consultorioService;
	
	
	//End Points
	@RequestMapping(method=RequestMethod.POST, value="/consultorios", consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consultorio> cadastrarMedico(@RequestBody Consultorio consultorio) {
		
		Consultorio cadastraConsultorio = consultorioService.cadastrar(consultorio);
		
		return new ResponseEntity<>(cadastraConsultorio, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/consultorios", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consultorio>> buscarMedico() {
		
		List<Consultorio> listaConsultorios = consultorioService.buscarTodos();
		
		return new ResponseEntity<>(listaConsultorios, HttpStatus.OK);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/consultorios/{id}")
	public ResponseEntity<Medico> removerMedico(@PathVariable Integer id) {
		
		
		Consultorio idConsultorio = consultorioService.buscaPorId(id);
		
		if(idConsultorio == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		consultorioService.excluir(idConsultorio);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
