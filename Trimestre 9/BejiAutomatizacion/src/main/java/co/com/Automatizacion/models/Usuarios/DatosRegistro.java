package co.com.Automatizacion.models.Usuarios;

public class DatosRegistro {
    private String num_doc;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String email;
    private String num_tel;
    private String fec_nac;
    private String password;
    public String getNum_doc(){return this.num_doc;}
    public String getNombres(){return this.nombres;}
    public String getApellidos(){return this.apellidos;}
    public String getDireccion(){return this.direccion;}
    public String getEmail(){return  this.email;}
    public String getPassword(){return this.password;}
    public String getNum_tel(){return this.num_tel;}
    public String getFec_nac(){return this.fec_nac;}
    public String setNum_doc(String num_doc){return this.num_doc = num_doc;}
    public String setNombre(String nombres){return this.nombres = nombres;}
    public String setApellido(String apellido){return this.apellidos = apellido;}
    public String setDireccion(String direccion){return this.direccion = direccion;}
    public String setEmail(String email){return this.email = email;}
    public String setPassword(String password){return this.password=password;}
    public String setNum_tel(String num_tel){return this.num_tel = num_tel;}
    public String setFec_nac(String fec_nac){return this.fec_nac=fec_nac;}

    public void mostrarDatos(
            String num_doc,
            String nombres,
            String apellidos,
            String direccion,
            String email,
            String password,
            String num_tel,
            String fec_nac

    ){
        this.num_doc = num_doc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.num_tel = num_tel;
        this.fec_nac = fec_nac;

    }
}
