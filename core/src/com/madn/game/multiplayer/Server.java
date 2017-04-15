package com.madn.game.multiplayer;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Philipp on 03.04.17.
 */

public class Server extends Thread {

    private final String TAG ="Server";

    private ServerSocket serverSocket;
    private int port;
    private InetAddress ip;
    public Client [] clients = new Client[3];
    private static Server instance;
    private int maxPlayer = 3;
    private int joinedPlayers = 1; //da Server ja auch ein Spieler ist


    //Gibt den momentanen Server zurück oder wenn dieser nicht besteht wird ein neuer angelegt.
    public static synchronized Server getInstance(){
        if(Server.instance ==  null){
            Server.instance = new Server();
        }
        return Server.instance;
    }

    private Server(){
        try {
            serverSocket = new ServerSocket(0);
            this.port = serverSocket.getLocalPort();
            this.ip = serverSocket.getInetAddress();
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        System.out.println("Server starts "+port);
        while(joinedPlayers < maxPlayer) {
            try {
                Socket clientSocket = null;
                clientSocket = serverSocket.accept();
                if (clientSocket != null) {
                     clients[joinedPlayers] = new Client(clientSocket);
                     clients[joinedPlayers].start();
                    joinedPlayers++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while(true){
            //Do something with the clients
        }
    }



    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getJoinedPlayers() {
        return joinedPlayers;
    }

    public void setJoinedPlayers(int joinedPlayers) {
        this.joinedPlayers = joinedPlayers;
    }
}
