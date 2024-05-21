package com.bucikft.Controllers;

import java.util.LinkedList;
import java.util.List;

public class OutputHandler {
    private static LinkedList<String> outputMessages = new LinkedList<>();

    public static void addOutputMessage(String msg) {
        outputMessages.addLast(msg);
        if (outputMessages.size()>5) {
            outputMessages.removeFirst();
        }
    }

    public static List<String> getOutputMessages() {
        return outputMessages;
    }
}
