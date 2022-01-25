
package tienda.principal;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;


public class MainEjercicio1 {

    
    public static void main(String[] args) {
        ProductoServicio productoServicio = new ProductoServicio();
        FabricanteServicio fabricanteServicio = new FabricanteServicio();
        
        try {
            //System.out.println("---------------");
            productoServicio.listarTodos();
            productoServicio.mostrarTodos();
            //System.out.println("----------------");
            //productoServicio.listarProductoyPrecio();
            //productoServicio.listarPrecioEntre();
            //productoServicio.listarMasBarato();
            //System.out.println("----------------");
            productoServicio.ingresarNuevoProducto(2508, "nombre", 275.50, 5);
            System.out.println("-----------------");
            //fabricanteServicio.listarFabricantes();
            //fabricanteServicio.mostrarTodos();
            System.out.println("-----------------");
            //fabricanteServicio.ingresarNuevoFabricante('1', "nombre");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
    }
    
}
