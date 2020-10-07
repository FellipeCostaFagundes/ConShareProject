package br.conshare.model.entities;

public class Duvida extends BasePojo {

	private String titulo;
	private String categoria;
	private String descricao;
	private Long usuarioId;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	@Override
	public String toString() {
		return "Duvida [titulo=" + titulo + ", categoria=" + categoria + ", descricao=" + descricao + ", usuarioId="
				+ usuarioId + "]";
	}
	
	
	

}
