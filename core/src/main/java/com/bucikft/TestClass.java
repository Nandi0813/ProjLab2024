package com.bucikft;

public class TestClass {

    public void MakeTest(String path, String in, Game game){
        game.getProtoTest().MapLoad(path, true, in);
        game.getProtoTest().filePath = in;
        game.getProtoTest().setFilepath(in);
        System.out.println(game.isStarted());
    }
}
