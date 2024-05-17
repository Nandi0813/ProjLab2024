package com.bucikft.Controllers;

public class Tile {
    private TileType type;
    private Object ref;
    public Tile (TileType type, Object o) {
        this.type=type;
        this.ref = o;
    }

    public TileType getType() {
        return type;
    }
    public Object getRef() {return ref;}
}
