package com.bucikft;

public class TestClass {

    /**
     * Makes a test.
     * @param path The path to the test.
     * @param in The input for the test.
     * @param game The game to make the test for.
     */
    public void MakeTest(String path, String in, Game game){
        game.getProtoTest().MapLoad(path, true, in);
        game.getProtoTest().filePath = in;
        game.getProtoTest().setFilepath(in);
    }

}