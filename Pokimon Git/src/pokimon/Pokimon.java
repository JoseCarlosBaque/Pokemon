/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokimon;

import com.pokimon.dominio.*;
import java.util.ArrayList;

/**
 *
 * @author joseb
 */
public class Pokimon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        ArrayList<Attack> lista_ataques = new ArrayList<Attack>();
        //Declaro pokemons
        Pokemon Bulbasaur = new Pokemon("001", "Bulbasaur", 90, 90, 49, 49, 5);
        Pokemon Ivysaur = new Pokemon("002", "Ivysaur", 120, 120, 62, 63, 5);
        Pokemon Venusaur = new Pokemon("003", "Venusaur", 160, 160, 82, 83, 5);
        Pokemon Charmander = new Pokemon("004", "Charmander", 80, 80, 52, 43, 5);
        Pokemon Charmeleon = new Pokemon("005", "Charmeleon", 111, 111, 64, 58, 5);
        Pokemon Charizard = new Pokemon("006", "Charizard", 156, 156, 84, 78, 5);
        Pokemon Squirtle = new Pokemon("007", "Squirtle", 95, 95, 48, 65, 5);
        Pokemon Wartortle = new Pokemon("008", "Wartortle", 119, 119, 63, 80, 5);
        Pokemon Blastoise = new Pokemon("009", "Blastoise", 158, 158, 83, 100, 5);
        Pokemon Caterpie = new Pokemon("010", "Caterpie", 90, 90, 30, 35, 5);
        Pokemon Metapod = new Pokemon("011", "Metapod", 100, 100, 20, 55, 5);
        Pokemon Butterfree = new Pokemon("012", "Butterfree", 120, 120, 45, 50, 5);
        Pokemon Weedle = new Pokemon("013", "Weedle", 80, 80, 35, 30, 5);
        Pokemon Kakuna = new Pokemon("014", "Kakuna", 90, 90, 25, 50, 5);
        Pokemon Beedrill = new Pokemon("015", "Beedrill", 130, 130, 90, 40, 5);
        Pokemon Pidgey = new Pokemon("016", "Pidgey", 80, 80, 45, 40, 5);
        Pokemon Pidgeotto = new Pokemon("017", "Pidgeotto", 126, 126, 60, 55, 5);
        Pokemon Pidgeot = new Pokemon("018", "Pidgeot", 166, 166, 80, 75, 5);
        Pokemon Rattata = new Pokemon("019", "Rattata", 60, 60, 56, 35, 5);
        Pokemon Raticate = new Pokemon("020", "Raticate", 110, 110, 81, 60, 5);
        Pokemon Spearow = new Pokemon("021", "Spearow", 80, 80, 60, 30, 5);
        Pokemon Fearow = new Pokemon("022", "Fearow", 130, 130, 90, 65, 5);
        Pokemon Ekans = new Pokemon("023", "Ekans", 70, 70, 60, 44, 5);
        Pokemon Arbok = new Pokemon("024", "Arbok", 120, 120, 85, 69, 5);
        Pokemon Pikachu = new Pokemon("025", "Pikachu", 70, 70, 55, 40, 5);
        Pokemon Raichu = new Pokemon("026", "Raichu", 120, 120, 90, 55, 5);
        Pokemon Sandshrew = new Pokemon("027", "Sandshrew", 100, 100, 75, 85, 5);
        Pokemon Sandslash = new Pokemon("028", "Sandslash", 150, 150, 100, 110, 5);
        //Los añado al arraylist
        pokemons.add(Bulbasaur);
        pokemons.add(Ivysaur);
        pokemons.add(Venusaur);
        pokemons.add(Charmander);
        pokemons.add(Charmeleon);
        pokemons.add(Charizard);
        pokemons.add(Squirtle);
        pokemons.add(Wartortle);
        pokemons.add(Blastoise);
        pokemons.add(Caterpie);
        pokemons.add(Metapod);
        pokemons.add(Butterfree);
        pokemons.add(Weedle);
        pokemons.add(Kakuna);
        pokemons.add(Beedrill);
        pokemons.add(Pidgey);
        pokemons.add(Pidgeotto);
        pokemons.add(Pidgeot);
        pokemons.add(Rattata);
        pokemons.add(Raticate);
        pokemons.add(Spearow);
        pokemons.add(Fearow);
        pokemons.add(Ekans);
        pokemons.add(Arbok);
        pokemons.add(Pikachu);
        pokemons.add(Raichu);
        pokemons.add(Sandshrew);
        pokemons.add(Sandslash);
        //Declaro los ataques
        Attack Tackle = new Attack(1, "Tacleada", 40, 10, 80);
        Attack LatigoCepa = new Attack(2, "Latigo Cepa", 45, 5, 75);
        Attack HojaRazor = new Attack(3, "Hoja Razor", 55, 15, 70);
        Attack RayoSolar = new Attack(4, "Rayo Solar", 60, 20, 65);
        Attack FuegoFatuo = new Attack(5, "Fuego Fatuo", 50, 10, 75);
        Attack Llamarada = new Attack(6, "Llamarada", 65, 15, 70);
        Attack Chispazo = new Attack(7, "Chispazo", 40, 5, 80);
        Attack AguaVida = new Attack(8, "Agua Vida", 55, 10, 75);
        Attack Placaje = new Attack(9, "Placaje", 60, 15, 70);
        Attack AtaqueAla = new Attack(10, "Ataque ala", 40, 5, 80);
        Attack Picotazo = new Attack(11, "Pico Tazo", 50, 10, 75);
        Attack GarraFilosa = new Attack(12, "Garra Filosa", 60, 15, 70);
        Attack Cuchillada = new Attack(13, "Cuchillada", 55, 10, 75);
        Attack Llama = new Attack(14, "Llama", 65, 15, 70);
        Attack Hielo = new Attack(15, "Hielo", 60, 20, 65);
        Attack Psiquico = new Attack(16, "Psiquico", 70, 25, 60);
        Attack Puñetazo = new Attack(17, "Puñetazo", 45, 5, 75);
        Attack ChorroÁcido = new Attack(18, "Chorro Ácido", 50, 10, 70);
        Attack PatadaVoladora = new Attack(19, "Patada Voladora", 55, 15, 65);
        Attack RayoHielo = new Attack(20, "Rayo Hielo", 60, 20, 60);
        Attack LlamaradaDragon = new Attack(21, "Llamarada Dragon", 70, 25, 55);
        Attack RayoDragon = new Attack(22, "Rayo Dragon", 65, 20, 60);
        Attack SombraNeblina = new Attack(23, "Sombra Neblina", 55, 10, 70);
        Attack DanzaFolletín = new Attack(24, "Danza Folletín", 60, 15, 65);
        Attack BolaSombra = new Attack(25, "Bola Sombra", 65, 20, 60);
        Attack Terremoto = new Attack(26, "Terremoto", 70, 25, 55);
        Attack Enjambre = new Attack(27, "Enjambre", 60, 20, 60);
        Attack Niebla = new Attack(28, "Niebla", 55, 15, 65);
        //Los añado al arraylist
        lista_ataques.add(Tackle);
        lista_ataques.add(LatigoCepa);
        lista_ataques.add(HojaRazor);
        lista_ataques.add(RayoSolar);
        lista_ataques.add(FuegoFatuo);
        lista_ataques.add(Llamarada);
        lista_ataques.add(Chispazo);
        lista_ataques.add(AguaVida);
        lista_ataques.add(Placaje);
        lista_ataques.add(AtaqueAla);
        lista_ataques.add(Picotazo);
        lista_ataques.add(GarraFilosa);
        lista_ataques.add(Cuchillada);
        lista_ataques.add(Llama);
        lista_ataques.add(Hielo);
        lista_ataques.add(Psiquico);
        lista_ataques.add(Puñetazo);
        lista_ataques.add(ChorroÁcido);
        lista_ataques.add(PatadaVoladora);
        lista_ataques.add(RayoHielo);
        lista_ataques.add(LlamaradaDragon);
        lista_ataques.add(RayoDragon);
        lista_ataques.add(SombraNeblina);
        lista_ataques.add(DanzaFolletín);
        lista_ataques.add(BolaSombra);
        lista_ataques.add(Terremoto);
        lista_ataques.add(Enjambre);
        lista_ataques.add(Niebla);
        //LLeno los ataques de cada Pokemon
        Bulbasaur.rellenar_ataques(lista_ataques);
        Ivysaur.rellenar_ataques(lista_ataques);
        Venusaur.rellenar_ataques(lista_ataques);
        Charmander.rellenar_ataques(lista_ataques);
        Charmeleon.rellenar_ataques(lista_ataques);
        Charizard.rellenar_ataques(lista_ataques);
        Squirtle.rellenar_ataques(lista_ataques);
        Wartortle.rellenar_ataques(lista_ataques);
        Blastoise.rellenar_ataques(lista_ataques);
        Caterpie.rellenar_ataques(lista_ataques);
        Metapod.rellenar_ataques(lista_ataques);
        Butterfree.rellenar_ataques(lista_ataques);
        Weedle.rellenar_ataques(lista_ataques);
        Kakuna.rellenar_ataques(lista_ataques);
        Beedrill.rellenar_ataques(lista_ataques);
        Pidgey.rellenar_ataques(lista_ataques);
        Pidgeotto.rellenar_ataques(lista_ataques);
        Pidgeot.rellenar_ataques(lista_ataques);
        Rattata.rellenar_ataques(lista_ataques);
        Raticate.rellenar_ataques(lista_ataques);
        Spearow.rellenar_ataques(lista_ataques);
        Fearow.rellenar_ataques(lista_ataques);
        Ekans.rellenar_ataques(lista_ataques);
        Arbok.rellenar_ataques(lista_ataques);
        Pikachu.rellenar_ataques(lista_ataques);
        Raichu.rellenar_ataques(lista_ataques);
        Sandshrew.rellenar_ataques(lista_ataques);
        Sandslash.rellenar_ataques(lista_ataques);
        ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();//Listado Entrenadores
        //Declaro entrenadores
        Entrenador Entrenador1 = new Entrenador(1, "Juan", "Pérez", 20, 1000f);
        Entrenador Entrenador2 = new Entrenador(2, "María", "Rodríguez", 22, 1500);
        Entrenador Entrenador3 = new Entrenador(3, "Pedro", "González", 25, 2000);
        Entrenador Entrenador4 = new Entrenador(4, "Ana", "Sánchez", 18, 1200);
        Entrenador Entrenador5 = new Entrenador(5, "Luis", "Martínez", 21, 1700);
        Entrenador Entrenador6 = new Entrenador(6, "Sofía", "García", 24, 2500);
        Entrenador Entrenador7 = new Entrenador(7, "David", "Jiménez", 19, 1300);
        Entrenador Entrenador8 = new Entrenador(8, "Laura", "Ruiz", 22, 1700);
        Entrenador Entrenador9 = new Entrenador(9, "José", "Hernández", 25, 2100);
        Entrenador Entrenador10 = new Entrenador(10, "Isabel", "Díaz", 20, 1000);
        //Les añado un equipo
        Entrenador1.rellenar_equipo_entrenadores(pokemons);
        Entrenador2.rellenar_equipo_entrenadores(pokemons);
        Entrenador3.rellenar_equipo_entrenadores(pokemons);
        Entrenador4.rellenar_equipo_entrenadores(pokemons);
        Entrenador5.rellenar_equipo_entrenadores(pokemons);
        Entrenador6.rellenar_equipo_entrenadores(pokemons);
        Entrenador7.rellenar_equipo_entrenadores(pokemons);
        Entrenador8.rellenar_equipo_entrenadores(pokemons);
        Entrenador9.rellenar_equipo_entrenadores(pokemons);
        Entrenador10.rellenar_equipo_entrenadores(pokemons);
        //Los añado al arraylist
        entrenadores.add(Entrenador1);
        entrenadores.add(Entrenador2);
        entrenadores.add(Entrenador3);
        entrenadores.add(Entrenador4);
        entrenadores.add(Entrenador5);
        entrenadores.add(Entrenador6);
        entrenadores.add(Entrenador7);
        entrenadores.add(Entrenador8);
        entrenadores.add(Entrenador9);
        entrenadores.add(Entrenador10);
        //Declaro los objetos
        ArrayList<Objeto> bolsa = new ArrayList<Objeto>();
        Objeto pokeball = new Objeto(1, "Pokeball", 10, 20);
        Objeto pociones = new Objeto(2, "Pocion", 10, 20);
        //Los añado al arraylist
        bolsa.add(pokeball);
        bolsa.add(pociones);
        Entrenador e1 = new Entrenador(1, "Jose Carlos", "Baque Meneses", 20, 10000);
        e1.rellenar_bolsa(bolsa);
        e1.inicio_juego(entrenadores, pokemons, bolsa);
    }

}
