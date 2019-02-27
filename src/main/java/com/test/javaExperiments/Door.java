package com.test.javaExperiments;

public class Door{
    boolean grandPrize;
    boolean opened;

    public void openDoor(){
        opened = true;
        if(grandPrize){
            System.out.println("Grand prize!\n");
        }
        else{
            System.out.println("Booby prize.\n");
        }
    }
}