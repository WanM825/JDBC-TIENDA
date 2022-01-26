
package tienda.principal;

import java.util.Scanner;
import tienda.servicios.FabricanteServicio;
import tienda.servicios.ProductoServicio;


public class MainEjercicio1 {

    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
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
            productoServicio.ingresarNuevoProducto(12, "nombre", 275.50, 5);
            System.out.println("-----------------");
            //fabricanteServicio.listarFabricantes();
            //fabricanteServicio.mostrarTodos();
            System.out.println("-----------------");
            //fabricanteServicio.ingresarNuevoFabricante('1', "nombre");
            
            System.out.println("Ingrese el codigo del producto que quiere modificar");
            int codigo = leer.nextInt();
            
            if(codigo)
            System.out.println("Ingrese el dato que quiere modificar");
            System.out.println("1-codigo");
            System.out.println("2-nombre");
            System.out.println("3-precio");
            System.out.println("4-codigo fabricante");
            int opc = leer.nextInt();
            
            
            switch(opc){
                case 1:
                    
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
    }
    
}
