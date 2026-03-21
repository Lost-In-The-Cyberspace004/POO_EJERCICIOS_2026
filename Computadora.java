package com.mycompany.mavenproject1;

import java.util.Scanner;

class Procesos {
    
    String Computador;
    boolean Estado;
    boolean Prestado;
    long id;

    Procesos(String Computador, boolean estado, boolean prestado, long ID) {
        this.Computador = Computador;
        this.Estado = estado;
        this.Prestado = prestado;
        this.id = ID;
    }

    public boolean prestar(String Buscar, Procesos[] lista){
        for(int i = 0; i < lista.length; i++){
            if(lista[i].getComputador().equalsIgnoreCase(Buscar)){
                if(!lista[i].isPrestado()){
                    lista[i].setPrestado(true);
                    return true; //Si existe y esta disponible
                }else{
                    return false; //Si existe y no esta disponible 
                }
            }
        }
        return false;
    }

    public boolean liberar(String Liberar, Procesos[] listaElementos){
        for(int i = 0; i <  listaElementos.length; i++){
            if(listaElementos[i].getComputador().equalsIgnoreCase(Liberar)){
                if(listaElementos[i].isPrestado()){
                    listaElementos[i].setPrestado(false);
                    return false;
                }
            }
        }
        return true;
    }

    public void cambiarEstado(long BuscarID, Procesos[] ListaDePCs) {
        for(int i = 0; i < ListaDePCs.length; i++){
            if(ListaDePCs[i].getId() == BuscarID){
                System.out.println("PC: " + ListaDePCs[i].getComputador() + " ID: " + ListaDePCs[i].getId());
            }
        }
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public boolean isPrestado() {
        return Prestado;
    }

    public void setPrestado(boolean Prestado) {
        this.Prestado = Prestado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComputador() {
        return Computador;
    }

    public void setComputador(String Computador) {
        this.Computador = Computador;
    }
}

public class Computadora {

    public static void main(String[] args) {
        Procesos Obj = new Procesos("Toshiba",true, true, (long)(Math.random()*9999)*1000);
        
        Scanner EntrUs = new Scanner(System.in);
        
        Procesos[] Computadores = new Procesos[10];
        Computadores[0] = new Procesos("Pavilion",true, false, (long)(Math.random()*9999)*1000);
        Computadores[1] = new Procesos("Legion",true, false, (long)(Math.random()*9999)*1000);
        Computadores[2] = new Procesos("Thinpak",true, false, (long)(Math.random()*9999)*1000);
        Computadores[3] = new Procesos("Asus",true, false, (long)(Math.random()*9999)*1000);
        Computadores[4] = new Procesos("HP",true, false, (long)(Math.random()*9999)*1000);
        Computadores[5] = new Procesos("Alienware",true, false, (long)(Math.random()*9999)*1000);
        Computadores[6] = new Procesos("Acer",true, false, (long)(Math.random()*9999)*1000);
        Computadores[7] = new Procesos("MAC",true, false, (long)(Math.random()*9999)*1000);
        Computadores[8] = new Procesos("IBM PC",true, false, (long)(Math.random()*9999)*1000);
        Computadores[9] = new Procesos("Commodore",true, false, (long)(Math.random()*9999)*1000);

        
        String Entrada = "";
        String Prestar  = "";
        String Liberar = "";
        long Buscar = 0;
        do {
            System.out.println("\n");
            System.out.println("1-) Computadores en la sala");
            System.out.println("2-) Disponibles");
            System.out.println("3-) Prestar");
            System.out.println("4-) Liberar");
            System.out.println("5-) Buscar");
            System.out.print("Ingresa un valor: ");
            Entrada = EntrUs.nextLine();
            if(Entrada.equalsIgnoreCase("Salir")){
                break;
            }if(Entrada.equalsIgnoreCase("1")){
                for(int i = 0; i < Computadores.length; i++){
                    System.out.println("Computadores: "+ (i+1) + " " + " " + Computadores[i].Computador + " " + " Estado: " + Computadores[i].Estado + " " + " Prestado: " + Computadores[i].Prestado + " ID " + Computadores[i].id);
                }
            }if(Entrada.equalsIgnoreCase("2")){
                for(Procesos i : Computadores){
                    System.out.println("Computador: " + " " + i.getComputador() + " Prestado: " + i.isPrestado());
                }
            }
            if(Entrada.equalsIgnoreCase("3")){
                System.out.print("Computador a prestar: ");
                Prestar = EntrUs.nextLine();
                boolean elemento = Obj.prestar(Prestar, Computadores);
                if(elemento){
                    System.out.println("Prestado: "+elemento);
                }else{
                    System.out.println("Error "+elemento);
                }
            }
            if(Entrada.equalsIgnoreCase("4")){
                System.out.print("Computadora a liberar: ");
                Liberar = EntrUs.nextLine();
                boolean LiberarPC = Obj.liberar(Liberar, Computadores);
                if(!LiberarPC){
                    System.out.println("Prestado: " + LiberarPC);
                }else{
                    System.out.println("Error "+LiberarPC);
                }
            }
            if(Entrada.equalsIgnoreCase("5")){
                System.out.print("ID de PC a buscar: ");
                Buscar = EntrUs.nextLong();
                Obj.cambiarEstado(Buscar,Computadores);
            }
        } while(true);

    }
}
