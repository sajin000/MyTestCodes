package com.test.javaExperiments;


public class MakeADeal{
    Door[] doorNum;
    int doorQty;
    int prizeDoor;
    int playersDoor;

    MakeADeal(int doors){
        //make an Array of Doors...
        doorQty = doors;
        doorNum = new Door[doorQty];
        for(int i=0; i<doorQty; i++){
            doorNum[i] = new Door();
        }
        //pick one of the Doors to be the prizeDoor...
        prizeDoor = (int)(Math.random() * doorQty);
        doorNum[prizeDoor].grandPrize = true;
    }

    void showBooby(){
        //open a Door that isn't already open, is not the player's choice,
        //and is not the prizeDoor...
        int pick = prizeDoor;
        while( (doorNum[pick].opened == true) ||
                (pick == (playersDoor-1)) ||
                (pick == prizeDoor) ){
            pick = (int)(Math.random() * doorQty);
        }
        System.out.print("\n>> Behind door number " + (pick+1) + " is: ");
        doorNum[pick].openDoor();
    }
}

