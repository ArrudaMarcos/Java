package br.com.exemplo.teste;

import br.com.exemplo.DAO.InformacaoSistemaDAO;
import br.com.exemplo.modelo.InformacaoSistema;

public class TestaInfo {
	
	public static void main(String[] args) {
		InformacaoSistemaDAO dao = new InformacaoSistemaDAO();
		
		InformacaoSistema info = dao.getInfoSistema();
		
		System.out.println(info.getMemoriaDisponivel() + "/" + info.getMemorialTotal() +
				" - " + info.getUsoCPU());
		
	}

}
