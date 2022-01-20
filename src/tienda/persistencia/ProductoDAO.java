package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Producto;


public class ProductoDAO extends DAO {
    public List<Producto> listarTodos() throws Exception{
        List <Producto> productos = new ArrayList();
        
        try {
            consultarBase("SELECT * FROM producto");/*query nativa que llama a la TABLA*/
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigoFabricante(resultado.getInt("codigoFabricante"));
                
                productos.add(producto);                         
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
            
        return productos;
    }
    
}
