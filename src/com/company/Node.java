package com.company;

public class Node {
    private Character playedBy;
    private boolean isPlayed = false;

    public Node (Character playedBy, boolean isPlayed) {
        this.playedBy = playedBy;
        this.isPlayed = isPlayed;
    }

    public boolean isPlayed () {
        return isPlayed;
    }

    public void setPlayedBy (boolean playedByPlayer) {
        if (playedByPlayer) {
            this.playedBy = 'W';
        }
        else {
            this.playedBy = 'B';
        }
        isPlayed = true;
    }

    @Override
    public String toString () {
        return playedBy.toString ();
    }
}
