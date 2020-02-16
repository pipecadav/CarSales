
package com.udea.entity;


public class VehiculoI {

    protected VehiculoPK vehiculoPK;

    private String marca;

    private int modelo;

    private String linea;

    private String estado;

    private String placa;

    private String bfoto;

    public VehiculoI(VehiculoPK vehiculoPK, String marca, int modelo, String linea, String estado, String placa, String bfoto) {
        this.vehiculoPK = vehiculoPK;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.estado = estado;
        this.placa = placa;

        this.bfoto = bfoto;
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

    public String getbfoto() {
        return bfoto;
    }

    public void setbfoto(String bfoto) {
        this.bfoto = bfoto;
    }

}
