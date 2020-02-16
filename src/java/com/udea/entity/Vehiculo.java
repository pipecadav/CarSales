/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jefry
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.vehiculoPK.id = :id"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByModelo", query = "SELECT v FROM Vehiculo v WHERE v.modelo = :modelo"),
    @NamedQuery(name = "Vehiculo.findByLinea", query = "SELECT v FROM Vehiculo v WHERE v.linea = :linea"),
    @NamedQuery(name = "Vehiculo.findByEstado", query = "SELECT v FROM Vehiculo v WHERE v.estado = :estado"),
    @NamedQuery(name = "Vehiculo.findByMatricula", query = "SELECT v FROM Vehiculo v WHERE v.vehiculoPK.matricula = :matricula"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VehiculoPK vehiculoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modelo")
    private int modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "linea")
    private String linea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Size(max = 10)
    @Column(name = "placa")
    private String placa;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    
    //private String bFoto;

   
    public Vehiculo() {
    }

    public Vehiculo(VehiculoPK vehiculoPK) {
        this.vehiculoPK = vehiculoPK;
    }

    public Vehiculo(VehiculoPK vehiculoPK, String marca, int modelo, String linea, String estado, String placa, byte[] foto) {
        this.vehiculoPK = vehiculoPK;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.estado = estado;
        this.placa = placa;
        this.foto = foto;
    }

    public Vehiculo(int id, int matricula) {
        this.vehiculoPK = new VehiculoPK(id, matricula);
    }

    public VehiculoPK getVehiculoPK() {
        return vehiculoPK;
    }

    public void setVehiculoPK(VehiculoPK vehiculoPK) {
        this.vehiculoPK = vehiculoPK;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    /* public String getbFoto() {
        return bFoto;
    }

    public void setbFoto(String bFoto) {
        this.bFoto = bFoto;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculoPK != null ? vehiculoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.vehiculoPK == null && other.vehiculoPK != null) || (this.vehiculoPK != null && !this.vehiculoPK.equals(other.vehiculoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "vehiculoPK=" + vehiculoPK + ", marca=" + marca + ", modelo=" + modelo + ", linea=" + linea + ", estado=" + estado + ", placa=" + placa + ", foto=" + foto + '}';
    }

}
