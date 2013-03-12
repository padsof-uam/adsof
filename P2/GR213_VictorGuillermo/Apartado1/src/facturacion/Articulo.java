package facturacion;

public abstract class Articulo {
    private long identificador;
    private String descripcion;
    private double precioUnitario;

    public Articulo(long id, String desc, double precio) {
        identificador = id; descripcion = desc; precioUnitario = precio;
    }
    public long getIdentificador() { return identificador; }
    public String getDescripcion() { return descripcion; }
    public double getPrecioUnitario() { return precioUnitario; }
    public void setDescripcion(String desc) { descripcion = desc; }
    public void setPrecioUnitario(double precio) { precioUnitario = precio; }

    public String toString(){
        return "Id: "+identificador+" "+descripcion+" Precio unitario: "+getPrecioUnitario();
    }
    // el tipo IVA general es 21% es el aplicable salvo que se redefina en una subclase
    public double tipoIVA() { return 0.21; }

    // cada subclase de articulo calculara el descuento que corresponda
    public abstract double descuento(double unidades);

    // el precio total siemperse calcula de la misma forma
    public double precioTotal(double unidades) {
        return ((precioUnitario * unidades) - descuento(unidades)) * (1.0 + tipoIVA());
    }
}
