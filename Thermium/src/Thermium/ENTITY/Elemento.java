package Thermium.ENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Thermium.ENTITY.SubstanciaElemento;

@Entity
@Table(name = "TBELEMENTO")
public class Elemento implements java.io.Serializable {

	@Column(name = "NOME_TBELEMENTO", nullable = false)
	private String nome;
	@Id
	@Column(name = "NUMEROATOMICO_TBELEMENTO", nullable = false)
	private int numeroAtomico;
	@Column(name = "SIMBOLO_TBELEMENTO", nullable = false, length = 3)
	private String simbolo;

	@OneToMany(mappedBy = "elemento", cascade = CascadeType.REMOVE)
	private List<SubstanciaElemento> substanciaElemento = new ArrayList<SubstanciaElemento>();
	
	
	public Elemento() {
		super();
	}

	public Elemento(String nome, int numeroAtomico, String simbolo) {
		super();
		this.nome = nome;
		this.numeroAtomico = numeroAtomico;
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroAtomico() {
		return numeroAtomico;
	}

	public void setNumeroAtomico(int numeroAtomico) {
		this.numeroAtomico = numeroAtomico;
	}

	@Override
	public String toString() {
		return "Elemento [nome=" + nome + ", numeroAtomico=" + numeroAtomico + ", simbolo=" + simbolo + "]";
	}
	
	

}
