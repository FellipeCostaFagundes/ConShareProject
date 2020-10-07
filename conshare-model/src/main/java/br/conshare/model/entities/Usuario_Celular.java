package br.conshare.model.entities;

public class Usuario_Celular {
	private String celular;
	private Long usuario_Id;
	
	@Override
	public String toString() {
		return "Usuario_Celular [celular=" + celular + ", usuario_Id=" + usuario_Id + "]";
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public Long getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Long usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	

}
