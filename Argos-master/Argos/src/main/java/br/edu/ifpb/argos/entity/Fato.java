package br.edu.ifpb.argos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_FATO")
public class Fato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_FATO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA")
	private Date data;

	@ManyToOne
//	@Column(name = "INVESTIGACAO")
	private Investigacao investigacao;
	
	public Fato() {
	}

	public Fato(Integer id, String titulo, String descricao, Date data, Investigacao i) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.investigacao = i;
	}

	public Investigacao getInvestigacao() {
		return investigacao;
	}

	public void setInvestigacao(Investigacao investigacao) {
		this.investigacao = investigacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}