package gestenis;
import java.io.*;
import java.util.ArrayList;
/**
 * Clase para gestión de tenistas
 * @author alumno
 *
 */

public class Tenista {
    private String nombre;
    private int edad;
    private ArrayList<Torneo> palmares;
    
    Tenista(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
        //lista de torneos
        palmares=new ArrayList<Torneo>();
    }

    /**
     * Obtenemos el nombre del tenista
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignamos el nombre del tenista
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Nos devuelve la edad del tenista
     * @return la edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Asigna la edad del tenista
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /*
     * Devuelve el palmarés con los nombres de los torneos ganados
     * @return
     */
    public String[] getPalmares(){
        String[] torneoNomGanado = new String[palmares.size()];
        for(int i=0;i<torneoNomGanado.length;i++){
            torneoNomGanado[i] = palmares.get(i).getnombreTorneo();
        }
        return torneoNomGanado;
    }
    /**
     * Añade el torneo ganado al palmarés
     * @param torneo
     */
    public void setPalmares(Torneo torneo){
        palmares.add(torneo);
    }
    
    /*
     * Recorre un bucle acumulando la puntuacionuación obtenida
     * 
     */
    public int getpuntuacionATP(){
    	int puntuacion = 0;
        for(Torneo t:palmares){
            puntuacion += t.getpuntuacion();
        }
        return puntuacion;
    }
    /**
     * Carga en fichero el archivo seleccionado e introduce
     * sus datos en el ArrayList Tenista y devuelve lista
     * @param fichero
     * @return
     */
	@SuppressWarnings("unchecked")
	public static ArrayList<Tenista> cargar(File fichero){
        ArrayList<Tenista> listaTenis = null;
        ObjectInputStream ficheroEntrada;
        try{
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            listaTenis = (ArrayList<Tenista>) ficheroEntrada.readObject();
            ficheroEntrada.close();
        }catch(ClassNotFoundException onfe){
            System.out.println("Error");
        }catch(IOException ioe){
            System.out.println("Error");
        }
        return listaTenis;
    }
    /**
     * Graba en fichero los datos del ArrayList lista
     * devolviendo true si ha sido todo correcto o false en caso contrario
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean guardar(ArrayList<Tenista> lista, File fichero){
    	boolean retorno;
        try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            ficheroSalida.writeObject(lista);
            ficheroSalida.flush();
            ficheroSalida.close();
            retorno=true;
        }catch(FileNotFoundException fnfe){
        	retorno=false;
        }catch(IOException ioe){
        	retorno=false;
        }
        return retorno;
    }
    
    /**
     * Este método carga el fichero en la lista y también guarda lo que había de antes en la lista en el fichero
     * @param fichero
     * @return devuelve true si se ha hecho correctaente
     */
    public static boolean cargarGuardar(File fichero){
    	boolean retorno =guardar(cargar(fichero), fichero);
    	return retorno;
    }
    
  
}
