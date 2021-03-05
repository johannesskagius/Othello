package com.company;

public class Node {
    private String status;

    public Node (Brick s) {
        status = String.valueOf ( s );
    }

    public enum Brick{
        PLAYER("W"),
        COMPUTER("B"),
        NOTPLAYED("-");
        Brick (String s) {

        }


        @Override
        public String toString () {
            return super.toString ();
        }
    }

    public String getStatus () {
        return status;
    }

    @Override
    public String toString () {
        return "|"+status+"|";
    }
}
