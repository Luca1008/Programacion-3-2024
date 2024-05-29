import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree() {
        this.root = null;
    }

    public void add(String key, T value) {
        if (this.root == null) {
            this.root = new TreeNode<T>(key, value);
        } else {
            this.add(this.root, key, value);
        }
    }

    private void add(TreeNode<T> actual, String key, T value) {
        int cmp = actual.getKey().compareTo(key);
        if (cmp > 0) {
            if (actual.getLeft() == null) {
                TreeNode<T> temp = new TreeNode<>(key, value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), key, value);
            }
        } else if (cmp < 0) {
            if (actual.getRight() == null) {
                TreeNode<T> temp = new TreeNode<>(key, value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), key, value);
            }
        }
    }

/////////////////////////////////////////////////////////////////
    // Primer Servicio
    /**
     * Obtiene una tarea por su identificador.
     *
     * @param key El identificador de la tarea.
     * @return La tarea correspondiente al identificador, o null si no se encuentra.
     * @throws IllegalArgumentException si el identificador es null.
     */
    public T get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("El identificador no puede ser null");
        }
        return get(this.root, key);
    }
    
    private T get(TreeNode<T> actual, String key) {
        if (actual == null) {
            return null;  // Si el nodo actual es null, significa que la tarea no existe
        }
        int t = actual.getKey().compareTo(key);  // Compara la clave del nodo actual con la clave buscada
        if (t == 0) {
            return actual.getValue();  // Si son iguales, se encontró la tarea
        } else if (t > 0) {
            return get(actual.getLeft(), key);  // Si la clave del nodo actual es mayor, buscar en el subárbol izquierdo
        } else {
            return get(actual.getRight(), key);  // Si la clave del nodo actual es menor, buscar en el subárbol derecho
        }
    }
/////////////////////////////////////////////////////////////////
    
//////////////////////////////////////////////////////////////
    //segundo servicio
    /**
     * Lista las tareas críticas o no críticas.
     *
     * @param esCritica Indica si se desean listar las tareas críticas (true) o no críticas (false).
     * @return Una lista de tareas críticas o no críticas.
     */
    public List<T> getCriticas(boolean esCritica) {
        List<T> t = new ArrayList<>();
        getCriticas(this.root, esCritica, t);
        return t;
    }
    
    private void getCriticas(TreeNode<T> t, boolean esCritica, List<T> result) {
        if (t != null) {
            T tarea = t.getValue();
            if (((Tarea) tarea).isEsCritica() == esCritica) {  // Compara si la tarea es crítica o no crítica
                result.add(tarea);  // Si coincide, se añade a la lista de resultados
            }
            getCriticas(t.getLeft(), esCritica, result);  // Busca en el subárbol izquierdo
            getCriticas(t.getRight(), esCritica, result);  // Busca en el subárbol derecho
        }
    }
    
/////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////
    //Tercer servicio
     /**
     * Obtiene las tareas con un nivel de prioridad entre los valores indicados.
     *
     * @param prioridadInferior El valor inferior del rango de prioridad.
     * @param prioridadSuperior El valor superior del rango de prioridad.
     * @return Una lista de tareas cuyo nivel de prioridad esté dentro del rango especificado.
     */
    public List<T> getTareasEntrePrioridades(int prioridadInferior, int prioridadSuperior) {
        if (prioridadInferior > prioridadSuperior) {
            throw new IllegalArgumentException("La prioridad inferior no puede ser mayor que la superior");
        }

        List<T> t = new ArrayList<>();
        getTareasEntrePrioridades(root, prioridadInferior, prioridadSuperior, t);
        return t;
    }
    
    private void getTareasEntrePrioridades(TreeNode<T> nodo, int prioridadInferior, int prioridadSuperior, List<T> result) {
        if (nodo != null) {
            T tarea = nodo.getValue();
            int prioridad = ((Tarea) tarea).getNivelPrioridad();
            if (prioridad >= prioridadInferior && prioridad <= prioridadSuperior) {  // Verifica si la prioridad está en el rango
                result.add(tarea);  // Si está en el rango, se añade a la lista de resultados
            }
            getTareasEntrePrioridades(nodo.getLeft(), prioridadInferior, prioridadSuperior, result);  // Busca en el subárbol izquierdo
            getTareasEntrePrioridades(nodo.getRight(), prioridadInferior, prioridadSuperior, result);  // Busca en el subárbol derecho
        }
    }

/////////////////////////////////////////////////////////////////////////////

    public List<T> getAll() {
        List<T> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return values;
    }

    private void inOrderTraversal(TreeNode<T> node, List<T> values) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), values);
            values.add(node.getValue());
            inOrderTraversal(node.getRight(), values);
        }
    }
}
