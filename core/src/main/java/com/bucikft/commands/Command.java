package com.bucikft.commands;

import com.bucikft.Game;

public interface Command {
    void execute(Game game, String[] args);
}
