package br.conshare.model.entities;

import java.sql.Timestamp;

public class Comentario extends BasePojo {
	public Timestamp getData_hora() {
		return data_hora;
	}
	public void setData_hora(Timestamp data_hora) {
		this.data_hora = data_hora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTexto_sugestao() {
		return texto_sugestao;
	}
	public void setTexto_sugestao(String texto_sugestao) {
		this.texto_sugestao = texto_sugestao;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getTexto_descricao() {
		return texto_descricao;
	}
	public void setTexto_descricao(String texto_descricao) {
		this.texto_descricao = texto_descricao;
	}
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	@Override
	public String toString() {
		return "Comentario [data_hora=" + data_hora + ", tipo=" + tipo + ", texto_sugestao=" + texto_sugestao
				+ ", motivo=" + motivo + ", texto_descricao=" + texto_descricao + ", usuario_id=" + usuario_id + "]";
	}
	private Timestamp data_hora;
	private String tipo;
	private String texto_sugestao;
	private String motivo;
	private String texto_descricao;
	private Long usuario_id;

}
