package br.conshare.model.entities;

import java.sql.Timestamp;

public class Usuario extends BasePojo{
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Timestamp getAno_nascimento() {
		return ano_nascimento;
	}
	public void setAno_nascimento(Timestamp ano_nascimento) {
		this.ano_nascimento = ano_nascimento;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFormacao_academica() {
		return formacao_academica;
	}
	public void setFormacao_academica(String formacao_academica) {
		this.formacao_academica = formacao_academica;
	}
	public boolean isVerificacao() {
		return verificacao;
	}
	public void setVerificacao(boolean verificacao) {
		this.verificacao = verificacao;
	}
	public String getInteresses_de_pesquisa() {
		return interesses_de_pesquisa;
	}
	public void setInteresses_de_pesquisa(String interesses_de_pesquisa) {
		this.interesses_de_pesquisa = interesses_de_pesquisa;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", cpf=" + cpf + ", nome=" + nome + ", ano_nascimento=" + ano_nascimento
				+ ", nick_name=" + nick_name + ", senha=" + senha + ", tipo=" + tipo + ", formacao_academica="
				+ formacao_academica + ", verificacao=" + verificacao + ", interesses_de_pesquisa="
				+ interesses_de_pesquisa + ", formacao=" + formacao + "]";
	}
	private String email;
	private String cpf;
	private String nome;
	private Timestamp ano_nascimento;
	private String nick_name;
	private String senha;
	private String tipo;
	private String formacao_academica;
	private boolean verificacao;
	private String interesses_de_pesquisa;
	private String formacao;

}
