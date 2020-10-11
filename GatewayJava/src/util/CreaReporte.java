package util;

import java.util.StringTokenizer;

/**
 * @author F.J. BOGA
 * Crea reporte Estadistico en base a maskReport
 * Parametros: maskRepor con el siguiente Formato
 *             
 */
public class CreaReporte {
	String mask;
	String oksie;
	String tipoMachine;
	String tipoAutomatiz;
	HandleProperties hp;
	public CreaReporte(String maskReport, String enviarSIE, String tipoAutomatizacion) {
		this.mask=maskReport;
		this.oksie=enviarSIE;
		this.tipoAutomatiz=tipoAutomatizacion;
		hp = new HandleProperties();
		if(tipoAutomatizacion == null) {
			if(enviarSIE == null)enviarSIE="True";
			executeReportMask(maskReport,enviarSIE);
		}else {
			executeReportMask(maskReport,enviarSIE);
		}	
	}
	private void executeReportMask(String maskReport, String enviarSIE) {
		String parteFormato=null;
		String parteMascara=null;
		//Asignar Equipement
  		if(mask.contains("TOP"))tipoMachine="TOP";
  		if(mask.contains("CSU"))tipoMachine="VCS";
  		if(mask.contains("ITLS"))tipoMachine="ITLS";
  		if(mask.contains("DISPO"))tipoMachine="DISPO";
  		if(mask.contains("CMT"))tipoMachine="CMT";
  		if(mask.contains("CMI"))tipoMachine="CMI";
  		if(mask.contains("IRV"))tipoMachine="IRV";
  		if(mask.contains("MIS_M"))tipoMachine="MIS_M";
  		if(mask.contains("SIE_C"))tipoMachine="SIE_C";
  		if(mask.contains("ARCHIVE"))tipoMachine="ARCHIVE";
  		//
  		StringTokenizer stSepara2 = new StringTokenizer(maskReport,".");	
  		while(stSepara2.hasMoreTokens()) {
  		  parteMascara = stSepara2.nextToken();
  		  parteFormato = stSepara2.nextToken();
  		} 
  		PreparaFormatIni pfi = new PreparaFormatIni(maskReport);
  		
  		WritePDU wp = new WritePDU(tipoMachine,"myMachines",parteFormato,enviarSIE);
  		 
  		CallerRunSystem crs = new CallerRunSystem();
  		String pathPduFile = hp.leeProperties("pathPduFile");
  		crs.LlamarNotifier(pathPduFile);
	}
}
