/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

/**
 *
 * @author nandocode
 */
public class Agenda {

    private Cliente personas[];
    private int indice;
    private final int TOTAL_LISTA = 10;

    public Agenda() {
        personas = new Cliente[TOTAL_LISTA];
        indice = -1;
    }

    public boolean addLista(Cliente obj) {
        boolean respuesta = false;
        if (indice < TOTAL_LISTA - 1) {
            indice++;
            personas[indice] = obj;
            respuesta = true;

        }
        return respuesta;
    }

    public boolean eliminarPersona(int id) {
        boolean respuesta = false;
        if (!vacia()) {

            if (existeFolio(id)) {
                int posicion = buscarPersona(id);
                // Acomoda eliminando al primer cliente 
                for (int i = posicion; i <= indice; i++) {
                    if (!(i == indice)) {
                    personas[i] = personas[i + 1];
                    }

                }
                respuesta = true;
                indice--;

            }else{
                System.out.println("No existe filio");
            }
            

        }else{
            System.out.println("array vacio");
        }

        return respuesta;

    }

    public boolean existeFolio(int Busq_folio) {
        boolean bandera = false;
       
        for (int i = 0; i <= indice; i++) {
           
            if (Busq_folio ==  personas[i].getFolio()) {
                bandera = true;
                break;
            }
        }
        return bandera;

    }

    public int buscarPersona(int folio) {
        int respuesta = -1;
        for (int i = 0; i <= indice; i++) {
            if (personas[i].getFolio()==folio) {
                respuesta = i;
                break;
            }
        }
        return respuesta;

    }

    public boolean vacia() {
        boolean bandera;
        if (indice == -1) {
            bandera = true;
        } else {
            bandera = false;
        }
        return bandera;

    }

    public int getIndice() {
        return indice;
    }

    public Cliente itemAgenda(int i) {
        return personas[i];
    }

    public int personasLength() {
        return personas.length;

    }

}
