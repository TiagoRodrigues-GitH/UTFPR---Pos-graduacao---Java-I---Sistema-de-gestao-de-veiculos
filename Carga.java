/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade_09;

/**
 *
 * @author Tiago Rodrigues
 */
public final class Carga extends Veiculo implements Calcular{
 
   private int cargaMax;
   private int tara;
    
   public Carga(){
       this.cargaMax = 0;
       this.tara = 0;
   }

    public int getCargaMax(){
        return cargaMax;
    }
    
    public final void setCargaMax(int cargaMax){
        this.cargaMax = cargaMax;
    }

    public int getTara(){
        return tara;
    }
    public final void setTara(int tara){
        this.tara = tara;
    }
    @Override
    public float calcVel(float VelocMax){
       
        float x = (getVelocMax()* 100000);
        System.out.println("\nVelocidade Veiculo de Carga em Cm/h: " +x );
        return x; 
    }
    @Override
     public int calcular(){
      
        int somaNum = 0;

        somaNum += Math.round(getVelocMax());
        somaNum += getQtdRodas();
        somaNum += getCargaMax() ;
        somaNum += getTara();
        
        return somaNum;
     }
     

    
}


