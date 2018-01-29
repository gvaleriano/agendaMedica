package br.com.agenda.medica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.medica.model.Consultorio;

public interface ConsultorioRepository extends JpaRepository <Consultorio, Integer> {

}
