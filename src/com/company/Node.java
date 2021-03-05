package com.company;

public class Node {
    private Brick status;

    public Node (Brick s) {
        status = s;
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

    @Override
    public String toString () {
        return "|"+status+"|";
    }
}
