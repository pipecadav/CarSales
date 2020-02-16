
package com.udea.ejb;

import com.udea.entity.Ventas;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VentasFacadeLocal {

    void create(Ventas ventas);

    void edit(Ventas ventas);

    void remove(Ventas ventas);

    Ventas find(Object id);

    List<Ventas> findAll();

    List<Ventas> findRange(int[] range);

    int count();

    public boolean existID(int id);
    
}
