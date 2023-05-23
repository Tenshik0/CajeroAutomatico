package org.generation;

import java.util.Iterator;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Controlador {

	double saldo = 10000.00;
    private Modelo modelo;

    public Controlador(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void retirandoSaldo(double retiro, boolean donacion) {
    	double saldoActual = modelo.getSaldo();
    	if(donacion == true) {
    		retiro = retiro + 200;
    		saldoActual = saldoActual - retiro;
    		modelo.setSaldo(saldoActual);
    		System.out.println("Retiro realizado con exito");
    	}else {
    		saldoActual = saldoActual - retiro;
    		modelo.setSaldo(saldoActual);
    		System.out.println("Retiro realizado con exito");
    	}
    	
    	modelo.agregarMovimiento("Retiro: " + retiro);
		System.out.println("Saldo actual: " + saldoActual);
    }
	
	public void consultaSaldo() {
		//modelo = new Modelo(saldo);
		double saldoActual = modelo.getSaldo();
		System.out.println("La cantidad disponible en la tarjeta es: " + saldoActual);
	}
	
	public void retiraSaldo() {
		Scanner myScan = new Scanner(System.in);
		double saldoActual = modelo.getSaldo();
		double limite = 6000.00;
		boolean retirando = true;

		System.out.println("La cantidad disponible que tienes a retirar es de: " + saldoActual);
		
		//System.out.println("tas tratanding de retiranding " + retiro);
		
		
		do {
			System.out.println("Ingresa la cantidad a retirar");
			double retiro = myScan.nextDouble();
			myScan.nextLine();
			
			if(retiro > saldoActual) {
				System.out.println("No tienes esa cantidad para retirar");
				System.out.println("Intentalo de nuevo");
				retirando = true;
			}else {
				if(retiro <= limite) {
					if(retiro % 50 == 0) {
						double retiroDonacion = retiro + 200;
						if(retiroDonacion > saldoActual ) {
							System.out.println("Nos gustaria que donarará a los gatetes");
							System.out.println("¿Desea donarle $200 de su retiro a los gatetes? s/n");
							double total = retiro - 200;
							System.out.println("Si acepta, retiraria un total de: " + total);
							char respuestaDonacion = myScan.nextLine().toLowerCase().charAt(0);
							
							if (respuestaDonacion == 's') {
								retirandoSaldo(retiro, false);
								retirando = false;
							}else {
								retirandoSaldo(retiro, false);
								retirando = false;
							}	
							
						}else {
							System.out.println("¿Desea donarle $200 aparte a los gatetes? s/n");
							char respuestaDonacion = myScan.nextLine().toLowerCase().charAt(0);
							
							if (respuestaDonacion == 's') {
								retirandoSaldo(retiro, true);
								retirando = false;
							}else {
								retirandoSaldo(retiro, false);
								retirando = false;
							}	
						}

					}else {
						System.out.println("No se puede retirar, su retiro debe ser multiplo de $50");
						System.out.println("Intentalo de nuevo");
						retirando = true;
					}
						
				}else {
					System.out.println("No se puede retirar mas de $6000.00");
					System.out.println("Intentalo de nuevo");
					retirando = true;
				}
			}
		}while(retirando == true);
	}
	
	public void depositaSaldoOpcionUno() {
		Scanner myScan = new Scanner(System.in);
		double saldoActual = modelo.getSaldo();
		boolean depositandoCheque = true;
		
		do {
			System.out.println("Ingresa la cantidad a depositar de cuenta cheque");
			double depositoCheque = myScan.nextDouble();
			
			if( depositoCheque % 50 == 0) {
				saldoActual = saldoActual + depositoCheque;
				modelo.setSaldo(saldoActual);
				depositandoCheque = false;
				System.out.println("Deposito realizado con exito");
				modelo.agregarMovimiento("Depósito de cheque: " + depositoCheque);
			}else {
				System.out.println("No se puede retirar, su retiro debe ser multiplo de $50");
				System.out.println("Intentalo de nuevo");
				depositandoCheque = true;
			}
		}while(depositandoCheque == true);
		
	}
	
	public void depositaSaldoOpcionDos() {
		Scanner myScan = new Scanner(System.in);
		double saldoActual = modelo.getSaldo();
		boolean depositandoAOtraTarjeta = true;
		
		do {
			System.out.println("Ingresa la cantidad a depositar a tarjeta de credito");
			double depositoATarjeta = myScan.nextDouble();
			depositoATarjeta = Math.round(depositoATarjeta * 100.0) / 100.0;
			
			if( saldoActual < depositoATarjeta) {
				System.out.println("No se puede realizar deposito, su saldo actual es insuficiente ");
				System.out.println("Intentalo de nuevo");
			}else {
				saldoActual = saldoActual - depositoATarjeta;
				modelo.setSaldo(saldoActual);
				depositandoAOtraTarjeta = false;
				System.out.println("Deposito realizado con exito");
				modelo.agregarMovimiento("Depósito a tarjeta: " + depositoATarjeta);
			}
			
		}while(depositandoAOtraTarjeta == true);
		
		
	}
	
	public void ultimoMovimiento() {
	    String ultimoMovimiento = modelo.getUltimoMovimiento();
	    System.out.println("Último movimiento: " + ultimoMovimiento);
	}

}
