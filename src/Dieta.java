/**
 *
 * @author Horacio Ramírez
 */
public class Dieta {
    private String nombre;
    private String proteinas;
    private String carbohidratos;
    private String calorias;

    public Dieta(String nombre, String proteinas, String carbohidratos, String calorias) {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.calorias = calorias;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getProteinas() {return proteinas;}
    public void setProteinas(String proteinas) {this.proteinas = proteinas;}
    public String getCarbohidratos() {return carbohidratos;}
    public void setCarbohidratos(String carbohidratos) {this.carbohidratos = carbohidratos;}
    public String getCalorias() {return calorias;}
    public void setCalorias(String calorias) {this.calorias = calorias;}
    
}
