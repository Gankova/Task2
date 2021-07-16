package com.company;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //
        FileWriter fw = new FileWriter("1.txt");// создаем файл
        Thread t = new Thread(() -> {
            synchronized (fw){// синхронизируем поток по объекту файл
                try {
                    fw.append("T1");//записывает в файл Т1
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (fw){// синхронизируем поток по объекту файл
                try {
                    fw.append("T2");//записывает в файл Т1
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //fw.close(); // закрываем поток записи
        // второй вариант

        Random r = new Random();
        System.out.println(r.nextInt(12)); //любое число от 0 до 12, 12 не включают
        String s = "# &*&*/";
        char c = s.charAt(r.nextInt(s.length()));

                //разделить на две часть Т1Т2

        MyTread t1 = new MyTread("T1",fw);
        MyTread t3 = new MyTread("Т2", fw);
        t1.start();
        t3.start();
        t1.join();
        t3.join();
        fw.close();


    }
}
