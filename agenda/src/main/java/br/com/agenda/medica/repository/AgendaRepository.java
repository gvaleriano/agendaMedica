package br.com.agenda.medica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.medica.model.Agenda;

public interface AgendaRepository extends JpaRepository <Agenda, Integer>{

}
