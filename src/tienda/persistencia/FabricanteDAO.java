
package tienda.persistencia;

import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;

public class FabricanteDAO extends DAO {
    
    //lista de fabricantes
    public List<Fabricante> listarFabricantes() throws Exception{
    List<Fabricante> fabricantes = new ArrayList();

        try {
            consultarBase("SELECT * FROM fabricante");
                        
            while (resultado.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo")); 

                fabricantes.add(fabricante);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

        return fabricantes;
    }
    //g)ingresar un gabricante a la base de datos
    public void ingresarNuevoFabricante(Fabricante fabricante)throws Exception{
        try {
            String sql = "INSERT INTO fabricante VALUES ('"+fabricante.getCodigo()+"','"+fabricante.getNombre()+"')";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }
    
    public Fabricante buscarPorCodigo(int codigo)throws Exception{
        
        try {
            String sql = "SELECT * FROM fabricante WHERE codigo= " + codigo;
            
            consultarBase(sql);
            Fabricante f = null;
            
            while(resultado.next()){
                f = new Fabricante();
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
            }
            
            return f;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
