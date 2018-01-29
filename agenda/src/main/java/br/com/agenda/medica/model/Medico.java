package br.com.agenda.medica.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="Medico.findByEspec", query="SELECT e FROM Medico e WHERE e.especialidade = ?"),
@NamedQuery(name="Medico.findByCrm", query="SELECT c FROM Medico c WHERE c.crm = ?")
})
@Table(name="MEDICO")
public class Medico {
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String crm;
	private String especialidade;
	private int idade;
	private boolean isConsulta;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Consultas_Medicas")
	private List<Consulta> consultas;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public boolean isConsulta() {
		return isConsulta;
	}
	public void setConsulta(boolean isConsulta) {
		this.isConsulta = isConsulta;
	}
	
	
}
