package br.com.agenda.medica.model;

import javax.persistence.*;

@Entity
public class Agenda {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(cascade=CascadeType.ALL)
	private Consultorio consultorio;
	@OneToOne(cascade=CascadeType.ALL)
	private Medico medico;
	@OneToOne(cascade=CascadeType.ALL)
	private Consulta consulta;

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
