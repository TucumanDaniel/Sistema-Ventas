
package Model;

public class Config {
    
    private int id;
    private String cuil;
    private int telefono;
    private String nombre;
    private String direccion;
    private String razon;
    
    public Config(){
        
    }

    public Config(int id, String cuil, int telefono, String nombre, String direccion, String razon) {
        this.id = id;
        this.cuil = cuil;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.razon = razon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
            
    
}
