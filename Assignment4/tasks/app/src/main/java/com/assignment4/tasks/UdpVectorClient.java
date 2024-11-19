package com.assignment4.tasks;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpVectorClient {

  public static void main(String[] args) throws Exception {
    // Prompt the user to enter their unique ID (1 to 4)
    System.out.println("Enter your id (1 to 4): ");
    Scanner idInput = new Scanner(System.in);
    int id = idInput.nextInt(); // Read the user ID
    
    // Prepare a client socket with a dynamically assigned port
    DatagramSocket clientSocket = new DatagramSocket(); // OS assigns the port
    InetAddress ipAddress = InetAddress.getByName("localhost"); // Server's IP address
    int port = 4040; // Server's fixed port for communication

    // Initialize the vector clock for 4 clients
    VectorClock vcl = new VectorClock(4);
    vcl.setVectorClock(id - 1, 0); // Set initial timestamp for this client

    // Start a thread to continuously listen for incoming messages from the server
    VectorClientThread clientReceiver = new VectorClientThread(clientSocket, vcl, id);
    Thread receiverThread = new Thread(clientReceiver);
    receiverThread.start();

    // TODO:
    // Send an initial "join" message to notify the other clients that a new one has connected
    // This should not be counted as a message event, so the clock should not tick

    String joinMessage = "message:timestamp:id";

    // Prompt the user to start entering messages
    System.out.println("[" + id + "] Enter any message:");
    Scanner input = new Scanner(System.in);

    while (true) {
      String messageBody = input.nextLine(); // Read user input

      if (!messageBody.isEmpty()) {
        if (messageBody.equalsIgnoreCase("quit")) {
          // Gracefully exit the application
          clientSocket.close(); // Close the socket
          receiverThread.interrupt(); // Stop the receiver thread
          System.exit(0); // Exit the program
        }
        
        // TODO:
        // Increment the vector clock for the client's process
        // The clock should NOT tick if the message to send is "history" (for Task 2.2)
        
        // TODO:
        // Prepare the message with the updated vector clock and client ID and send it to the server
        String responseMessage = "message:timestamp:id";
        System.out.println("Sent message: " + responseMessage);
        System.out.println("Current clock: " + vcl.showClock());
      }
    }
  }
}
