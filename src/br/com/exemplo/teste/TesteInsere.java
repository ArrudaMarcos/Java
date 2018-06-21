package br.com.exemplo.teste;

import java.text.DecimalFormat;

import br.com.exemplo.DAO.InformacaoSistemaDAO;
import br.com.exemplo.modelo.InformacaoSistema;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

public class TesteInsere {

	public static void main(String[] args) {
		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		
		String md = FormatUtil.formatBytes(hal.getMemory().getAvailable());
		String mt = FormatUtil.formatBytes(hal.getMemory().getTotal());
		DecimalFormat df = new DecimalFormat("0.##");
		String uc = (df.format(hal.getProcessor().getSystemCpuLoadBetweenTicks()*100) + "%");
		
		InformacaoSistema informacaoSistema = new InformacaoSistema(md, mt, uc);
		
		InformacaoSistemaDAO dao = new InformacaoSistemaDAO();
		dao.adiciona(informacaoSistema);
		
		System.out.println("gravado");
	}

}
