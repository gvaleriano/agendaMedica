package br.com.agenda.medica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.medica.model.Consulta;

public interface ConsultaRepository extends JpaRepository <Consulta, Integer>{

	public List<Consulta> findByCrm (int id);
	
	public List<Consulta> findByDate (String data);
}
