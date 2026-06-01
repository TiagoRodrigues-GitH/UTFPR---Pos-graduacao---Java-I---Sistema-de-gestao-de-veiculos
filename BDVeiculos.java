/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_09;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Rodrigues
 */

public class BDVeiculos {

    private List<Passeio> listaPasseio = new ArrayList<>();
    private List<Carga> listaCarga = new ArrayList<>();

    public BDVeiculos() {

    }

    //=========== Getters e Setters ==============

    public List<Passeio> getListaPasseio() {
        return listaPasseio;
    }

    public void setListaPasseio(List<Passeio> listaPasseio) {
        this.listaPasseio = listaPasseio;
    }

    public List<Carga> getListaCarga() {
        return listaCarga;
    }

    public void setListaCarga(List<Carga> listaCarga) {
        this.listaCarga = listaCarga;
    }

    //=========== Verificar Placa ==============

    public boolean existePlaca(String placa) throws VeicExistException {
        for (Passeio p : listaPasseio) {
            if (p.getPlaca().equalsIgnoreCase(placa)) {
                throw new VeicExistException();
            }
        }

        for (Carga c : listaCarga) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                throw new VeicExistException();
            }
        }

        return false;
    }
}