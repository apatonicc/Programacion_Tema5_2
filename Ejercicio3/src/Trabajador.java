/*
 * Cada trabajador tiene un numero identificativo que va de 1 a 100, adem�s se
controla su nombre, estado civil (S/C), turno (D/N), titulaci�n (0 a 4) y a�os en la
empresa.
Escribir el c�digo para definir la clase Trabajador y desarrollar los m�todos para:
Constructor con par�metros fijos para un trabajador nuevo
Modificar cualquier dato menos el identificador
Visualizar los datos de un trabajador dado
Calcular la n�mina de un trabajador teniendo en cuenta que:
El salario base es de 425 euros para todos
Se paga 100 euros extra en turno N
Se paga 75 euros por a�o de antig�edad
La titulaci�n se paga 250,500,1000,1250,1500 seg�n sea de 0 a 4
Se efect�a una retenci�n de impuestos de la n�mina del 12% a todos salvo a
los casados que se les retiene el 10%
Declarar los atributos y m�todos correspondientes, desarrollarlos y probarlos en un
programa
 */
import java.util.Scanner;
public class Trabajador {
static private int actual = 0; 
private int id;
private String nombre;
private char estadoCivil;
private char turno;
private int titulacion;
private int anosEmpresa;
private int nominaBase = 425;
private double totalPago = 0;
Scanner teclado = new Scanner(System.in);

public Trabajador () {
int numero = ++actual;
if (actual <= 100) {
	id = actual;
}else {
	System.out.println("No bueno");
}
}

public Trabajador (String nombre, char estadoCivil, char turno, int titulacion,
int anosEmpresa) {
	this();
	this.nombre=nombre;
	this.estadoCivil = estadoCivil;
	this.turno = turno;
	this.titulacion = titulacion;
	this.anosEmpresa=anosEmpresa;
}


//Metodos

	//Ver datos

void verDatos() {
	System.out.println("ID: " + id);
	System.out.println("Nombre: " + nombre);
	System.out.println("Estado Civil: " + estadoCivil);
	System.out.println("Turno: "+turno);
	System.out.println("Titulaci�n: " + titulacion);
	System.out.println("A�os en la empresa: " + anosEmpresa);
}

void introducirDatos() {
	System.out.println("Introduce el nombre: ");
	nombre = teclado.nextLine();
	System.out.println("Introduce el estado civil: ");
	estadoCivil = teclado.next().charAt(0);
	System.out.println("Introduce el turno: ");
	turno = teclado.next().charAt(0);
	System.out.println("Introduce la titulacion: ");
	titulacion = teclado.nextInt();
	System.out.println("Introduce los a�os en la empresa: ");
	anosEmpresa = teclado.nextInt();
}

	//Calcular Nomina
//El salario base es de 425 euros para todos
//Se paga 100 euros extra en turno N
//Se paga 75 euros por a�o de antig�edad
//La titulaci�n se paga 250,500,1000,1250,1500 seg�n sea de 0 a 4
//Se efect�a una retenci�n de impuestos de la n�mina del 12% a todos salvo a
//los casados que se les retiene el 10%

	void calcularNomina() {
		totalPago += nominaBase;
		if (anosEmpresa > 0) {
			totalPago += anosEmpresa*75;
		}
		if (turno == 'N') {
			totalPago += 100;
		}else if (turno == 'D'){
			totalPago += 0;
		}
		if (titulacion == 0) {
			totalPago += 250;
		}else if (titulacion == 1) {
			totalPago += 500;
		}else if (titulacion == 2) {
			totalPago += 1000;
		}else if (titulacion == 3) {
			totalPago += 1250;
		}else if (titulacion == 4) {
			totalPago += 1500;
		}
		if (estadoCivil == 'S') {
			totalPago *= 0.88;
		}else if (estadoCivil == 'C'){
			totalPago *= 0.90;
		}
		System.out.println("El trabajador con ID " + id + " cobra " + totalPago + " euros,");
	}

//Getters y Setters

public int getId() {
	return id;
}
public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public char getEstadoCivil() {
	return estadoCivil;
}

public void setEstadoCivil(char estadoCivil) {
	this.estadoCivil = estadoCivil;
}

public char getTurno() {
	return turno;
}

public void setTurno(char turno) {
	this.turno = turno;
}

public int getTitulacion() {
	return titulacion;
}

public void setTitulacion(int titulacion) {
	this.titulacion = titulacion;
}

public int getAnosEmpresa() {
	return anosEmpresa;
}

public void setAnosEmpresa(int anosEmpresa) {
	this.anosEmpresa = anosEmpresa;
}

}
