package main;

import tp1.MySimpleLinkedList;

/**
 * @author Gentil Ricardo
 *
 */
public class Main {
	
	/*
	Arreglo
	
	1.- Insertar al principio = O(n) Debido al corrimiento de los valores. O crear un arreglo nuevo si 
		sobrepasa el tamaño declarado.
	2.- Buscar un elemento en una posición = O(1). Se conoce la dirección de memoria
	3.- Determinar la cantidad de elementos = O(1) Se conoce el tamaño
	
	Lista:
	
	1.- Insertar al principio = O(1)
	2.- Buscar un elemento en una posición = O(n)
	3.- Determinar la cantidad de elementos = O(1) Esto si se declara una variable para tener el tamaño actualizado
		caso contrario es O(n) Porque en el peor de los casos se recorre toda la lista.
	*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MySimpleLinkedList<Number> list = new MySimpleLinkedList<Number>();
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		list.insertFront(2);
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		System.out.println("ExtractFront: " + list.extractFront());
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		list.insertFront(5);
		list.insertFront(7);
		list.insertFront(1);
		list.insertFront(3);
		
		System.out.println("Size: " + list.size());
		System.out.println("Is empty: " + list.isEmpty());
		
		int index = 2;
		System.out.println("Value in index " + index + ": " + list.get(index));
		
		System.out.println(list);
	}

}
