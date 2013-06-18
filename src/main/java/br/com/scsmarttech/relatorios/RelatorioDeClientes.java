package br.com.scsmarttech.relatorios;

import java.sql.SQLException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.scsmarttech.bean.Cliente;
import br.com.scsmarttech.dao.ClienteDAO;

public class RelatorioDeClientes {
	public static void main(String[] args) throws JRException, SQLException {

		System.out.println("Gerando relat�rio...");
		// lista com os nossos clientes
		ClienteDAO listaCliente = new ClienteDAO();
		
		List<Cliente> lista = listaCliente.getLista();
			
		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("WebContent/Relatorios/Clientes_Cmnet.jrxml");

		// preenchimento do relatorio, note que o metodo recebe 3 parametros:
		// 1 - o relatorio
		//
		// 2 - um Map, com parametros que sao passados ao relatorio
		// no momento do preenchimento. No nosso caso eh null, pois nao
		// estamos usando nenhum parametro
		//
		// 3 - o data source. Note que nao devemos passar a lista diretamente,
		// e sim "transformar" em um data source utilizando a classe
		// JRBeanCollectionDataSource
		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(lista));

		// exportacao do relatorio para outro formato, no caso PDF
		JasperExportManager.exportReportToPdfFile(print,
				"WebContent/Clientes_Cmnet.pdf");
		JasperExportManager.exportReportToHtmlFile(print,
				"WebContent/Clientes_Cmnet.html");
		System.out.println("Relat�rio gerado.");
	}
}
