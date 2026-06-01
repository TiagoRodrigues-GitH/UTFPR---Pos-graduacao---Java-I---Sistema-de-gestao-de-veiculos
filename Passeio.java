/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_09;
/**
 *
 * @author Tiago Rodrigues
 */
public final class Passeio extends Veiculo implements Calcular{
    
//======== Atributos da classe Passeio ================================================
    
    private int qtdPassageiros;
    
//======== Constructor Default ================================================
    public Passeio(){
        this.qtdPassageiros = 0;
    }
    
//======= QtdPassageiros Getters and Setters ==================================
    public int getQtdPassageiros(){
    return qtdPassageiros;
    }       
    public final void setQtdPassageiros(int qtdPassageiros){
    this.qtdPassageiros = qtdPassageiros;
    }

//=======Override CalcVec do abstract métode na classe Veiculo==================
    @Override
    public float calcVel(float VelocMax) {
        float x = getVelocMax() * 1000;
        System.out.println("\nVelocidade Veiculo de Passeio em M/h: " + x );
        return x;
    }
//========Override calcular() da interface Calcular ===========================    
     @Override
      public int calcular(){

         int somaLetras = 0;
         somaLetras += getPlaca().length();
         somaLetras += getMarca().length();
         somaLetras += getModelo().length();
         somaLetras += getCor().length();
         
         return somaLetras;
     }

     
}


