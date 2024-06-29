import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase para leer datos de archivos CSV y cargarlos en estructuras de datos.
 */
public class CSVReader {

	public CSVReader() {
	}
	/**
     * Lee tareas desde un archivo CSV y las carga en un árbol y un HashMap.
     * @param taskPath Ruta del archivo CSV de tareas.
     * @param tareas Árbol donde se almacenarán las tareas.
     * @param tareaMap HashMap donde se almacenarán las tareas.
     */
	public void readTasks(String taskPath, Tree<Tarea> tareas, HashMap<String, Tarea> tareaMap) {
		
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent(taskPath);
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			String id = line[0].trim();
			String nombre = line[1].trim();
			Integer tiempo = Integer.parseInt(line[2].trim());
			Boolean critica = Boolean.parseBoolean(line[3].trim());
			Integer prioridad = Integer.parseInt(line[4].trim());
			// Aca instanciar lo que necesiten en base a los datos leidos
			Tarea tarea = new Tarea(id, nombre, tiempo, critica, prioridad);
			tareas.add(id,tarea);
			tareaMap.put(id, tarea);
		}
		
	}
	/**
     * Lee procesadores desde un archivo CSV y los carga en un árbol y un HashMap.
     * @param processorPath Ruta del archivo CSV de procesadores.
     * @param procesadores Árbol donde se almacenarán los procesadores.
     * @param procesadorMap HashMap donde se almacenarán los procesadores.
     */
	public void readProcessors(String processorPath, Tree<Procesador> procesadores, HashMap<String, Procesador> procesadorMap) {
		
		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent(processorPath);
		
		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			String id = line[0].trim();
			String codigo = line[1].trim();
			Boolean refrigerado = Boolean.parseBoolean(line[2].trim());
			Integer anio = Integer.parseInt(line[3].trim());
			// Aca instanciar lo que necesiten en base a los datos leidos
			Procesador procesador = new Procesador(id, codigo, refrigerado, anio);
			procesadores.add(id, procesador);
			procesadorMap.put(id, procesador);
		}
		
	}

	private ArrayList<String[]> readContent(String path) {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		return lines;
	}
	
}
