/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pokimon.dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joseb
 */
public class Entrenador {

    private int id = 0;
    private String nombre;
    private String apellido;
    private int edad;
    private float dinero;
    Scanner reader = new Scanner(System.in);
    private ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();//Equipo del entrenador
    private ArrayList<Pokemon> cajas = new ArrayList<Pokemon>();//Equipo del entrenador
    private ArrayList<Objeto> bolsa = new ArrayList<Objeto>();//Objetos del entrenador

    public Entrenador() {
    }

    public Entrenador(int id) {
        this.id = id;
    }

    public Entrenador(String nombre, String apellido, int edad, float dinero) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dinero = dinero;
    }

    public Entrenador(int id, String nombre, String apellido, int edad, float dinero) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dinero = dinero;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public void inicio_juego(ArrayList<Entrenador> entrenador, ArrayList<Pokemon> pokemons, ArrayList<Objeto> bolsa) throws InterruptedException { //Excepcion que tira el Tread.sleep
        try {
            int starter;
            int opcion;
            int item, cantidad, precio, continuar = 0;
            boolean b_starter = false;
            while (b_starter == false) {
                System.out.println("Escoge un starter: ");
                System.out.println("1.Charmander 2.Squirtle 3.Bulbasaur");
                starter = reader.nextInt();
                switch (starter) {
                    case 1:
                        rellenar_equipo(pokemons.get(3));
                        b_starter = true;
                        break;
                    case 2:
                        rellenar_equipo(pokemons.get(6));
                        b_starter = true;
                        break;
                    case 3:
                        rellenar_equipo(pokemons.get(0));
                        b_starter = true;
                        break;
                    case 4:
                        System.out.println("Has obtenido un pikachu!!!!!");
                        System.out.println("Shhhhh es un secreto");
                        rellenar_equipo(pokemons.get(24));
                        b_starter = true;
                        break;
                    default:
                        System.out.println("Selecciona del 1 al 3");
                }
            }
            do {
                int opcion2 = 0;
                System.out.println("Que quieres hacer");
                System.out.println("1.Explorar 2.Centro Pokemon 3.Mostrar equipo 4.Fin");
                opcion = reader.nextInt();
                switch (opcion) {
                    case 1://Explorar
                        System.out.println("Caminando");
                        int x = (int) (Math.random() * 11);//Random para alternar entrenador o pokemon salvaje
                        Thread.sleep(5000);//Tiempo a esperar
                        if (x <= 7) {
                            int num_pk = (int) (Math.random() * pokemons.size());//Random para seleccionar el pokemon salvaje
                            inicio_captura(pokemons, num_pk);
                        } else if (x > 7) {
                            inicio_combate(entrenador, pokemons);
                        }
                        break;
                    case 2://Curar o comprar objetos
                        System.out.println("De camino al Centro Pokemon");
                        Thread.sleep(2000);
                        while (opcion2 != 4) {
                            System.out.println("1.Curar 2.Comprar Objetos 3.Pokedex 4.Salir");
                            opcion2 = reader.nextInt();
                            switch (opcion2) {
                                case 1://Curar
                                    if (equipo.size() > 1) {
                                        System.out.println("Curando a tus pokemon");
                                        Thread.sleep(3000);
                                        for (int i = 0; i < equipo.size(); i++) {
                                            equipo.get(i).setVida(equipo.get(i).getVida_max());
                                        }
                                        System.out.println("Pokemons curados");
                                    } else {
                                        System.out.println("Curando a tu pokemon");
                                        Thread.sleep(3000);
                                        equipo.get(0).setVida(equipo.get(0).getVida_max());
                                        System.out.println("Pokemon curado");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Tienes: " + this.getDinero() + " Pokemonedas");
                                    System.out.println("Que quieres comprar");
                                    for (int i = 0; i < bolsa.size(); i++) {
                                        System.out.println(i + "." + bolsa.get(i).getNombe() + " Tienes: " + bolsa.get(i).getCantidad());
                                    }
                                    item = reader.nextInt();
                                    while (continuar != 2) {
                                        System.out.println("Cantidad");
                                        cantidad = reader.nextInt();
                                        precio = bolsa.get(item).getPrecio() * cantidad;
                                        if (this.getDinero() < precio) {
                                            System.out.println("No tienes dinero suficiente");
                                            System.out.println("¿Quieres introducir otra cantidad?");
                                            System.out.println("1.Si 2.No");
                                            continuar = reader.nextInt();
                                        } else if (this.getDinero() >= precio) {
                                            this.setDinero(this.getDinero() - precio);
                                            this.bolsa.get(item).setCantidad(this.bolsa.get(item).getCantidad() + cantidad);
                                            System.out.println("Tienes: " + this.bolsa.get(item).getCantidad() + " " + this.bolsa.get(item).getNombe());
                                            continuar = 2;
                                        }
                                    }
                                    break;
                                case 3://Cambiar pokemon de la pokedex al equipo usable en combate
                                    if (this.equipo.size() < 6) {
                                        System.out.println("No tienes suficientes Pokemons");
                                    } else if (this.equipo.size() >= 6) {
                                        int y, z = 0;
                                        while (z != 2) {
                                            System.out.println("Dime que quieres hacer");
                                            System.out.println("1.Mover Pokemon 2.Salir");
                                            z = reader.nextInt();
                                            switch (z) {
                                                case 1:
                                                    System.out.println("Que Pokemon quieres cambiar de tu equipo");
                                                    for (int i = 0; i < equipo.size(); i++) {
                                                        System.out.println(i + "." + equipo.get(i).getNombre());
                                                    }
                                                    y = reader.nextInt();
                                                    cajas.add(equipo.get(y));
                                                    equipo.remove(y);
                                                    System.out.println("Se ha añadido a la caja");
                                                    System.out.println("Que pokemon quieres sacar de la caja");
                                                    for (int i = 0; i < cajas.size(); i++) {
                                                        System.out.println(i + "." + cajas.get(i).getNombre());
                                                    }
                                                    y = reader.nextInt();
                                                    equipo.add(cajas.get(y));
                                                    cajas.remove(y);
                                                    break;
                                                case 2:
                                                    break;
                                                default:
                                                    System.out.println("Selecciona 1 o 2 bobo");
                                            }
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Abandonando Centro Pokemon");
                                    break;
                                default:
                                    System.out.println("Selecciona del 1 al 4 bobo");
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < this.equipo.size(); i++) {
                            System.out.println(i + "." + this.equipo.get(i).toString());
                        }
                        break;
                    case 4:
                        System.out.println("Gracias por Jugar");
                        break;
                    default:
                        System.out.println("Selecciona del 1 al 4 bobo");
                }
            } while (opcion != 4);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void inicio_captura(ArrayList<Pokemon> pokemons, int num_pk) throws InterruptedException {//Recive la lista de pokemons y la posicin del array
        int opcion = 0;
        int num_equipo = 0;
        int cont = 1, cont_equipo = 0;//Contador para cambiar de turno
        int objeto;
        boolean capturar = false;//Para capturar
        boolean escapar = false;//Para salir del bucle
        int vida_pk = pokemons.get(num_pk).getVida();//Vida pokemon enemigo
        System.out.println("Te has encontrado con un: " + pokemons.get(num_pk).getNombre() + " Nivel: " + pokemons.get(num_pk).getNivel());
        while (vida_pk > 0 && escapar == false) {
            if (cont % 2 != 0) {
                if (equipo.get(num_equipo).getVida() > 0) {
                    System.out.println("Que quieres hacer");
                    System.out.println("1.Luchar 2.Objeto 3.Cambiar de Pokemon 4.Huir");
                    opcion = reader.nextInt();
                }
                if (equipo.get(num_equipo).getVida() <= 0 && equipo.size() == 1) {//Por si te matan y solo tienes un pokemon
                    opcion = 100;
                    System.out.println("Pokemon debilitado");
                } else if (equipo.get(num_equipo).getVida() <= 0 && equipo.size() > 1) {//Por si te matan y tienes mas de un pokemon
                    opcion = 3;
                    cont--;
                    cont_equipo++;
                    System.out.println("Pokemon debilitado");
                    if (cont_equipo == equipo.size()) {
                        opcion = 100;
                        System.out.println("Te han vencido");
                    }
                }
                switch (opcion) {
                    case 1://Para atacar
                        int opcion_2;
                        System.out.println("Escoge: ");
                        for (int i = 0; i < equipo.get(num_equipo).getAtaques().length; i++) {
                            System.out.println((i + 1) + "." + equipo.get(num_equipo).getAtaques()[i].getNombre());
                        }
                        opcion_2 = reader.nextInt();
                        switch (opcion_2) {
                            case 1:
                                vida_pk = imprimir_calculo_ataque(equipo, num_equipo, (opcion_2 - 1), vida_pk);
                                cont++;
                                break;
                            case 2:
                                vida_pk = imprimir_calculo_ataque(equipo, num_equipo, (opcion_2 - 1), vida_pk);
                                cont++;
                                break;
                            case 3:
                                vida_pk = imprimir_calculo_ataque(equipo, num_equipo, (opcion_2 - 1), vida_pk);
                                cont++;
                                break;
                            case 4:
                                vida_pk = imprimir_calculo_ataque(equipo, num_equipo, (opcion_2 - 1), vida_pk);
                                cont++;
                                break;
                            default:
                                System.out.println("Selecciona del 1 al 4 bobo");
                        }
                        break;
                    case 2://Para Objetos
                        System.out.println("Que objeto quieres usar");
                        for (int i = 0; i < bolsa.size(); i++) {
                            System.out.println(i + "." + bolsa.get(i).getNombe());
                        }
                        objeto = reader.nextInt();
                        if ("Pokeball".equals(bolsa.get(objeto).getNombe())) {
                            if (bolsa.get(objeto).getCantidad() > 0) {
                                bolsa.get(objeto).setCantidad(bolsa.get(objeto).getCantidad() - 1);
                                for (int i = 0; i < 3; i++) {
                                    int num_cap = (int) (Math.random() * 9 + 1);//Random para hacer aleatoria la captura
                                    if (num_cap <= 5) {
                                        capturar = true;
                                    } else if (num_cap > 5) {
                                        capturar = false;
                                    }
                                    if (capturar == true) {
                                        escapar = true;
                                        if (equipo.size() < 6) {
                                            rellenar_equipo(pokemons.get(num_pk));
                                            System.out.println("Has capturado al pokemon");
                                            int dinero = (int) (Math.random() * 100);
                                            this.setDinero(this.getDinero() + dinero);
                                            System.out.println("Has ganado: " + dinero + " Pokemonedas");
                                        } else if(equipo.size() >= 6) {
                                            cajas.add(pokemons.get(num_pk));
                                            System.out.println("Has capturado al pokemon");
                                            System.out.println("Equipo lleno");
                                            System.out.println("Se ha ido a la caja");
                                            int dinero = (int) (Math.random() * 100);
                                            this.setDinero(this.getDinero() + dinero);
                                            System.out.println("Has ganado: " + dinero + " Pokemonedas");
                                        }
                                        break;
                                    }
                                    capturar = false;
                                }
                                if (escapar == false) {
                                    System.out.println("EL pokemon ha escapado");
                                    cont++;//Para cambiar de turno
                                }
                                if (bolsa.get(objeto).getCantidad() == 1) {
                                    System.out.println("Te queda: " + bolsa.get(objeto).getCantidad() + " Pokeball");
                                } else if (bolsa.get(objeto).getCantidad() > 1) {
                                    System.out.println("Te quedan: " + bolsa.get(objeto).getCantidad() + " Pokeballs");
                                }
                            } else if (bolsa.get(objeto).getCantidad() <= 0) {
                                System.out.println("No tienes pokeballs");
                            }
                        } else if ("Pocion".equals(bolsa.get(objeto).getNombe())) {
                            if (bolsa.get(objeto).getCantidad() > 0) {
                                bolsa.get(objeto).setCantidad(bolsa.get(objeto).getCantidad() - 1);
                                equipo.get(num_equipo).setVida(equipo.get(num_equipo).getVida_max());
                                System.out.println("Curando a: " + equipo.get(num_equipo).getNombre());
                                Thread.sleep(1000);
                                System.out.println("Pokemon Curado");
                                if (bolsa.get(objeto).getCantidad() == 1) {
                                    System.out.println("Te queda: " + bolsa.get(objeto).getCantidad() + " Pocion");
                                } else if (bolsa.get(objeto).getCantidad() > 1) {
                                    System.out.println("Te quedan: " + bolsa.get(objeto).getCantidad() + " Pociones");
                                }
                                cont++;
                            } else if (bolsa.get(objeto).getCantidad() <= 0) {
                                System.out.println("No tienes pociones");
                            }
                        }
                        break;
                    case 3://Para cambiar de pokemon
                        int num;
                        System.out.println("Ha que pokemon quieres cambiar");
                        for (int i = 0; i < this.equipo.size(); i++) {
                            System.out.println(i + "." + this.equipo.get(i).getNombre());
                        }
                        num = reader.nextInt();
                        while ((num_equipo == num) || (equipo.get(num).getVida() <= 0)) {
                            num = reader.nextInt();
                        }
                        num_equipo = num;
                        cont++;
                        break;
                    case 4://Para huir
                        escapar = true;
                        System.out.println("Has huido");
                        break;
                    case 100://Por si te matan todos los pokemon
                        System.out.println("De camino al Centro Pokemon");
                        Thread.sleep(2000);
                        if (equipo.size() > 1) {
                            System.out.println("Curando a tus pokemon");
                            Thread.sleep(3000);
                            for (int i = 0; i < equipo.size(); i++) {
                                equipo.get(i).setVida(equipo.get(i).getVida_max());
                            }
                            System.out.println("Pokemons curados");
                        } else {
                            System.out.println("Curando a tu pokemon");
                            Thread.sleep(3000);
                            equipo.get(num_equipo).setVida(equipo.get(num_equipo).getVida_max());
                            System.out.println("Pokemon curado");
                        }
                        escapar = true;
                        break;
                    default:
                        System.out.println("Selecciona del 1 al 5 bobo");
                }
            } else if (cont % 2 == 0) {
                int y = (int) (Math.random() * 4);//Para randomiza el ataque enemigo
                System.out.println("CAMBIO DE TURNO");
                System.out.println(pokemons.get(num_pk).getNombre() + "ha usado: " + pokemons.get(num_pk).getAtaques()[y].getNombre());
                equipo.get(num_equipo).setVida(imprimir_calculo_ataque(pokemons, num_pk, y, equipo.get(num_equipo).getVida()));
                cont++;
                System.out.println("CAMBIO DE TURNO");
            }
        }
        if (vida_pk <= 0) {//Para cuando matas al pokemon
            System.out.println("Has debilitado a: " + pokemons.get(num_pk).getNombre());
            int dinero = (int) (Math.random() * 200);
            this.setDinero(this.getDinero() + dinero);
            System.out.println("Has ganado: " + dinero + " Pokemonedas");
            escapar = true;
        }
    }

    public int imprimir_calculo_ataque(ArrayList<Pokemon> pokemon, int num_equipo, int opcion, int vida_pk) {//Recibe la lista de pokeon o el equipo, la posicion del array, la posicion del ataque y la vida del pokemon que va recibir el daño
        int danio;
        danio = pokemon.get(num_equipo).getAtaques()[opcion].calcular_danio();
        if (danio == pokemon.get(num_equipo).getAtaques()[opcion].getDanio()) {//Normal
            System.out.println("Le has quitado: " + danio);
            vida_pk = vida_pk - danio;
            System.out.println("Vida restante: " + vida_pk);
        } else if (danio > pokemon.get(num_equipo).getAtaques()[opcion].getDanio()) {//Critico
            System.out.println("Golpe Critico");
            System.out.println("Le has quitado: " + danio);
            vida_pk = vida_pk - danio;
            System.out.println("Vida restante: " + vida_pk);
        } else if (danio < pokemon.get(num_equipo).getAtaques()[opcion].getDanio()) {//Fallar
            System.out.println("El ataque ha fallado");
            System.out.println("Vida restante: " + vida_pk);
        }
        return vida_pk;
    }

    public void inicio_combate(ArrayList<Entrenador> entrenador, ArrayList<Pokemon> pokemons) throws InterruptedException {//Recive la lista de entrenadores y el del equipo
        int opcion = 0;
        int num_equipo = 0;
        int objeto;
        int cont = 1, cont_muertes = 0, cont_equipo = 0;//Contadores para pasar de turno, para contar los pokemon debilitados del enemigo y los propios
        int x = (int) (Math.random() * entrenador.size());
        if (entrenador.get(x).equipo.size() == 1) {//Por el singular o plural dependiendo de los pokemons
            System.out.println("Te has encontrado con el entrenador: " + entrenador.get(x).getNombre() + " y tiene: " + entrenador.get(x).equipo.size() + " Pokemon");
        } else if (entrenador.get(x).equipo.size() > 1) {
            System.out.println("Te has encontrado con el entrenador: " + entrenador.get(x).getNombre() + " y tiene: " + entrenador.get(x).equipo.size() + " Pokemons");
        }
        int num_pk = (int) (Math.random() * entrenador.get(x).equipo.size());
        System.out.println("Y saca al pokemon: " + entrenador.get(x).equipo.get(num_pk).getNombre());
        while ((cont_muertes != entrenador.get(x).equipo.size() && cont_equipo != this.equipo.size())) {//Mientras los contadores sean distintos del ArrayList.size() se continue el combate
            if (cont % 2 != 0) {//Para cambiar de turno
                if (this.equipo.get(num_equipo).getVida() > 0) {
                    System.out.println("Que quieres hacer");
                    System.out.println("1.Luchar 2.Cambiar de Pokemon 3.Objeto");
                    opcion = reader.nextInt();
                }
                if (this.equipo.get(num_equipo).getVida() <= 0 && equipo.size() == 1) {//Por si te matan y solo tienes un pokemon
                    opcion = 100;
                    System.out.println("Pokemon debilitado");
                    cont_equipo++;
                } else if (this.equipo.get(num_equipo).getVida() <= 0 && equipo.size() > 1) {//Por si te matan y tienes mas de un pokemon
                    opcion = 2;
                    cont_equipo++;
                    cont--;
                    System.out.println("Pokemon debilitado");
                    if (cont_equipo == equipo.size()) {
                        opcion = 100;
                        System.out.println("Te han vencido");
                    }
                }
                switch (opcion) {
                    case 1://Para luchar
                        int opcion_2;
                        System.out.println("Escoge: ");
                        for (int i = 0; i < this.equipo.get(num_equipo).getAtaques().length; i++) {
                            System.out.println((i + 1) + "." + this.equipo.get(num_equipo).getAtaques()[i].getNombre());
                        }
                        opcion_2 = reader.nextInt();
                        switch (opcion_2) {
                            case 1:
                                entrenador.get(x).equipo.get(num_pk).setVida(imprimir_calculo_ataque(this.equipo, num_equipo, (opcion_2 - 1), entrenador.get(x).equipo.get(num_pk).getVida()));
                                cont++;
                                break;
                            case 2:
                                entrenador.get(x).equipo.get(num_pk).setVida(imprimir_calculo_ataque(this.equipo, num_equipo, (opcion_2 - 1), entrenador.get(x).equipo.get(num_pk).getVida()));
                                cont++;
                                break;
                            case 3:
                                entrenador.get(x).equipo.get(num_pk).setVida(imprimir_calculo_ataque(this.equipo, num_equipo, (opcion_2 - 1), entrenador.get(x).equipo.get(num_pk).getVida()));
                                cont++;
                                break;
                            case 4:
                                entrenador.get(x).equipo.get(num_pk).setVida(imprimir_calculo_ataque(this.equipo, num_equipo, (opcion_2 - 1), entrenador.get(x).equipo.get(num_pk).getVida()));
                                cont++;
                                break;
                            default:
                                System.out.println("Selecciona del 1 al 4 bobo");
                        }
                        break;
                    case 2://Para cambiar de pokemon
                        int num;
                        System.out.println("Ha que pokemon quieres cambiar");
                        for (int i = 0; i < this.equipo.size(); i++) {
                            System.out.println(i + "." + this.equipo.get(i).getNombre());
                        }
                        num = reader.nextInt();
                        while (num_equipo == num || (this.equipo.get(num).getVida() <= 0)) {
                            System.out.println("Pokemon debilitado");
                            System.out.println("Vuelve a escoger");
                            num = reader.nextInt();
                        }
                        num_equipo = num;
                        cont++;
                        break;
                    case 3://Objetos
                        System.out.println("Que objeto quieres usar");
                        for (int i = 0; i < bolsa.size(); i++) {
                            System.out.println(i + "." + bolsa.get(i).getNombe());
                        }
                        objeto = reader.nextInt();
                        if ("Pokeball".equals(bolsa.get(objeto).getNombe())) {
                            System.out.println("NO PUEDES CAPTURAR UN POKEMON DE UN ENTRENADOR ENEMIGO");
                        } else if ("Pocion".equals(bolsa.get(objeto).getNombe())) {
                            bolsa.get(objeto).setCantidad(bolsa.get(objeto).getCantidad() - 1);
                            equipo.get(num_equipo).setVida(equipo.get(num_equipo).getVida_max());
                            System.out.println("Curando a: " + equipo.get(num_equipo).getNombre());
                            Thread.sleep(1000);
                            System.out.println("Pokemon Curado");
                            if (bolsa.get(objeto).getCantidad() == 1) {
                                System.out.println("Te queda: " + bolsa.get(objeto).getCantidad() + " Pocion");
                            } else if (bolsa.get(objeto).getCantidad() > 1) {
                                System.out.println("Te quedan: " + bolsa.get(objeto).getCantidad() + " Pociones");
                            }
                            cont++;
                        }
                        break;
                    case 100://Por si te matan
                        System.out.println("De camino al Centro Pokemon");
                        Thread.sleep(2000);
                        if (equipo.size() > 1) {
                            System.out.println("Curando a tus pokemon");
                            Thread.sleep(3000);
                            for (int i = 0; i < equipo.size(); i++) {
                                equipo.get(i).setVida(equipo.get(i).getVida_max());
                            }
                            System.out.println("Pokemons curados");
                        } else {
                            System.out.println("Curando a tu pokemon");
                            Thread.sleep(3000);
                            equipo.get(num_equipo).setVida(equipo.get(num_equipo).getVida_max());
                            System.out.println("Pokemon curado");
                        }
                        break;
                    default:
                        System.out.println("Selecciona del 1 al 3 bobo");
                }
            } else if (cont % 2 == 0) {
                if (entrenador.get(x).equipo.get(num_pk).getVida() > 0) {
                    int y = (int) (Math.random() * 4);//Para randomizar el ataque enemigo
                    System.out.println("CAMBIO DE TURNO");
                    System.out.println(entrenador.get(x).equipo.get(num_pk).getNombre() + "ha usado: " + entrenador.get(x).equipo.get(num_pk).getAtaques()[y].getNombre());
                    equipo.get(num_equipo).setVida(imprimir_calculo_ataque(pokemons, num_pk, y, equipo.get(num_equipo).getVida()));
                    cont++;
                    System.out.println("CAMBIO DE TURNO");
                }
            }
            if (entrenador.get(x).equipo.get(num_pk).getVida() <= 0) {//Para cuando matas al pokemon enemigo
                if (entrenador.get(x).equipo.size() > 1) {
                    System.out.println("Has debilitado a: " + entrenador.get(x).equipo.get(num_pk).getNombre());
                    int y = (int) (Math.random() * entrenador.get(x).equipo.size());//Para cambiar el pokemon enemigo
                    while ((num_pk == y) || (entrenador.get(x).equipo.get(y).getVida() <= 0)) {//Si es el ultimo pokemon en batalla que se vuelva a randomizar o si el pokemon selecionado no tiene vida
                        y = (int) (Math.random() * entrenador.get(x).equipo.size());
                    }
                    System.out.println("El entrenador: " + entrenador.get(x).getNombre() + " cambia a: " + entrenador.get(x).equipo.get(y).getNombre());
                    num_pk = y;
                    cont++;
                    cont_muertes++;
                    if (cont_muertes == entrenador.get(x).equipo.size()) {
                        System.out.println("Has debilitado a: " + entrenador.get(x).equipo.get(num_pk).getNombre());
                        System.out.println("Has derrotado al entrenador: " + entrenador.get(x).getNombre());
                        int dinero = (int) (Math.random() * 200);
                        this.setDinero(this.getDinero() + dinero);
                        System.out.println("Has ganado: " + dinero + " Pokemonedas");
                    }
                } else {
                    cont_muertes++;
                    if (cont_muertes == entrenador.get(x).equipo.size()) {
                        System.out.println("Has debilitado a: " + entrenador.get(x).equipo.get(num_pk).getNombre());
                        System.out.println("Has derrotado al entrenador: " + entrenador.get(x).getNombre());
                        int dinero = (int) (Math.random() * 200);
                        this.setDinero(this.getDinero() + dinero);
                        System.out.println("Has ganado: " + dinero + " Pokemonedas");
                    }
                }
            }
        }
        for (int i = 0; i < entrenador.get(x).equipo.size(); i++) {
            entrenador.get(x).equipo.get(i).setVida(entrenador.get(x).equipo.get(i).getVida_max());
        }
    }

    public void rellenar_equipo(Pokemon pokimon) {
        equipo.add(pokimon);
    }

    public void rellenar_equipo_entrenadores(ArrayList<Pokemon> pokemon) {
        int size = (int) (Math.random() * 6 + 1);
        for (int i = 0; i < size; i++) {
            int x = (int) (Math.random() * pokemon.size());
            equipo.add(pokemon.get(x));
        }
    }

    public void rellenar_bolsa(ArrayList<Objeto> bolsa) {
        for (int i = 0; i < bolsa.size(); i++) {
            this.bolsa.add(bolsa.get(i));
        }
    }

    @Override
    public String toString() {
        return "Id =" + id + ", nombre =" + nombre + ", apellido =" + apellido + ", edad =" + edad + ", dinero =" + dinero;
    }

}
