package Thermium.ENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Thermium.ENTITY.Elemento;
import Thermium.ENTITY.Substancia;

@Entity
@Table(name="TBSUBSTANCIAELEMENTO")


public class SubstanciaElemento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_TBSUBSTANCIAELEMENTO")
	int id_tbsubstanciaelemento;
	
	@Column(name = "QUANTIDADE", nullable = false)
	private int quantidade;
	
	
	@ManyToOne( cascade = CascadeType.REMOVE)
	@JoinColumn(name = "ID_TBSUBSTANCIA")
	private Substancia substancia;
	
	
	@ManyToOne
	@JoinColumn(name = "NUMEROATOMICO_TBELEMENTO")
	private Elemento elemento;
	
	
	public SubstanciaElemento() {
		
	}


	
	public SubstanciaElemento(int quantidade, Substancia substancia, Elemento elemento) {
		super();
		this.quantidade = quantidade;
		this.substancia = substancia;
		this.elemento = elemento;
	}

	

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public Substancia getSubstancia() {
		return substancia;
	}



	public void setSubstancia(Substancia substancia) {
		this.substancia = substancia;
	}



	public Elemento getElemento() {
		return elemento;
	}



	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

}