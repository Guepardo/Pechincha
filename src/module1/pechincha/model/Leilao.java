package module1.pechincha.model;

import java.util.ArrayList;

import module1.pechincha.util.ReflectiveModel;

public class Leilao extends ReflectiveModel {
	private int idLeilao;
	private String etiqueta;
	private String descricao;
	private int comprador;
	private boolean ativo;
	private int idLeiloeiro;
	private float lanceInicial;
	private int tempoLimite;
	private String nickname;
	private float precolote;
	private String termino;
	private String compras;

	
	public Leilao(int idLeilao, String etiqueta, int tempoLimite, int idLeiloeiro, float lanceInicial,String descricao,int comprador, ArrayList<LoteProduto> produto,String nickname,boolean ativo,int precolote){
		this.idLeilao = idLeilao; 
		this.etiqueta = etiqueta;
		this.tempoLimite = tempoLimite; 
		this.setLanceInicial(lanceInicial);
		this.idLeiloeiro = idLeiloeiro;
		this.descricao=descricao;
		this.nickname=nickname;
		this.ativo=ativo;
		this.precolote=precolote;
	};
	
	public Leilao(int idLeilao, String etiqueta, int tempoLimite, int idLeiloeiro, float lanceInicial){
		this.idLeilao = idLeilao; 
		this.etiqueta = etiqueta;
		this.tempoLimite = tempoLimite; 
		this.setLanceInicial(lanceInicial);
		this.idLeiloeiro = idLeiloeiro;
	};	
	
	public Leilao(int idLeilao){
		this.idLeilao = idLeilao;
	}
	
	public Leilao(){}
	
	public String getCompras() {
		return compras;
	}

	public void setCompras(String compras) {
		this.compras = compras;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public float getPrecolote() {
		return precolote;
	}

	public void setPrecolote(float precolote) {
		this.precolote = precolote;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public int getIdLeilao() {
		return idLeilao;
	}
	
	public void setIdLeilao(int idLeilao) {
		this.idLeilao = idLeilao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getComprador() {
		return comprador;
	}

	public void setComprador(int comprador) {
		this.comprador = comprador;
	}
	
	public int getIdLeiloeiro() {
		return idLeiloeiro;
	}
	public void setIdLeiloeiro(int idLeiloeiro) {
		this.idLeiloeiro = idLeiloeiro;
	}
	public int getTempoLimite() {
		return tempoLimite;
	}
	public void setTempoLimite(int tempoLimite) {
		this.tempoLimite = tempoLimite;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public float getLanceInicial() {
		return lanceInicial;
	}

	public void setLanceInicial(float lanceInicial) {
		this.lanceInicial = lanceInicial;
	} 
}
