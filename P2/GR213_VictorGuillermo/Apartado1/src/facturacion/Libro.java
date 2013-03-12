package facturacion;
public class Libro extends Articulo{
    private String categoria;
    public Libro (long id,String desc,double precio ,String tipo){
        super(id,desc,precio);
        categoria = tipo;
    }

    private void setCategoria(String cat){
        categoria = cat;
    }

    /**
     * Cada libro tiene un atributo que identifica a qué
     *      categoría pertenece: “LibroDeTexto”, “Coleccion”, “Best-sellers”, etc. Se debe poder cambiar la categoría de un
     *       libro una vez creado. A los libros se les aplica un tipo de IVA reducido (4%) y su descuento se calcula según su
     *       categoría: 15% para libros de texto, y 50% para la tercera unidad y sucesivas de los libros de colección. Respecto al
     *       tabaco, el precio final se calcula sin descuento y aplicando el tipo de IVA general. Completa la clase Articulo con
     *       un método toString() de forma que, con el código de tus dos nuevas clases, la ejecución de este programa
     */
    public double descuento(double unidades){
        if (categoria.equals("LibroDeTexto"))
            return 0.15*getPrecioUnitario()*unidades;
        else if ((unidades >= 3) && (categoria.equals("Coleccion")))
            return getPrecioUnitario()*(0.5*(unidades-2));

        else
            return 0;
    }

    public double tipoIVA(){ return 0.04; }


}
