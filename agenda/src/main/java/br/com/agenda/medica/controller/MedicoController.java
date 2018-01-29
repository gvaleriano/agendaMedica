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

import br.com.agenda.medica.model.Medico;
import br.com.agenda.medica.repository.MedicoService;

@RestController
public class MedicoController {
	
	@Autowired
	MedicoService medicoService;
	
	
	//End Points
	@RequestMapping(method=RequestMethod.POST, value="/medicos", consumes=MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medico> cadastrarMedico(@RequestBody Medico medico) {
		
		Medico guardaMedico = medicoService.cadastrar(medico);
		
		return new ResponseEntity<Medico>(guardaMedico, HttpStatus.CREATED);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/medicos/{especConsulta}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Medico>> buscarMedico(@PathVariable String especConsulta) {
		//List<Medico> listaMedicos = medicoService.buscarTodos();
		if(especConsulta.contains("_select")) {
			List<Medico> listaMedicos = new ArrayList<Medico>();
			//remover _select do parametro
			especConsulta = especConsulta.replace("_select", "");
			Medico medico = medicoService.buscaPorId(Integer.parseInt(especConsulta));
			listaMedicos.add(medico);
			return new ResponseEntity<>(listaMedicos, HttpStatus.OK);
		}else {
			List<Medico> listaMedicos = medicoService.findByEspec(especConsulta);
			return new ResponseEntity<>(listaMedicos, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/medicos/{id}")
	public ResponseEntity<Medico> removerMedico(@PathVariable Integer id) {
		
		
		Medico idMedico = medicoService.buscaPorId(id);
		
		if(idMedico == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		medicoService.excluir(idMedico);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}
