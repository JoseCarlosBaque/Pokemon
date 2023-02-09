/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokimon.dominio;

import java.util.ArrayList;

/**
 *
 * @author joseb
 */
public class Pokemon {

    private String id_pokimon;
    private String nombre;
    private int vida;
    private int ptAtaque;
    private int ptDefensa;
    private int nivel;
    private int ptExp;
    private int vida_max;
    private Attack[] ataques = new Attack[4];

    public Pokemon() {
    }

    public Pokemon(String id_pokimon) {
        this.id_pokimon = id_pokimon;
    }

    public Pokemon(String nombre, int vida, int ptAtaque, int ptDefensa, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.ptAtaque = ptAtaque;
        this.ptDefensa = ptDefensa;
        this.nivel = nivel;
    }

    public Pokemon(String id_pokimon, String nombre, int vida, int vida_max, int ptAtaque, int ptDefensa, int nivel) {
        this.id_pokimon = id_pokimon;
        this.nombre = nombre;
        this.vida = vida;
        this.vida_max = vida_max;
        this.ptAtaque = ptAtaque;
        this.ptDefensa = ptDefensa;
        this.nivel = nivel;
    }

    public Pokemon(String id_pokimon, String nombre, int vida, int ptAtaque, int ptDefensa, int nivel, Attack[] ataques) {
        this.id_pokimon = id_pokimon;
        this.nombre = nombre;
        this.vida = vida;
        this.ptAtaque = ptAtaque;
        this.ptDefensa = ptDefensa;
        this.nivel = nivel;
        this.ataques = ataques;
    }

    public String getId_pokimon() {
        return id_pokimon;
    }

    public void setId_pokimon(String id_pokimon) {
        this.id_pokimon = id_pokimon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida_max() {
        return vida_max;
    }

    public int getPtAtaque() {
        return ptAtaque;
    }

    public void setPtAtaque(int ptAtaque) {
        this.ptAtaque = ptAtaque;
    }

    public int getPtDefensa() {
        return ptDefensa;
    }

    public void setPtDefensa(int ptDefensa) {
        this.ptDefensa = ptDefensa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPtExp() {
        return ptExp;
    }

    public void setPtExp(int ptExp) {
        this.ptExp = ptExp;
    }

    public Attack[] getAtaques() {
        return ataques;
    }

    public void setAtaques(Attack[] ataques) {
        this.ataques = ataques;
    }

    public void rellenar_ataques(ArrayList<Attack> ataque) {
        int x;
        for (int i = 0; i < ataques.length; i++) {
            x = (int) (Math.random() * ataque.size());
            ataques[i] = ataque.get(x);
        }
        for (int i = 0; i < ataques.length; i++) {
            for (int j = 0; j < ataques.length; j++) {
                if (i != j) {
                    if (ataques[i] == ataques[j]) {
                        x = (int) (Math.random() * ataque.size());
                        ataques[i] = ataque.get(x);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Id_pokimon = " + id_pokimon + ", Nombre = " + nombre + ", PtAtaque = " + ptAtaque + ", PtDefensa = " + ptDefensa + ", Nivel = " + nivel;
    }

}
