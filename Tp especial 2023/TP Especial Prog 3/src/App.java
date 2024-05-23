import java.util.Iterator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        GrafoDirigido<Integer> mapa = new GrafoDirigido<>();

        mapa.agregarVertice(0);
        mapa.agregarVertice(1);
        mapa.agregarVertice(2);
        mapa.agregarVertice(3);
        mapa.agregarVertice(6);
        mapa.agregarVertice(7);
        mapa.agregarVertice(23);
        mapa.agregarVertice(43);
        mapa.agregarVertice(89);
        mapa.agregarVertice(100);


        mapa.agregarArco(0, 100, null);
        mapa.agregarArco(0, 1, null);
        mapa.agregarArco(0, 43, null);
        mapa.agregarArco(1, 2, null);
        mapa.agregarArco(2, 3, null);
        mapa.agregarArco(2, 7, null);
        mapa.agregarArco(2, 6, null);
        mapa.agregarArco(3, 7, null);
        mapa.agregarArco(6, 7, null);
        mapa.agregarArco(7, 23, null);
        mapa.agregarArco(7, 43, null);
        mapa.agregarArco(23, 1, null);
        mapa.agregarArco(23, 2, null);
        mapa.agregarArco(23, 43, null);
        mapa.agregarArco(43, 89, null);
        mapa.agregarArco(43, 23, null);
        mapa.agregarArco(89, 23, null);
        mapa.agregarArco(100, 43, null);

        System.out.println("Grafo original");
        mapa.toString();

        mapa.borrarVertice(100);
        mapa.borrarArco(0, 100);

        System.out.println("\nGrafo con el vertice 100 borrado");
        mapa.toString();

        System.out.println("--------------------------------------------------");

        System.out.println("Vertice que existe");
        System.out.println(mapa.contieneVertice(23) + "\n");
        System.out.println("Vertice que no existe");
        System.out.println(mapa.contieneVertice(67));

        System.out.println("--------------------------------------------------");

        System.out.println("Arco que existe");
        System.out.println(mapa.existeArco(23, 2) + "\n");
        System.out.println("Arco que no existe");
        System.out.println(mapa.existeArco(23, 3));
    
        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de arco\n");
        System.out.println(mapa.obtenerArco(43, 89));

        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de cantidad de vertices \n");
        System.out.println(mapa.cantidadVertices());

        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de lista de vertices \n");
        Iterator<Integer> iter = mapa.obtenerVertices();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        
        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de lista de adyacentes de un vertice (En este caso 23)\n");
        Iterator<Integer> iter2 = mapa.obtenerAdyacentes(23);
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }

        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de lista de arcos\n");
        Iterator<Arco<Integer>> iter3 = mapa.obtenerArcos();
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }

        System.out.println("--------------------------------------------------");

        System.out.println("Obtencion de lista de arcos de un vertice\n");
        Iterator<Arco<Integer>> arcoIterator = mapa.obtenerArcos(23);
        while (arcoIterator.hasNext()) {
            System.out.println(arcoIterator.next());
        }

        System.out.println("--------------------------------------------------");

        System.out.println("Impresion de servicio DFS\n");
        ServicioDFS gDfs = new ServicioDFS(mapa);
        List<Integer> resultado = gDfs.dfsForest();
        System.out.println(resultado.toString());

        System.out.println("--------------------------------------------------");

        System.out.println("Impresion de servicio BFS\n");
        ServicioBFS gBfs = new ServicioBFS(mapa);
        List<Integer> resultados = gBfs.bfsForest();
        System.out.println(resultados.toString());

        System.out.println("--------------------------------------------------");

        ServicioCaminos caminito = new ServicioCaminos(mapa, 0, 43, 5);

        System.out.println("Impresion de caminos\n");
        List<List<Integer>> resultadoCaminos = caminito.caminos();
        for (List<Integer> camino : resultadoCaminos) {
            for (int i = 0; i < camino.size(); i++) {
                System.out.print(camino.get(i));
                if (i < camino.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }

    }
}
