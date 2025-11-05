package co.com.Automatizacion.models;

public class DatosEditar {

    private String nombres;
    private String apellidos;
    private String direccion;
    private String num_tel;

    public String getNombres(){return this.nombres;}
    public String getApellidos(){return this.apellidos;}
    public String getDireccion(){return this.direccion;}
    public String getNum_tel(){return this.num_tel;}
    public String setNombres(String nombres){return this.nombres=nombres;}
    public String setApellidos(String apellidos){return this.apellidos=apellidos;}
    public String setDireccion(String direccion){return this.direccion=direccion;}
    public String setNumTel(String num_tel){return this.num_tel=num_tel;}
    public void MostrarDatos(
            String nombres,
            String apellidos,
            String direccion,
            String num_tel){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.num_tel = num_tel;
    }

}
