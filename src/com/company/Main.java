package com.company;

import java.util.*;

public class Main {
    private final Character PLAYER = 'W';
    private final Character AI = 'B';
    private Node[][] playField2;
    private List<Node> playAblePositions = new ArrayList<> ();
    private boolean isPlaying = false;
    private Scanner input = new Scanner ( System.in );

    public static void main (String[] args) {
        // write your code here
        Main m = new Main ();
        m.addEmptySpots ();
        m.setUp ();
        m.run ();
    }

    private void run () {
        System.out.println ( "Do you want to play Othello?" );
        String reply;//= input.nextLine ();
        reply = "Yes";
        if (reply.equalsIgnoreCase ( "Yes" ))
            playGame ();
        else
            System.out.println ( "Next time maybe" );
    }


    private void playGame () {
        boolean moveAccepted = false;
        int xAxis;
        int yAxis;
        Map<String, Node> possiblePlays = new HashMap<> ();
        do {
            System.out.println ( "Where do you want to put your move?" );
            int chosenPos = calcChosenPosition();

            if (!moveAccepted) {
                System.out.println ( "e" );
            }
        } while (!moveAccepted);
        //playField.get ( xAxis ).set ( yAxis, new Node ( 'W', true ) );
        int i = 7;
        printStacks ();
        //playGame ();
    }

    private int calcChosenPosition () {
        final int NUMBEROFCOLUMNS = 8;
        System.out.println ( "X value: " );
        int xAxis = getMove ();
        System.out.println ( "Y value: " );
        int yAxis = getMove ();

        int pos = yAxis*NUMBEROFCOLUMNS+xAxis;

        if(!moveIsAccepted(pos)){
            return calcChosenPosition ();
        }
        return 0;
    }

    private boolean moveIsAccepted (int pos) {
        //Check if number is correct.
        if (!(-1 < pos && pos <63)) {
            return false;
        }
        //Check if there are nearby bricks layed by the opponent
        //pos±1 brick to the right and left 2
        //pos±8 up and down 2
        //pos±8 && ±1 is the bricks to the diagonal 4

        return true;
    }


    private int getMove () {
        String s = input.nextLine ();
        try {
            return Integer.parseInt ( s );
        } catch (NumberFormatException e) {
            System.out.println ( "You need to type in a number" );
            return getMove ();
        }
    }

    private void addEmptySpots () {
        final int PLAYFIELDSIZE = 8 * 8;
        for (int i = 0; i < PLAYFIELDSIZE; i++) {
            playField.add ( new Node ( Node.Brick.NOTPLAYED) );
        }
    }

    private void setUp () {
        playField.get ( 27 ).setPlayedBy ( true );
        playField.get ( 28 ).setPlayedBy ( false );
        playField.get ( 35 ).setPlayedBy ( false );
        playField.get ( 36 ).setPlayedBy ( true );
        printStacks ();
    }

    private void printStacks () {
        System.out.println ( "   " + "\t" + 0 + "\t" + 1 + "\t" + 2 + "\t" + 3 + "\t" + 4 + "\t" + 5 + "\t" + 6 + "\t" + 7 );
        int column = 1;
        int row = 2;
        String s = row+"";
        for (Node n : playField) {
            if (column < 8) {
                s = n.toString ();
            } else {
                s = n.toString () + "\n" + row;
                column = 0;
                row++;
            }
            column++;
            System.out.print ( "\t" + s );
        }
    }
}
