package facturacion;

public class Tabaco extends Articulo {
    public Tabaco(long id, String desc, double precio){
        super(id,desc,precio);
    }

    public double descuento(double desc){ return 0;}
}
