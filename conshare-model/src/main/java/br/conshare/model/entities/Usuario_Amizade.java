package br.conshare.model.entities;

public class Usuario_Amizade {
	private Long usuario_Id;
	private Long usuario_amizade_id;
	
	@Override
	public String toString() {
		return "Usuario_Amizade [usuario_Id=" + usuario_Id + ", usuario_amizade_id=" + usuario_amizade_id + "]";
	}
	public Long getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Long usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	public Long getUsuario_amizade_id() {
		return usuario_amizade_id;
	}
	public void setUsuario_amizade_id(Long usuario_amizade_id) {
		this.usuario_amizade_id = usuario_amizade_id;
	}
	
	

}
