package util;

// Import required classes
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

import org.ini4j.*;


public class ManejaInis {
	Wini ini;
	String pathInis ;
	public Wini getIni() {
		return ini;
	}
	public void setIniFile(File FileURI) {
		try {
			
			this.ini = new Wini(FileURI);
			System.out.println("Wini ...  setted");			
		} catch (InvalidFileFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ManejaInis(String resourceIni) {
	//Contructor
		this.pathInis=leeProperty("pathInis");		
		File file = this.obtenerFileIni(resourceIni);
		this.setIniFile(file);
	}
	
	public String leeProperty(String opcion) {
		return "D:\\MIS\\ReportManager\\Data\\";
	}	
	public String getKeySeccion(String Seccion, String Opcion) {
		return ini.get(Seccion, Opcion);
	}
	
	public void putKeySeccion(String Seccion, String Opcion, String value) {
	        try {    
	            ini.put(Seccion,Opcion, value);
				File f =ini.getFile();
				
	            ini.store();
	        // To catch basically any error related to writing to the file
	        // (The system cannot find the file specified)
	        }catch(Exception e){
	            System.err.println("Error put KeySeccion:"+e.getMessage());
	        }
	}    
	public void removeSeccion(String Seccion) {
		try {
			ini.remove(Seccion);

			ini.store();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
    
    public static void main(String[] args){
        try{
       ManejaInis handlerIni = new ManejaInis(args[0]);
       handlerIni.putKeySeccion("TOP", "Subject", "15");

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public File obtenerFileIni(String recursoIni) {
    	//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    	//InputStream streamResource = classLoader.getResourceAsStream("resources/"+recursoIni);
  
    	System.out.println("URL: "+pathInis+recursoIni);
    	File file = new File(pathInis+recursoIni);
    	
    	return file;
    }
}
