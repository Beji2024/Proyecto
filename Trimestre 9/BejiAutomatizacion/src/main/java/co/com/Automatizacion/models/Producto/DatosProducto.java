package co.com.Automatizacion.models.Producto;

public class DatosProducto {
    private String nombreProducto;
    private String categoria;
    private String subcategoria;
    private String cantidad;
    private String talla;
    private String precioVenta;
    private String precioCompra;
    private String material;
    private String color;
    private String imagen;

    public DatosProducto(String nombreProducto, String categoria, String subcategoria, String cantidad,
                         String talla, String precioVenta, String precioCompra, String material,
                         String color, String imagen) {
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.cantidad = cantidad;
        this.talla = talla;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.material = material;
        this.color = color;
        this.imagen = imagen;
    }

    public String getNombreProducto() { return nombreProducto; }
    public String getCategoria() { return categoria; }
    public String getSubcategoria() { return subcategoria; }
    public String getCantidad() { return cantidad; }
    public String getTalla() { return talla; }
    public String getPrecioVenta() { return precioVenta; }
    public String getPrecioCompra() { return precioCompra; }
    public String getMaterial() { return material; }
    public String getColor() { return color; }
    public String getImagen() { return imagen; }
}
