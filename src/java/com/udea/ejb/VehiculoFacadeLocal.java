
package com.udea.ejb;

import com.udea.entity.Vehiculo;
import java.util.List;
import javax.ejb.Local;

@Local
public interface VehiculoFacadeLocal {

    void create(Vehiculo vehiculo);

    void edit(Vehiculo vehiculo);

    void remove(Vehiculo vehiculo);

    Vehiculo find(Object id);

    List<Vehiculo> findAll();

    List<Vehiculo> findRange(int[] range);

    int count();

    boolean existID(int id);

    boolean existPlaca(String placa);
    boolean existMatricula(int matricula);

}
