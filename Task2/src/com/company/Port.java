package com.company;

import java.util.LinkedList;

public class Port {
    private static final int MAXCAPACITY = 3; // СТАТИК ДЛЯ ВСЕХ КОРАБЛЕЙ, ФАЙНЕЛ , ЧТОБЫ НЕ МОГЛИ ИЗМЕНИТЬ
    //КОЛ-ВО КОРАБЛЕЙ В порту
    private Object notifier;//объект открывает поток
    private String name;// имя порта
    private LinkedList<Ship> ships;// коллекция кораблей в порту

    public Port(String name){
        this.name = name;
        this.notifier = new Object();
        this.ships = new LinkedList<>();
    }

    public Object getNotifier (){
        return notifier;
    }

    public void putShip (Ship ship)throws Exception {
        if (ships.size() == MAXCAPACITY) {
            throw new Exception("port is filled up");
        }
        ships.add(ship);

        Thread t = new Thread(() -> {
            try {
                ship.unloading();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ships.remove(ship);
        });
    }
    }
