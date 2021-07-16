package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class MyTread extends Thread {
    public MyTread (String name,FileWriter fw){
        super(() -> {                    // super вызывает конструктор родительского класса
            synchronized (fw){
                try {
                    fw.append(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    },name);

    }
}
