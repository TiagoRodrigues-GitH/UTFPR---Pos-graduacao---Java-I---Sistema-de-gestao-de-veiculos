/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_09;

/**
 *
 * @author Tiago Rodrigues
 */
public abstract class Veiculo {
//======== Atributos da classe Veiculo =========================================
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;
  

//======== Constructor Default =================================================
public Veiculo(){
    this.placa = "";
    this.marca = "";
    this.modelo = "";
    this.cor =  "";
    this.velocMax = 0.0f;
    this.qtdRodas = 0;
    this.motor = new Motor();
}
//======= Placa Getters and Setters ============================================
public String getPlaca(){
    return placa;
}
public final void setPlaca(String placa){
    this.placa = placa;
}
//======= Marca Getters and Setters ============================================

public String getMarca(){
    return marca;
}
public final void setMarca(String marca){
    this.marca = marca;
}
//======= Modelo Getters and Setters ===========================================

public String getModelo(){
    return modelo;
}
public final void setModelo(String modelo){
    this.modelo = modelo;
}
//======= Cor Getters and Setters ==============================================
public String getCor(){
    return cor;
}
public final void setCor(String cor){
    this.cor = cor;
}
//======= VelocMax Getters and Setters =========================================
public float getVelocMax(){
    return velocMax;
}
public final void setVelocMax(float velocMax) throws VelocException{
    if(velocMax < 80 || velocMax > 110){
        throw new VelocException();
    }
    this.velocMax = velocMax;
}

//======= QtdRodas Getters and Setters =========================================
public int getQtdRodas(){
    return qtdRodas;
}
public final void setQtdRodas(int qtdRodas){
    this.qtdRodas= qtdRodas;
}

//======= Motor Getters and Setters ============================================
public Motor getMotor(){
    return motor;
}
public final void setMotor(Motor motor){
    this.motor = motor;
}
//======= CalcVec é um abstract métode na classe Veiculo =======================
public abstract float calcVel(float VelocMax);

}



