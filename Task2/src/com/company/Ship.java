package com.company;

public class Ship {
    private int cargoWeigt;//грузоподьемность
    public Ship (int cargoWeigt){
        this.cargoWeigt = cargoWeigt;
    }
    public void unloading() throws InterruptedException {
        Thread.sleep(cargoWeigt);//поток ждет загрузку коробля в зависимости от грузоподъмности
    }
}
