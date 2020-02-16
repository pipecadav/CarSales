/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jefry
 */
@Embeddable
public class VehiculoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;

    public VehiculoPK() {
    }

    public VehiculoPK(int id, int matricula) {
        this.id = id;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) matricula;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoPK)) {
            return false;
        }
        VehiculoPK other = (VehiculoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.VehiculoPK[ id=" + id + ", matricula=" + matricula + " ]";
    }
    
}
