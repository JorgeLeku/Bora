package Cositis;

public class Cuenta {
	
	// PROPIEDADES
	private String titular;
	private String numero;
	private double saldo;
	
	// METODOS
	public Cuenta (String titular, String numero, double saldo) {
		this.titular = titular;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Cuenta () {
		titular = "Sin especificar";
		numero = "Sin especificar";
		saldo = 0;
	}
	
	public Cuenta(Cuenta c) {
		this.titular = c.titular;
		this.numero = c.numero;
		this.saldo = c.saldo;
	}
	
	// G & S	
	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// StoS
	public String toString() {
		return "Cuenta [titular=" + titular + ", numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	public boolean numerosRojos() {
		if (this.saldo < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transferir(double dinero, Cuenta destino) {
		if (this.saldo >= dinero) {
			this.saldo = this.saldo - dinero;
			destino.saldo = destino.saldo + dinero;
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		Cuenta c1 = new Cuenta("Jorge Gorda","123444444445", 3.50);
		Cuenta c2 = new Cuenta("Eneko","987654321",10.50);
		
		c1.transferir(3, c2);
		System.out.println(c2);
	}

}
