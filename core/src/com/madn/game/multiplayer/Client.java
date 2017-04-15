package com.madn.game.multiplayer;

import java.net.Socket;

/**
 * Created by Philipp on 05.04.17.
 */

public class Client extends  Thread {

    private Socket clientSocket;
    private String playerName;


    @Override
    public void run(){
        System.out.println("Clients starts");
    }

    public Client (Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
