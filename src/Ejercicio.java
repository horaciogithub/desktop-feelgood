/**
 *
 * @author Horacio Ramírez
 */
public class Ejercicio {
    private String nombre;
    private String series;
    private String repeticiones;
    private String descanso;

    public Ejercicio(String nombre, String series, String repeticiones, String descanso) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descanso = descanso;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getSeries() {return series;}
    public void setSeries(String series) {this.series = series;}
    public String getRepeticiones() {return repeticiones;}
    public void setRepeticiones(String repeticiones) {this.repeticiones = repeticiones;}
    public String getDescanso() {return descanso;}
    public void setDescanso(String descanso) {this.descanso = descanso;}
    
}
