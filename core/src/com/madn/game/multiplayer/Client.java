package com.madn.game.multiplayer;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Philipp on 05.04.17.
 */

public class Client extends Thread {

    private Socket clientSocket;
    private String playerName;
    private boolean connected;

    private BufferedReader bReader;
    private PrintWriter pWriter;

    public Client(String ip, int port) {
        try {
          clientSocket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        connected = true;
        SocketAddress s = clientSocket.getRemoteSocketAddress();
        try {
            pWriter = new PrintWriter(clientSocket.getOutputStream());
            bReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sendString(playerName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (connected) {

        }
    }

    public Client(Socket clientSocket) {
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

    public boolean isConnected() {
        return clientSocket.isConnected();
    }

    public void sendString(String msg){
        pWriter.write(msg);
        pWriter.flush();
    }

    public BufferedReader getBufferedReader(){
        return bReader;
    }

    public PrintWriter getPrintWriter(){
        return pWriter;
    }


}
