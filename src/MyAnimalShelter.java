import controll.Controller;

// MyAnimalShelter is a project as part of training as a developer at GFN AG, Germany

// I have done my own design on this programm
// much of methods are rewritten by myself (e.g.: my custom messages)
// develloped by M. Gießler on Dec 2019

// NOTE that you need a local Mongo DB (https://www.mongodb.com/) to start the programm !!!

public abstract class MyAnimalShelter {

    // starting the entire programm
    public static void main(String[] args) {
        Controller.getInstance();
    }
}
