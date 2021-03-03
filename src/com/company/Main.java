package com.company;

import java.util.*;

public class Main {
    private final Character PLAYER = 'W';
    private final Character AI = 'B';
    private Map<Integer, List<Node>> playField = new HashMap<> ();
    private List<Node> c1 = new ArrayList<> ();
    private List<Node> c2 = new ArrayList<> ();
    private List<Node> c3 = new ArrayList<> ();
    private List<Node> c4 = new ArrayList<> ();
    private List<Node> c5 = new ArrayList<> ();
    private List<Node> c6 = new ArrayList<> ();
    private List<Node> c7 = new ArrayList<> ();
    private List<Node> c8 = new ArrayList<> ();
    private boolean isPlaying = false;
    private Scanner input = new Scanner ( System.in );

    public static void main (String[] args) {
        // write your code here
        Main m = new Main ();
        m.addEmptySpots();
        m.setUp ();
        m.run();
    }

    private void run () {
        System.out.println ("Do you want to play Othello?");
        String reply;//= input.nextLine ();
        reply = "Yes";
        if(reply.equalsIgnoreCase ( "Yes" ))
            playGame();
        else
            System.out.println ("Next time maybe");
    }


    private void playGame () {
        boolean moveAccepted = false;
        int xAxis;
        int yAxis;
        Map<String, Node> possiblePlays = new HashMap<> ();
        do {
            System.out.println ( "Where do you want to put your move?" );
            System.out.println ("X value: ");
            xAxis = getMove ();
            System.out.println ("Y value: ");
            yAxis = getMove ();

            if(0 < xAxis && xAxis < 9 && -1 < yAxis && yAxis < 9){
                if(!playField.get ( xAxis ).get ( yAxis ).isPlayed ()) moveAccepted = true;
            }
            if(!moveAccepted){
                System.out.println ("e");
            }
        }while (!moveAccepted);
        playField.get ( xAxis ).set ( yAxis, new Node ( 'W', true ) );
        int i = 7;
        printStacks ();

        //playGame ();
    }


    private int getMove () {
        String s = input.nextLine ();
        try{
            return Integer.parseInt ( s );
        } catch (NumberFormatException e){
            System.out.println ("You need to type in a number");
            return getMove ();
        }
    }

    private void addEmptySpots () {
        Node n = new Node ( '-', false );
        for(int i = 0 ; i < 8; i++){
            c1.add ( n );
            c2.add ( n );
            c3.add ( n );
            c4.add ( n );
            c5.add ( n );
            c6.add ( n );
            c7.add ( n );
            c8.add ( n );
        }
        playField.put ( 1, c1 );
        playField.put ( 2, c2 );
        playField.put ( 3, c3 );
        playField.put ( 4, c4 );
        playField.put ( 5, c5 );
        playField.put ( 6, c6 );
        playField.put ( 7, c7 );
        playField.put ( 8, c8 );
    }

    private void setUp () {
        c4.set (3, new Node ( PLAYER, true) );
        c4.set (4, new Node ( AI, true ) );
        c5.set (3, new Node ( AI, true ) );
        c5.set (4, new Node ( PLAYER, true ) );
        printStacks ();
    }

    private void printStacks () {
        System.out.println ("\t"+0+" , "+1+" ,"+2+", "+3+", "+4+", "+5+" ,"+6+" ,"+7);
        System.out.println ("1"+"\t"+playField.get ( 1 ).toString ());
        System.out.println ("2"+"\t"+playField.get ( 2 ).toString ());
        System.out.println ("3"+"\t"+playField.get ( 3 ).toString ());
        System.out.println ("4"+"\t"+playField.get ( 4 ).toString ());
        System.out.println ("5"+"\t"+playField.get ( 5 ).toString ());
        System.out.println ("6"+"\t"+playField.get ( 6 ).toString ());
        System.out.println ("7"+"\t"+playField.get ( 7 ).toString ());
        System.out.println ("8"+"\t"+playField.get ( 8 ).toString ());
    }
}
