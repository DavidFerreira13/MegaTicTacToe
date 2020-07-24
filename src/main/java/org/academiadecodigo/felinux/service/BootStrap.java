package org.academiadecodigo.felinux.service;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.felinux.mvc.model.Server;

import java.io.IOException;

public class BootStrap {

    public static void init(){

        try {

            //Todo passar isto pra ServerStartService ou merda assim

            Prompt serverPrompt = new Prompt(System.in, System.out);

            IntegerRangeInputScanner portScanner = new IntegerRangeInputScanner(0,16000);
            portScanner.setMessage("Insert a port number to initialize the server\n");
            portScanner.setError("A valid one thx\n");
            int port = serverPrompt.getUserInput(portScanner);

            Server server = new Server(port);
            server.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}