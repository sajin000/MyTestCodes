package com.test.javaExperiments;

import java.io.*;


public class TestMontyHall{
    private static MakeADeal  deal;

    /**
     * Utilty for command line arguments
     * @return none
     */
    private static String readInput(){
        String inputLine = "";
        try{
            InputStreamReader inStream = new InputStreamReader(System.in);
            BufferedReader inBuffer = new BufferedReader(inStream);
            inputLine = inBuffer.readLine();
        }
        catch(IOException e){ System.out.println(e); }
        return inputLine;
    }

    //utility method to println...
    private static void p(String s){
        System.out.println(s);
    }

    /**
     *
     * @param s
     * @return
     */
    private static boolean validDoor(String s){
        int i;
        try{
            i = Integer.parseInt(s);
            if( (i<0) || (i>deal.doorQty) || (deal.doorNum[i-1].opened) ){
                throw new Exception();
            }
            else{
                deal.playersDoor = i;
                return true;
            }
        }
        catch(Exception e){
            //input was not valid (not an int, out of range, or already open)...
            p("MONTY: Sorry, you need to pick a closed door, 1 through " + deal.doorQty + ".");
            return false;
        }
    }

    //dramatic effect...
   private static void callPause(){
        class Pause extends Thread{
            public void run(){
                try{ sleep(1700); }
                catch(InterruptedException e){}
            }
        }
        new Pause().run();
    }

    /**
     * Dialogue
     */
    private static void montyGo(){
        p("\nMONTY: Welcome to Let's Make a Deal!");
        callPause();
        p("MONTY: Pick a door, 1 through " + deal.doorQty + ".");
        System.out.print("YOU: ");
        while(!validDoor(readInput())){
            System.out.print("YOU: ");
        }
        p("MONTY: You've picked door number " + deal.playersDoor + ".");
        callPause();
        p("MONTY: Whatever's behind that door is yours.");
        callPause();
        p("MONTY: So first let's see what's behind a door you DIDN'T pick...");
        callPause();
        deal.showBooby();
        callPause();
        p("MONTY: Now, you own whatever's behind door number " + deal.playersDoor + ".");
        callPause();
        p("MONTY: And you've just seen what's behind one of the other doors...");
        callPause();
        p("MONTY: So would you like to change doors now?");
        System.out.print("YOU: ");
        char c = readInput().charAt(0);
        if( (c=='Y') || (c=='y') || (c=='1') ){
            p("MONTY: Which door would you like instead?");
            System.out.print("YOU: ");
            while(!validDoor(readInput())){
                System.out.print("YOU: ");
            }
        }
        p("MONTY: Okay, you've got door number " + deal.playersDoor + ".");
        callPause();
        p("MONTY: Let's see what you've won...");
        callPause();
        System.out.print("\n>> Behind door number " + deal.playersDoor + " is: ");
        deal.doorNum[deal.playersDoor-1].openDoor();
        callPause();
        if(deal.doorNum[deal.playersDoor-1].grandPrize){
            p("MONTY: Congratulations!!!");
        }
        else{
            p("MONTY: Oh, I'm so sorry.");
        }
    }
    public static void main(String[] args){
        int input = 3;
        deal = new MakeADeal(input);
        montyGo();
    }
}
