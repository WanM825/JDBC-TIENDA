
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
    
    public void ingresarNuevoFabricante(Fabricante fabricante)throws Exception{
        try {
            String sql = "INSERT INTO fabricante VALUES ('"+fabricante.getCodigo()+"','"+fabricante.getNombre()+"')";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }
    
}
