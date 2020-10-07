package br.conshare.model.entities;

public class Usuario_Denuncia {
	private Long usuario_Id;
	private Long usuario_denuncia_Id;
	public Long getUsuario_Id() {
		return usuario_Id;
	}
	public void setUsuario_Id(Long usuario_Id) {
		this.usuario_Id = usuario_Id;
	}
	public Long getUsuario_denuncia_Id() {
		return usuario_denuncia_Id;
	}
	public void setUsuario_denuncia_Id(Long usuario_denuncia_Id) {
		this.usuario_denuncia_Id = usuario_denuncia_Id;
	}
	@Override
	public String toString() {
		return "Usuario_Denuncia [usuario_Id=" + usuario_Id + ", usuario_denuncia_Id=" + usuario_denuncia_Id + "]";
	}
	
	

}
