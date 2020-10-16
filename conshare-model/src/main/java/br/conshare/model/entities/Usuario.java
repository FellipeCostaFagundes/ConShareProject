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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nick_name) {
		this.nickname = nick_name;
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
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@Override
	public String toString() {
		return "Usuario [email=" + email + ", cpf=" + cpf + ", nome=" + nome + ", ano_nascimento=" + ano_nascimento
				+ ", nick_name=" + nickname + ", senha=" + senha + ", tipo=" + tipo + ", verificacao=" + verificacao + ", interesses_de_pesquisa="
				+ interesses_de_pesquisa + ", formacao=" + formacao + ", descricao=" + descricao +", celular=" + celular + ", sobrenome= " + sobrenome + "]";
	}
	
	private String nome;
	private String sobrenome;
	private String senha;
	private String email;
	private String celular;
	private String cpf;
	private String tipo;
	private String nickname;
	private Timestamp ano_nascimento;
	private String descricao;
	private String formacao;
	private boolean verificacao;
	private String interesses_de_pesquisa;
	
	
	
	
    
	
	

}
