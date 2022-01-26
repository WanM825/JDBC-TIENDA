package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Producto;


public class ProductoDAO extends DAO {
    
    /*a. listar los objetos completos de la tabla producto*/
    public List<Producto> listarTodos() throws Exception{
        List <Producto> productos = new ArrayList();
        
        try {
            consultarBase("SELECT * FROM producto");/*query nativa que llama a la TABLA*/
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                
                productos.add(producto);                         
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        return productos;
    }
    //b.Lista los nombres y precios de todos los productos de la tabla productos
    public List<Producto> listarProductoyPrecio () throws Exception{
        List <Producto> productos = new ArrayList();
        try {
            consultarBase("SELECT nombre, precio FROM producto");
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        return productos;
    }    
    
    //c.listar aquellos productos que su precio este entre 120 y 202
    public List<Producto> listarPrecioEntre()throws Exception{
        List <Producto> productos = new ArrayList();
        
        try {
            consultarBase("SELECT precio FROM producto WHERE precio<203 AND precio>119");
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setPrecio(resultado.getDouble("precio"));
                
                productos.add(producto);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    
        return productos;
    }
    
    //d.buscar y listar todos los portátiles de la tabla producto
    public List<Producto> listarPortatil() throws Exception{
        List <Producto> productos = new ArrayList();
        
        try {
            consultarBase("SELECT nombre FROM producto WHERE nombre LIKE 'Portátil%'");
            
            while(resultado.next()){
            Producto producto = new Producto();
            producto.setNombre(resultado.getString("nombre"));
            
            productos.add(producto);
            }
                        
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
               
        return productos;
    }
    
    //e.listar el nombre y el precio del producto más barato
    public List<Producto> listarMasBarato()throws Exception{
        List <Producto> productos = new ArrayList();
        
        try {
            consultarBase("SELECT MIN(precio) FROM producto");
            
            while(resultado.next()){
                Producto producto = new Producto();
                producto.setPrecio(resultado.getDouble(1));
                
                productos.add(producto);   
            }
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
        return productos;
    }
    
    //f.ingresar un producto a la base de datos
    public void ingresarNuevoProducto(Producto producto)throws Exception{
        try {
            String sql = "INSERT INTO producto VALUES ('"+ producto.getCodigo() +"','"+ producto.getNombre() +"','"
                    + producto.getPrecio()+"','"+ producto.getCodigoFabricante()+"')";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }
    
    //h. editar un producto con datos a eleccion
    public Producto buscarProducto(Codigo codigo)throws Exception{
           
    Producto producto = null;

        try {
            String sql = "SELECT * FROM producto WHERE codigo LIKE '" + codigo + "'";

            consultarBase(sql);

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
        return producto;
    }
    
    public void modificarProducto(Producto producto, int opc) throws Exception{
        try {
            if(opc==1){
                String sql = "UPDATE producto SET nombre='" + producto.getNombre()
                    + "' WHERE nombre LIKE '" + producto.getNombre()+ "'";
            }
            
            if(opc==2){
                String sql = "UPDATE producto SET codigo='" + producto.getCodigo()
                    + "'WHERE codigo LIKE '" + producto.getCodigo()+"'";
            }
            
            if(opc==3){
                String sql = "UPDATE producto SET precio='" + producto.getPrecio()
                   + "' WHERE precio LIKE '" + producto.getPrecio()+"'";
            }
            if(opc==4){
                String sql = "UPDATE producto SET codigo='" + producto.getCodigoFabricante()
                   +"'WHERE codigoFabricante LIKE '" + producto.getCodigoFabricante() + "'";
            }
            
            insertarModificarEliminar(sql);        
        } catch (Exception e) {
            throw e;
        }
    }
    
}
