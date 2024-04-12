import java.lang.reflect.Array;

public class Busquedabinaria {
    

    public int BinariaRecursividad(int[] array, int start, int end, int x){

        int mid;
        if (start > end) {
            return -1;
        } else {
            med = start + end/ 2;
            if (x > array[mid]) {
                return BinariaRecursividad(array,mid + 1, end, x);
            } else if (x < array[mid]) {
                return BinariaRecursividad(array,start, mid - 1, x);  
            } else{
                return med;
            }
        }
    }
}
