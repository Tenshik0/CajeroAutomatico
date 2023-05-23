package org.generation;
import java.util.Scanner;

public class CajeroAutomatico {
	public static void main(String[] args) {
	    boolean banderaTemporal = false;
	    int opc;
	    int contador = 1;

	    Bandera bandera = new Bandera(banderaTemporal);
	    Modelo modelo = new Modelo(10000.0);
        Controlador controlador = new Controlador(modelo);
        Vista vista = new Vista(controlador);

	    Scanner myScan = new Scanner(System.in);

	    System.out.println("------ Bienvenido al cajero automatico ------");
	    vista.imprimirMenu();

	    do {
	    	if (contador > 3 ) {
				System.out.println("... Demasiados intentos ...");
				bandera.setBanderaDeSalida(true);
				banderaTemporal = bandera.getBanderaDeSalida();
				
			}else {
				opc = myScan.nextInt();
				if(opc != 1 && opc != 2 && opc != 3  && opc != 4 && opc != 5) {
					contador ++;
				}else {
					contador = 1;
				}
		        
		        vista.menu(bandera, opc);
		        banderaTemporal = bandera.getBanderaDeSalida();
		        //System.out.println("actual: " + banderaTemporal);
			}
	    } while (banderaTemporal == false);

	    myScan.close();
	    
	    System.out.println("Fin del programa");
	}

}
