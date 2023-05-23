package org.generation;

import java.util.Scanner;

public class Vista {
	private Controlador controlador;
	
	public Vista(Controlador controlador) {
        this.controlador = controlador;
    }
	
	
	public void imprimirMenu() {
		System.out.println("1. Retirar dinero");
		System.out.println("2. Hacer depositos");
		System.out.println("3. Consultar saldo");
		System.out.println("4. Quejas");
		System.out.println("5. Ultimo movimiento");
		System.out.println("9. Salir");
		System.out.println(" --- Elije una opcion --- ");
	}
	
	public void imprimirMenuDeposito() {
		System.out.println("1. Cuenta de cheques");
		System.out.println("2. Deposito a tarjeta de credito");
		System.out.println(" ---- Elije una opcion ---- ");
	}
	
	public void validacionMenuPrincipal(Bandera bandera) {
		Scanner myScan = new Scanner(System.in);
		
		System.out.println("¿Quieres regresar al menu? s/n");
		char respuesta = myScan.nextLine().toLowerCase().charAt(0);
		
		if (respuesta == 's') {
			bandera.setBanderaDeSalida(false); 
			imprimirMenu();
		}else {
			menu(bandera, 9);
		}	
	}
	
	public void validacionDepositos() {
		imprimirMenuDeposito();
		boolean banderaTemporal2 = true;
		Scanner myScan = new Scanner(System.in);
		do {
			int opcDeposito = myScan.nextInt();
			if (opcDeposito == 1 ) {
				System.out.println("------- 1. Cuenta de cheques -------");
				controlador.depositaSaldoOpcionUno();
				banderaTemporal2 = false;
			}else if (opcDeposito == 2) {
				System.out.println("------- 2. Deposito a tarjeta de credito -------");
				controlador.depositaSaldoOpcionDos();
				banderaTemporal2 = false;
			}else {
				System.out.println(" .... Opcion invalida, intentalo de nuevo ....");
				imprimirMenuDeposito();
				banderaTemporal2 = true;
			}
		}while(banderaTemporal2 == true);
	}

	public  void menu(Bandera bandera, int opc) {
		
		switch (opc) {
		case 1: 
			System.out.println(" ------- 1. Retirar dinero ------- ");
			controlador.retiraSaldo();
			validacionMenuPrincipal(bandera);
			break;
		
		case 2: 
			System.out.println(" ------- 2. Hacer depositos ------- ");
			validacionDepositos();
			validacionMenuPrincipal(bandera);
			break;
		
		case 3: 
			System.out.println(" ------- 3. Consultar saldo ------- ");
			controlador.consultaSaldo();
			validacionMenuPrincipal(bandera);
			break;
		
		case 4: 
			System.out.println(" --------- 4. Quejas --------- ");
			System.out.println(" No disponible por el momento ");
			validacionMenuPrincipal(bandera);
			break;
		
		case 5: 
			System.out.println(" ------- 5. Ultimo movimiento ------- ");
			controlador.ultimoMovimiento();
			validacionMenuPrincipal(bandera);
			break;
		
		case 9: 
			bandera.setBanderaDeSalida(true);
			System.out.println(" Hasta la proxima ");
			
			break;
		
		default:
			System.out.println(" Opcion invalida, intentalo de nuevo ");
			bandera.setBanderaDeSalida(false); 
		}	

	}
}
