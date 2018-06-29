/**
 *
 * @author Horacio Ramírez
 */
abstract class UsuarioRegistrado{
    protected String email;
    
}

public final class Usuario extends UsuarioRegistrado{
    private String sexo;
    private String edad;
    private String altura;
    private String peso;
    private String imc;

    public Usuario(String email, String sexo, String edad, String altura, String peso, String imc) {
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}
    public String getEdad() {return edad;}
    public void setEdad(String edad) {this.edad = edad;}
    public String getAltura() {return altura;}
    public void setAltura(String altura) {this.altura = altura;}
    public String getPeso() {return peso;}
    public void setPeso(String peso) {this.peso = peso;}
    public String getImc() {return imc;}
    public void setImc(String imc) {this.imc = imc;}
}

final class UsuarioGenerico extends UsuarioRegistrado{
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;     
    private String tipo;

    public UsuarioGenerico(String email,String nombre, String apellidos, String fechaNacimiento, String tipo) {
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
    }
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getFechaNacimiento() {return fechaNacimiento;}
    public void setFechaNacimiento(String fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
    
}



