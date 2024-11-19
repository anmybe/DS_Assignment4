package com.assignment4.tasks;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// This Class handles the continuous listening for incoming messages from the server
public class LTClientThread implements Runnable {

  private final DatagramSocket clientSocket;
  private final LamportTimestamp lc;

  byte[] receiveData = new byte[1024];

  public LTClientThread(DatagramSocket clientSocket, LamportTimestamp lc) {
    this.clientSocket = clientSocket;
    this.lc = lc;
  }

  @Override
  public void run() {
    // TODO:
    // Write your code here to continuously listen for incoming messages from the server and display them.
    System.out.println("Client 3: Hello World!:1");

    // TODO:
    // Update the clock based on the timestamp received from the server.
    System.out.println("Current clock: 2");
  }
}