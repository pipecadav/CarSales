
package com.udea.ejb;

import com.udea.entity.Cliente;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ClienteFacadeLocal {

    void create(Cliente cliente);

    void edit(Cliente cliente);

    void remove(Cliente cliente);

    Cliente find(Object id);

    List<Cliente> findAll();

    List<Cliente> findRange(int[] range);

    int count();

    public boolean existID(int parseInt);
         
}
