package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import collections.Grafo;

/**
 * Ejercicio 1. Se tiene un conjunto de salas comunicadas entre sí a través de
 * puertas que se abren solamente en un sentido. Una de las salas se denomina
 * entrada y la otra salida. Construir un algoritmo que permita ir desde la
 * entrada a la salida atravesando la máxima cantidad de salas. Idea: podría
 * representar el problema mediante un grafo dirigido, donde cada nodo es una
 * habitación, y cada puerta es un arco dirigido hacia otra habitación.
 * 
 * @autor Gentil Ricardo
 */
public class Backtracking {

    // Mapa para llevar un registro de las salas recorridas
    private HashMap<Integer, Boolean> recorrida;

    // Grafo que representa las salas y las conexiones entre ellas
    private Grafo<Integer> salas;

    // Constructor que inicializa el grafo y el mapa de salas recorridas
    public Backtracking(Grafo<Integer> g) {
        this.salas = g;
        recorrida = new HashMap<Integer, Boolean>();
    }

    // Inicializa el mapa de salas recorridas a falso para cada sala
    private void inicializarSalas() {
        for (Iterator<Integer> it = salas.obtenerVertices(); it.hasNext();) {
            Integer sala = it.next();
            recorrida.put(sala, false);
        }
    }

    /**
     * Método público que encuentra el camino desde la entrada hasta la salida
     * que pasa por la máxima cantidad de salas.
     * 
     * @param entrada El nodo de entrada.
     * @param salida El nodo de salida.
     * @return Una lista con el camino que pasa por la máxima cantidad de salas.
     */
    public List<Integer> getSalida(int entrada, int salida) {
        this.inicializarSalas();
        List<Integer> resultado = new ArrayList<Integer>();
        List<Integer> parcial = new ArrayList<Integer>();
        _getSalida(entrada, salida, parcial, resultado);
        return resultado;
    }

    /**
     * Método recursivo privado que realiza el backtracking para encontrar el
     * camino desde la sala actual hasta la sala de salida.
     * 
     * @param salaActual La sala actual en la que se encuentra.
     * @param salida La sala de salida.
     * @param parcial Lista que contiene el camino parcial actual.
     * @param resultado Lista que contiene el mejor camino encontrado hasta el momento.
     */
    private void _getSalida(int salaActual, int salida, List<Integer> parcial, List<Integer> resultado) {
        parcial.add(salaActual); // Agrega la sala actual al camino parcial
        recorrida.put(salaActual, true); // Marca la sala actual como recorrida
        if (salaActual == salida) { // Si se ha llegado a la salida
            if (parcial.size() > resultado.size()) { // Si el camino actual es mejor que el resultado
                resultado.clear(); // Limpia el resultado anterior
                resultado.addAll(parcial); // Guarda el nuevo mejor camino
            }
        } else {
            for (Iterator<Integer> it = salas.obtenerAdyacentes(salaActual); it.hasNext();) { // Itera sobre los adyacentes
                Integer ady = it.next();
                if (!recorrida.get(ady)) { // Si el adyacente no ha sido recorrido
                    _getSalida(ady, salida, parcial, resultado); // Llama recursivamente al método con el adyacente
                }
            }
        }
        recorrida.put(salaActual, false); // Desmarca la sala actual (backtrack)
        parcial.remove(parcial.size() - 1); // Remueve la sala actual del camino parcial (backtrack)
    }
}

	/*
	 * BACK (estado e, solucionActual *sol){
	 * \\ e: nodo del árbol de soluciones
	 * \\sol: solución actúa, que se va construyendo. También puede llevarse la
	 * mejor
	 * encontrada hasta el momento en otro parámetro.
	 * 
	 * 	if ( SOLUCION (e))
	 * 		OperarSobreSolución (e, sol);
	 * 	else {
	 * 		int nrohijo = 1;
	 * 		estado siguiente;
	 * 		while ( HIJOS (nrohijo, e, siguiente ) ){
	 * 			if ( !PODA ( siguiente, sol) ){
	 *  			AgregarASolucionActual(siguiente, sol);
	 * 				BACK ( siguiente, sol);
	 * 				QuitarDeSolucionActual(siguiente, sol);
	 * 			}
	 * 			nrohijo++;
	 * 		}
	 * 	}
	 * }
	 */


