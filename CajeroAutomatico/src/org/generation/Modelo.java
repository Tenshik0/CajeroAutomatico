package org.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Modelo {

	double saldo;
	private List<String> movimientos;
	private List<Date> fechasMovimientos;
	
	public Modelo(double saldo) {
        this.saldo = saldo;
        this.movimientos = new ArrayList<>();
        this.fechasMovimientos = new ArrayList<>();
    }
	
	 public void setSaldo(double saldo) {
	        this.saldo = saldo;
	 }

	 public double getSaldo() {
	        return saldo;
	 }
	 
	 public void agregarMovimiento(String movimiento) {
		 movimientos.add(movimiento);
	     fechasMovimientos.add(new Date());
	 }
	 
	public String getUltimoMovimiento() {
		if (movimientos.isEmpty()) {
			return "No se han realizado movimientos";
	    }
	        
	    int ultimoIndice = movimientos.size() - 1;
	    String ultimoMovimiento = movimientos.get(ultimoIndice);
	    Date fechaUltimoMovimiento = fechasMovimientos.get(ultimoIndice);

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    String fechaHoraUltimoMovimiento = dateFormat.format(fechaUltimoMovimiento);

	    return "Último movimiento: " + ultimoMovimiento + " (Fecha y hora: " + fechaHoraUltimoMovimiento + ")";
	}

}
