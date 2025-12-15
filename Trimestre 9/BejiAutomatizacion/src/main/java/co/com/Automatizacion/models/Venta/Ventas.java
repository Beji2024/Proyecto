package co.com.Automatizacion.models.Venta;

public class Ventas {


    private String nombre_cli;
    private String direccion_cli;
    private String correo_cli;
    private String num_tel_cli;
    private String num_doc_cli;
    private String referencia;
    private String cantidad;
    private String vendedor;


    public Ventas(String nombre_cli, String direccion_cli, String correo_cli,
                 String num_tel_cli, String num_doc_cli,
                 String referencia, String cantidad, String vendedor) {

        this.nombre_cli = nombre_cli;
        this.direccion_cli = direccion_cli;
        this.correo_cli = correo_cli;
        this.num_tel_cli = num_tel_cli;
        this.num_doc_cli = num_doc_cli;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public String getNombre_cli() { return nombre_cli; }
    public void setNombre_cli(String nombre_cli) { this.nombre_cli = nombre_cli; }

    public String getDireccion_cli() { return direccion_cli; }
    public void setDireccion_cli(String direccion_cli) { this.direccion_cli = direccion_cli; }

    public String getCorreo_cli() { return correo_cli; }
    public void setCorreo_cli(String correo_cli) { this.correo_cli = correo_cli; }

    public String getNum_tel_cli() { return num_tel_cli; }
    public void setNum_tel_cli(String num_tel_cli) { this.num_tel_cli = num_tel_cli; }

    public String getNum_doc_cli() { return num_doc_cli; }
    public void setNum_doc_cli(String num_doc_cli) { this.num_doc_cli = num_doc_cli; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public String getCantidad() { return cantidad; }
    public void setCantidad(String cantidad) { this.cantidad = cantidad; }

    public String getVendedor() { return vendedor; }
    public void setVendedor(String vendedor) { this.vendedor = vendedor; }
}

