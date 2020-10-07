package br.conshare.model.entities;

import java.sql.Timestamp;

public class Mensagem extends BasePojo {
	private Timestamp data_hora;
	private String texto;
	private Long chat_Id;
	public Timestamp getData_hora() {
		return data_hora;
	}
	public void setData_hora(Timestamp data_hora) {
		this.data_hora = data_hora;
	}
	public String getTexto() {
		return texto;
	}
	@Override
	public String toString() {
		return "Mensagem [data_hora=" + data_hora + ", texto=" + texto + ", chat_Id=" + chat_Id + "]";
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Long getChat_Id() {
		return chat_Id;
	}
	public void setChat_Id(Long chat_Id) {
		this.chat_Id = chat_Id;
	}

}
