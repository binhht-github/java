package com.example.learn_oop.supper;

public class Bike extends Vehicle{
    int speed=100;

    public void display(){
        System.out.println("mess supper "+super.speed); //bay gio se in speed cua Vehicle
    }
    public Bike(int speed){
        messVehicle();
//        super();
//        this.speed = speed;
//        System.out.println(speed);
//        super.messVehicle();
//        System.out.println("contructor bike ddwcoj tao");
    }
}
