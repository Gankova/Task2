package com.company;


import java.util.ArrayList;
import java.util.Stack;

public class Tunnel {
    /*private ArrayList<Ship> ships; // коллекция хранит корабли
    public Tunnel(){
        this.ships = new ArrayList<>();
    }
    public Ship getNextShip(){
        return this.ships.get();
    }*/
    private Stack<Ship> ships; // коллекция хранит корабли

    private static final int MAXCAPACITY = 5; // СТАТИК ДЛЯ ВСЕХ КОРАБЛЕЙ, ФАЙНЕЛ , ЧТОБЫ НЕ МОГЛИ ИЗМЕНИТЬ
    //КОЛ-ВО КОРАБЛЕЙ В ТОННЕЛЕ

    public Tunnel(){
        this.ships = new Stack<>();
    }
    public Ship getNextShip() {
        return this.ships.peek(); // возвращает нижний элемент Speek
    }

    public void putShip (Ship ship) throws Exception {// метод добавляет корабль в тонель
        if (ships.size() == MAXCAPACITY){
            throw new Exception("tunnel is fiiled up");// если в тоннеле 5 кораблей не добавлять
        }

        ships.push(ship);

    }
}
