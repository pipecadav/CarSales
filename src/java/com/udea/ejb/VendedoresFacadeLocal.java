
package com.udea.ejb;

import com.udea.entity.Vendedores;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VendedoresFacadeLocal {

    void create(Vendedores vendedores);

    void edit(Vendedores vendedores);

    void remove(Vendedores vendedores);

    Vendedores find(Object id);

    List<Vendedores> findAll();

    List<Vendedores> findRange(int[] range);

    int count();

    boolean checkLogin(String u, String p);
    
    boolean existUsuario(String username);
    
    boolean existID(int id);
    
}
