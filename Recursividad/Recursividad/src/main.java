

public class main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


         // Crear un arreglo de enteros ordenados
         int[] numerosOrdenados = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20,
            22, 24, 26, 28, 30, 32, 34, 36, 38, 40};

        Busquedabinaria asd = new Busquedabinaria();

        System.out.println(asd.BinariaRecursividad(numerosOrdenados, 0, 19, 8));

    }
}
