
package tienda.servicios;

import java.util.List;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

public class FabricanteServicio {
    
    private FabricanteDAO dao;

    public FabricanteServicio() {
        dao = new FabricanteDAO();
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
    
    public Fabricante buscarPorCodigo(int codigo)throws Exception{
        return dao.buscarPorCodigo(codigo);
    }
    
    public void ingresarNuevoFabricante(int codigo, String nombre)throws Exception{
        validar(codigo, nombre);
        
        Fabricante fabricante = new Fabricante();
        
        fabricante.setCodigo(codigo);
        fabricante.setNombre(nombre);
        
        dao.ingresarNuevoFabricante(fabricante);
        System.out.println("Se agrego el fabricante correctamente");
    }
    
    public void validar(int codigo, String nombre)throws Exception{
        if (codigo <= 0){
            throw new Exception("Debe indicar el codigo");
        }
        //el String podemos ponderlo nulo porque es una clase, el primitivo no puede
        if (nombre == null || nombre.trim().isEmpty()) {  //trim detectqa si tiene espacios vacios antes o despues
            throw new Exception("Debe indicar el nombre");
        }
        
        Fabricante f = buscarPorCodigo(codigo);
        
        if(f != null){
            throw new Exception("Ya existe un fabricante con el codigo"+ codigo);
        }
    }
    
    
}
