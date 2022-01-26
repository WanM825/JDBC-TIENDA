package tienda.servicios;

import java.util.List;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;


public class ProductoServicio {
    
    private ProductoDAO dao;
    
    public ProductoServicio() {
        this.dao = new ProductoDAO();
    }
    
    public List<Producto> listarTodos() throws Exception {
        List<Producto> productos = dao.listarTodos();
        return productos;
    }
    
    public void mostrarTodos()throws Exception {
        List<Producto>productos = listarTodos();
        
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
    
    public List<Producto> listarProductoyPrecio() throws Exception{
        List<Producto> productos = dao.listarProductoyPrecio();
        return productos;
    }
    
    public List<Producto> listarPrecioEntre()throws Exception {
        List<Producto> productos = dao.listarPrecioEntre();
        return productos;
    }
    
    public List<Producto> listarProtatil() throws Exception {
        List<Producto> productos = dao.listarPortatil();
        return productos;
    }
    
    public List<Producto> listarMasBarato() throws Exception {
        List<Producto> productos = dao.listarMasBarato();
        return productos;
    }
    
    public void ingresarNuevoProducto(int codigo, String nombre, double precio, int codigoFabricante)throws Exception{
        
       // validar(codigo, nombre, precio, codigoFabricante);
        
        Producto producto = new Producto();
        
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCodigoFabricante(codigoFabricante);
        
        dao.ingresarNuevoProducto(producto);
    }
    
    public Producto buscarProducto(Codigo codigo)throws Exception{
        Producto producto = dao.buscarProducto(codigo);
        
        return producto; 
    }
    
    public void modificarProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {
        
        Producto p = new Producto();
        
        p.setCodigo(codigo);
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setCodigoFabricante(codigoFabricante);
        
        dao.modificarProducto(p);
    }
    
    //valida que los datos esten completos
    public void validar(int codigo, String nombre, double precio, int codigoFabricante)throws Exception{
        
         if (codigo <= 0){
            throw new Exception("Debe indicar el codigo");
        }
        
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Debe indicar el nombre");
        }
        
        if (precio <= 0){
            throw new Exception("Debe indicar el precio");
        }
        
        if (codigoFabricante == 0 && codigoFabricante >=7) {
        } else {
            throw new Exception("Codigo de Fabricante incorrecto");
        }
    }
            
        
    
    
    
    
}
