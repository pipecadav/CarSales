package com.udea.entity;

import com.udea.entity.VehiculoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-16T16:41:25")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile SingularAttribute<Vehiculo, String> estado;
    public static volatile SingularAttribute<Vehiculo, byte[]> foto;
    public static volatile SingularAttribute<Vehiculo, VehiculoPK> vehiculoPK;
    public static volatile SingularAttribute<Vehiculo, Integer> modelo;
    public static volatile SingularAttribute<Vehiculo, String> linea;
    public static volatile SingularAttribute<Vehiculo, String> placa;

}