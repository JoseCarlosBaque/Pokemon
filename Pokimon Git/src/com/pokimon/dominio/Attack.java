/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokimon.dominio;

/**
 *
 * @author joseb
 */
public class Attack {

    private int id;
    private String nombre;
    private int danio;
    private int prob_critico;
    private int prob_acertar;

    public Attack(int id, String nombre, int danio, int prob_critico, int prob_acertar) {
        this.id = id;
        this.nombre = nombre;
        this.danio = danio;
        this.prob_critico = prob_critico;
        this.prob_acertar = prob_acertar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getProb_critico() {
        return prob_critico;
    }

    public void setProb_critico(int prob_critico) {
        this.prob_critico = prob_critico;
    }

    public int getProb_acertar() {
        return prob_acertar;
    }

    public void setProb_acertar(int prob_acertar) {
        this.prob_acertar = prob_acertar;
    }

    public int calcular_danio() {
        int danio = this.danio;
        int prob_crit = (int) (Math.random() * 101);
        int prob_acertar = (int) (Math.random() * 101);
        if (this.prob_acertar == 100) {
            if (prob_crit <= this.prob_critico) {
                danio = (int) ((this.danio * this.prob_critico) / 100);
            } else if (prob_crit > this.prob_critico) {
                danio = this.danio;
            }
        } else if (prob_acertar <= this.prob_acertar) {
            if (prob_crit <= this.prob_critico) {
                danio = (int) ((this.danio * this.prob_critico) / 100);
            } else if (prob_crit > this.prob_critico) {
                danio = this.danio;
            }
        } else if (prob_acertar > this.prob_acertar) {
            danio = 0;
        }
        return danio;
    }

    @Override
    public String toString() {
        return "Nombre =" + nombre + ", daño = " + danio + ", prob_critico =" + prob_critico + ", prob_acertar =" + prob_acertar;
    }

}
