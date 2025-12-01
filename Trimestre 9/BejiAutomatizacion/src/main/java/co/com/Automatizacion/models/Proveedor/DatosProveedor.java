package co.com.Automatizacion.models.Proveedor;
public class DatosProveedor {
    private String nombre;
    private String nit;
    private String celular;
    private String email;
    private String direccion;

    public DatosProveedor(String nombre, String nit, String celular, String email, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.celular = celular;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() { return nombre; }
    public String getNit() { return nit; }
    public String getCelular() { return celular; }
    public String getEmail() { return email; }
    public String getDireccion() { return direccion; }
}

