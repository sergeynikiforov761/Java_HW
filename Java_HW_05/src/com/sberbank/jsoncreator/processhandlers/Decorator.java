package com.sberbank.jsoncreator.processhandlers;

public class Decorator implements ProcessHandler {

    private ProcessHandler processHandler;

    public Decorator(ProcessHandler processHandler) {
        this.processHandler = processHandler;
    }

    public String generateString() throws IllegalAccessException {
        return processHandler.generateString();
    }
}
