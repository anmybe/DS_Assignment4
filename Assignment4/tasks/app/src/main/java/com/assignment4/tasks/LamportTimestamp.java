
package com.assignment4.tasks;


public class LamportTimestamp {
    private int timestamp;
    public LamportTimestamp(int time){

        timestamp = time;
    }
    public synchronized void tick(){

        // TODO: update the timestamp by 1
    }
    public synchronized int getCurrentTimestamp(){

        return timestamp;
    }
    public synchronized void updateClock(int receivedTimestamp){

        timestamp = receivedTimestamp; // TODO: update the function to choose max out of the two received timestamps
    }

}
