<%@page import="br.com.exemplo.DAO.*"%>
<%@page import="br.com.exemplo.modelo.*"%>
<%@page import="oshi.SystemInfo"%>
<%@page import="oshi.hardware.HardwareAbstractionLayer"%>
<%@page import="oshi.util.FormatUtil"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto Monitor</title>
</head>
<body>
<%-- comentário em JSP aqui: nossa primeira página JSP --%>

	<%
	    String mensagem = "Bem vindo ao sistema de Monitoramento de Hardware";
	%>
	<% out.println(mensagem); %>
	
	<br />
	<br />
	<%
	InformacaoSistemaDAO dao = new InformacaoSistemaDAO();
	
	InformacaoSistema info = dao.getInfoSistema();
			
		%>
	<table>
	    <tr>
	        <th>Memoria Disponivel<th>
	       	<td><%=info.getMemoriaDisponivel()%></td>
	    </tr> 
	    <tr>  
	      	<th>Memoria Total<th>
	        <td><%=info.getMemorialTotal()%></td>
	    </tr>
	    <tr>
	        <th>Uso CPU<th>
	        <td><%=info.getUsoCPU()%></td>
	    </tr>
	</table>
	<%
		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		
		String md = FormatUtil.formatBytes(hal.getMemory().getAvailable());
		String mt = FormatUtil.formatBytes(hal.getMemory().getTotal());
		DecimalFormat df = new DecimalFormat("0.##");
		String uc = (df.format(hal.getProcessor().getSystemCpuLoadBetweenTicks()*100) + "%");
		
		info.setMemoriaDisponivel(md);
		info.setMemorialTotal(mt);
		info.setUsoCPU(uc);
		
		dao.atualiza(info);
	%>
	
</body>
</html>