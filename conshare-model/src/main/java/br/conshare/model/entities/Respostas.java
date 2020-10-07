package br.conshare.model.entities;

import java.sql.Timestamp;

public class Respostas extends BasePojo{
	
	private long duvida_id;
	private long usuario_id;
	private Timestamp data_hora;
	private String texto;
	public long getDuvida_id() {
		return duvida_id;
	}
	public void setDuvida_id(long duvida_id) {
		this.duvida_id = duvida_id;
	}
	public long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Timestamp getData_hora() {
		return data_hora;
	}
	public void setData_hora(Timestamp data_hora) {
		this.data_hora = data_hora;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	@Override
	public String toString() {
		return "Respostas [duvida_id=" + duvida_id + ", usuario_id=" + usuario_id + ", data_hora=" + data_hora
				+ ", texto=" + texto + "]";
	}
	
	

}
