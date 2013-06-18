package br.com.scsmarttech.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name= "pessoa")
public class Cliente {

	@Id
	private BigDecimal idpessoa;
	private String nome;
	private String tipo;
	private String razaosocial;
	private String numdocumento;
	private String email;
	
	public Cliente() {
		super();
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}
	public void setNumdocumento(String numdocumento) {
		this.numdocumento = numdocumento;
	}
	
	public BigDecimal getIdpessoa() {
		return idpessoa;
	}
	public String getNome() {
		return nome;
	}
	public String getTipo() {
		return tipo;
	}
	public String getRazaosocial() {
		return razaosocial;
	}
	public String getNumdocumento() {
		return numdocumento;
	}

	@Override
	public String toString() {
		return "Cliente [idpessoa=" + idpessoa + ", nome=" + nome + ", tipo="
				+ tipo + ", razaosocial=" + razaosocial + ", numdocumento="
				+ numdocumento + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}