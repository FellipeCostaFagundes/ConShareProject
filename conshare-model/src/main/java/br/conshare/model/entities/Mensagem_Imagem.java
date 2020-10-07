package br.conshare.model.entities;

public class Mensagem_Imagem {
	private String imagem;
	private Long mensagem_Id;
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Long getMensagem_Id() {
		return mensagem_Id;
	}
	public void setMensagem_Id(Long mensagem_Id) {
		this.mensagem_Id = mensagem_Id;
	}
	@Override
	public String toString() {
		return "Mensagem_Imagem [imagem=" + imagem + ", mensagem_Id=" + mensagem_Id + "]";
	}

}
