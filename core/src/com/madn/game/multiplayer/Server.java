package com.madn.game.multiplayer;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Philipp on 03.04.17.
 */

public class Server extends Thread {

    private static Server instance;
    private final String TAG = "Server";
    private ServerSocket serverSocket;
    private int port;
    private String ip;
    private Client[] clients = new Client[3];
    private int maxPlayer = 3;
    private int joinedPlayers = 1; //da Server ja auch ein Spieler ist


    private Server() {
        try {
            serverSocket = new ServerSocket(0);
            this.port = serverSocket.getLocalPort();
            this.ip = getLocalIpAddress();
            Gdx.app.log("Server", "start");


            start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Gibt den momentanen Server zurück oder wenn dieser nicht besteht wird ein neuer angelegt.
    public static synchronized Server getInstance() {
        if (Server.instance == null) {
            Server.instance = new Server();
        }
        return Server.instance;
    }

    @Override
    public void run() {
        while (joinedPlayers < maxPlayer && !serverSocket.isClosed()) {
            try {
                Socket clientSocket = null;
                clientSocket = serverSocket.accept();

                if (clientSocket != null) {
                    clients[joinedPlayers] = new Client(clientSocket);
                    SocketAddress d = clientSocket.getRemoteSocketAddress();
                    clients[joinedPlayers].start();
                /*    String name = "";
                    while(name == ""){
                        Gdx.app.log("SERVER", "NAME "+name);
                        name =  clients[joinedPlayers].getBufferedReader().readLine();
                    }
                    clients[joinedPlayers].setPlayerName(name); */
                    joinedPlayers++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        while (!serverSocket.isClosed()) {
            //Do something with the clients
        }
    }

    public void shutdown() {
        try {
            instance = null;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getJoinedPlayers() {
        return joinedPlayers;
    }

    public void setJoinedPlayers(int joinedPlayers) {
        this.joinedPlayers = joinedPlayers;
    }

    public Client[] getClients() {
        return clients;
    }


    public String getLocalIpAddress() {
        Enumeration<NetworkInterface> nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();

            NetworkInterface ni;
            while (nis.hasMoreElements()) {
                ni = nis.nextElement();
                if (!ni.isLoopback() && ni.isUp()) {
                    for (InterfaceAddress ia : ni.getInterfaceAddresses()) {
                        //filter for ipv4/ipv6
                        if (ia.getAddress().getAddress().length == 4) {
                            //4 for ipv4, 16 for ipv6
                            return ia.getAddress().getHostAddress().toString();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Client getClient(int number) {
        if (number < 0 || number > 3) {
            return null;
        }
        return clients[number];
    }

}
