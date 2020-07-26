package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;

public class GameView extends AbstractView {

    private PlayerController controller;
    private StringInputScanner scanner;

    @Override
    public void show() {
        //System.out.println(" GameView show() "+scanner);
        String userInput = super.prompt.getUserInput(scanner);
        //System.out.println(userInput);
        controller.transmit(userInput);
    }

    public void setPrompt(Prompt prompt) {

        super.setPrompt(prompt);
    }

    public void setController(PlayerController controller) {

        this.controller = controller;
    }

    public void setMessage(String message) {

        if(scanner == null){
            scanner = new StringInputScanner();
            scanner.setError("That's not valid");
        }
        scanner.setMessage(message + "\n");
    }

    public void sendMessage(String message) {
        //System.out.println("GameView "+ message);
        System.out.println(super.getWriter().toString());
        super.getWriter().println(message);
    }
}
