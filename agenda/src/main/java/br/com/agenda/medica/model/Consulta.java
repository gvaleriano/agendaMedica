package br.com.agenda.medica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
@NamedQuery(name="Consulta.findByCrm", query="SELECT m FROM Consulta m WHERE m.idMed = ?"),
@NamedQuery(name="Consulta.findByDate", query="SELECT c FROM Consulta c WHERE c.data = ?")
})
@Table(name="CONSULTA")
public class Consulta {

	@Id
	@GeneratedValue
	private int id;
	private String nomePaciente;
	private String especConsulta;
	@Transient
	private int idConsultorio;
	private int idMed;
	//aplicação simples de dt e hora
	private String data;
	private String hora;
	@OneToOne
	private Consultorio consultorio;
	@OneToOne
	private Medico medico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	
	public String getEspecConsulta() {
		return especConsulta;
	}
	public void setEspecConsulta(String especConsulta) {
		this.especConsulta = especConsulta;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
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
	public int getIdConsultorio() {
		return idConsultorio;
	}
	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}
	public int getIdMed() {
		return idMed;
	}
	public void setIdMed(int idMed) {
		this.idMed = idMed;
	}
	
	
	
	
}
