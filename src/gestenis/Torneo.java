package gestenis;
import java.io.*;
import java.util.ArrayList;
/**
 * Clase para gestión de torneos de los tenistas
 * @author alumno
 *
 */

public class Torneo  {
	
    private String nombreTorneo;
    private int puntuacion;
    
    Torneo (String nombreTorneo,int puntuacion){
        this.nombreTorneo=nombreTorneo;
        this.puntuacion=puntuacion;
    }

    /**
     * Devuelve el nombre del torneo
     * @return
     */
    public String getnombreTorneo() {
        return nombreTorneo;
    }

    /**
     * Asignamos un nombre de torneo
     * @param nombreTorneo del torneo
     */
    public void setnombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * Devuelve la puntuacionuación asignada al torneo
     * @return
     */
    public int getpuntuacion() {
        return puntuacion;
    }

    /**
     * Introducimos la puntuacionuación asignada para el torneo
     * @param
     */
    public void setpuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    /**
     * Carga los datos del fichero en el ArrayList lista
     * y devuelve la lista de Torneo
     * @param fichero
     * @return
     */
    @SuppressWarnings("unchecked")
	public static ArrayList<Torneo> cargar(File fichero){
        ArrayList<Torneo> lista = null;
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
        }catch(ClassNotFoundException cnfe){
            System.out.println("Error");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error");
        }catch (IOException ioe){
            System.out.println("Error");
        }
        return lista;
    }
    /**
     * Guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false 
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
    	boolean retorno;
        try{
        	//Fichero de salida
            ObjectOutputStream sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            retorno=true;
        }catch(FileNotFoundException fnfe){
        	retorno=false;
        }catch(IOException ioe){
        	retorno=false;
        }
        return retorno;
    }
    
    /**
     * Carga los datos del fichero en el ArrayList lista, luego guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false.
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean cargarYGuardar(File fichero){
    	boolean retorno =guardar(cargar(fichero), fichero);
    	return retorno;
    	
    }
}
