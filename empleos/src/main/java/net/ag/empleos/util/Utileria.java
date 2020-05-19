package net.ag.empleos.util;
import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {

	public static String guardarArchivo(MultipartFile mulPart, String ruta){
		//Obtener nombre Originar de Archivo
		String nombreOriginal = mulPart.getOriginalFilename();
		//Guardar imagenes con simbolo(-) en vez de espacios
		nombreOriginal=nombreOriginal.replace(" ", "-");
		//Se genera nombre aleatorio
		String nombreFinal = ramdomAlphaNumeric(8)+nombreOriginal;
		try
		{
			//Se forma nombre de archivo para salvar en disco duro
			File imageFile = new File(ruta + nombreFinal);
			//Guardar imagen fisicamente en disco, bloque que valida el IOException
			mulPart.transferTo(imageFile);
			return nombreFinal;	
		}catch (IOException e) {
			System.out.println("Error" +e.getMessage());
			return null;
		}
	
		
		
	}
	
	//Metodo Genera cadena aleatoria de longitud N, se usa para generar nombres no repetidos en las imagenes
	
	public static String ramdomAlphaNumeric(int count) {
		String CARACTERES ="ABCDEFGHIJKLMNOPQRSTVWXYZabcdefghijklmnopqrstvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- !=0) {
			int character =(int) (Math.random()*CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
			
		}
		return builder.toString();
		
	}
	
	
	
	
	
}
