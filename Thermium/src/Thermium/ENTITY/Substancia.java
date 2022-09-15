package Thermium.ENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Thermium.ENTITY.Elemento;
import Thermium.ENTITY.SubstanciaElemento;
import javax.persistence.FetchType;

@Entity
@Table(name="TBSUBSTANCIA")
public class Substancia implements java.io.Serializable{
	
	@Column(name = "ENTALPIA_TBSUBSTANCIA")
	private Double entalpia;
	@Column(name = "NOME_TBSUBSTANCIA")
	private String nome;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_TBSUBSTANCIA")
//	@Column(name="ROWID", updatable=false, insertable=false)
	private int idSubstancia;
	@Column(name = "FORMULA_TBSUBSTANCIA", nullable = false)
	private String formula;
	@Column(name = "ESTADOFISICO_TBSUBSTANCIA")
	private String estado;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "substancia", cascade = CascadeType.REMOVE)
	private List<SubstanciaElemento> substanciaElemento = new ArrayList<SubstanciaElemento>();
	
	
//	@ManyToMany
//	@JoinTable(
//		name="TBSUBSTANCIAELEMENTO",
//		joinColumns={@JoinColumn(name="ID_TBSUBSTANCIA")},
//		inverseJoinColumns={@JoinColumn(name="NUMEROATOMICO_TBELEMENTO")}
//	)
//	private List<Elemento> elementos;
	
	
	
	
	public Substancia(Double entalpia, String nome, String formula, String estado) {
		super();
		this.entalpia = entalpia;
		this.nome = nome;
		this.formula = formula;
		this.estado = estado;
		
	}

	public Substancia() {
	}

	public Double getEntalpia() {
		return entalpia;
	}

	public void setEntalpia(Double entalpia) {
		this.entalpia = entalpia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return this.idSubstancia;
	}


	public List<SubstanciaElemento> getSubstanciaElemento() {
		return substanciaElemento;
	}

	
	public void addSubstanciaElemento(SubstanciaElemento substanciaElemento) {
		this.substanciaElemento.add(substanciaElemento);
	}


	public List<Elemento> getElementos() {
		List<Elemento> elementos = new ArrayList<Elemento>();
		
		for(SubstanciaElemento se : this.substanciaElemento) {
			elementos.add(se.getElemento());
		}
		
		
		return elementos;
	}



	@Override
	public String toString() {
		return "Substancia [entalpia=" + entalpia + ", nome=" + nome + ", idSubstancia=" + idSubstancia + ", formula="
				+ formula + ", estado=" + estado + "]";
	}

	public int getNumAtomos() {
		int qtd = 0;
		
		for(SubstanciaElemento se : this.substanciaElemento) {
			qtd = qtd + se.getQuantidade();
		}
		
		
		return qtd;
	}
	
	
	
	

}
