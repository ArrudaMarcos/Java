package br.com.exemplo.modelo;

public class InformacaoSistema {
	
	private String memoriaDisponivel;
	private String memorialTotal;
	private String usoCPU;
	
	
	public InformacaoSistema(String md, String mt, String uc) {
		this.memoriaDisponivel = md;
		this.memorialTotal = mt;
		this.usoCPU = uc;
	}
	
	public InformacaoSistema() {
		// TODO Auto-generated constructor stub
	}
			
	//Getters e Setters
	public String getMemoriaDisponivel() {
		return memoriaDisponivel;
	}
	public void setMemoriaDisponivel(String memoriaDisponivel) {
		this.memoriaDisponivel = memoriaDisponivel;
	}
	public String getMemorialTotal() {
		return memorialTotal;
	}
	public void setMemorialTotal(String memorialTotal) {
		this.memorialTotal = memorialTotal;
	}
	public String getUsoCPU() {
		return usoCPU;
	}
	public void setUsoCPU(String usoCPU) {
		this.usoCPU = usoCPU;
	}
	
	
}
