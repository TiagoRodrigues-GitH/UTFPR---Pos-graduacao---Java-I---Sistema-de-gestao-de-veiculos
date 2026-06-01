/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_09;

/**
 *
 * @author Tiago Rodrigues
 */
public class Motor {
//======== Atributos classe Motor ============================================== 
    private int qtdPist;
    private int potencia;
    
   
//======== Constructor Default Motor ===========================================
    public Motor(){ 
        this.qtdPist =0;
        this.potencia =0;
    }
   
//======= QtdPist Getters and Setters ==========================================
    
    public int getQtdPist(){
            return  qtdPist;
    }
    public final void setQtdPist(int qtdPist){
        this.qtdPist =  qtdPist;
    }
    
//========Potencia Getters and Setters =========================================
    public int getPotencia(){
        return potencia;
    }
    public final void setPotencia(int potencia){
        this.potencia = potencia;
    }
}
