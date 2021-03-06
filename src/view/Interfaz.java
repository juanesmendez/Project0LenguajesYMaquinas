package view;

import java.io.IOException;
import java.util.Scanner;

import model.logic.LectorArchivo;
import Controller.Controller;


public class Interfaz {


	public static void main (String[] args) {

		

		Scanner sc = new Scanner(System.in);
		boolean fin=false;

		while(!fin) {
			printMenu();

			int option = sc.nextInt();
			switch(option)
			{

			case 1:
				try {
					Controller.leerArchivo("././test.bib");
					boolean segundoFin = false;
					while(!segundoFin) {
						printSubMenu();

						int secondOption = sc.nextInt();

						switch (secondOption) {
						case 1:
							Controller.mostrarConteoBibliografias();
							//Controller.mostrarTiposBibliografiasValidas();
							break;
						case 2:
							Controller.mostrarConteoBibliografiasValidas();
							break;
						case 3:
							Controller.mostrarErrores();
							break;
						case 4:
							Controller.mostrarErroresPorEntrada();
							break;
						case 5:
							Controller.mostrarAnalisisCamposReqYOpc();
							break;
						case 6:
							segundoFin= true;
							//sc.close();
							break;
						}
					}
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 2: //salir
				fin=true;
				sc.close();
				break;

			}
		}

	}



	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("---------------LENGUAJES Y MAQUINAS-----------------");
		System.out.println("----------------Lector Archivos Bib-----------------");
		System.out.println("---------------------Project 1----------------------");
		System.out.println();
		System.out.println("1. Leer archivo. (Muestra errores detectados por JavaCC)");
		System.out.println("2. Salir.");

	}

	private static void printSubMenu() {
		System.out.println("1. Mostrar conteo de entradas bibliografias en el archivo.");
		System.out.println("2. Mostrar conteo de bibliografias válidas en el archivo.");
		System.out.println("3. Mostrar datos generales de errores identificados en el archivo.");
		System.out.println("4. Mostrar datos del tipo de error (si aplica) identificado en cada entrada bibliográfica en el archivo.");
		System.out.println("5. Análisis de campos requeridos y campos opcionales.");
		System.out.println("6. Volver.");
	}
	
	
}
