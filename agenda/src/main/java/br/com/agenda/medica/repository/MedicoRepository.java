package br.com.agenda.medica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.medica.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Integer>{

		public List<Medico> findByEspec(String especialidade);
		
		public Medico findByCrm(String crm);
}
