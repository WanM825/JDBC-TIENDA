
package tienda.servicios;

import java.util.List;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
    public List<Fabricante> listarFabricantes()throws Exception{
        
        List<Fabricante> fabricantes = dao.listarFabricantes();
        
        return fabricantes;
    }
    
    public void mostrarTodos ()throws Exception{
        
        List<Fabricante> fabricante = listarFabricantes();
        for (Fabricante aux : fabricante) {
            System.out.println(aux);    
        }
    }
    
    public void ingresarNuevoFabricante(int codigo, String nombre)throws Exception{
        validar(codigo, nombre);
        
        Fabricante fabricante = new Fabricante();
        
        fabricante.setCodigo(codigo);
        fabricante.setNombre(nombre);
        
        dao.ingresarNuevoFabricante(fabricante);
    }
    
    public void validar(int codigo, String nombre)throws Exception{
        if (codigo <= 0){
            throw new Exception("Debe indicar el codigo");
        }
        
        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("Debe indicar el nombre");
        }
    }
    
    
}
