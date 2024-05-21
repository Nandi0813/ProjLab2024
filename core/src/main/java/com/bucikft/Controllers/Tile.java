package com.bucikft.Controllers;

/**
 * The type Tile.
 */
public class Tile {
    private TileType type;
    private Object ref;

    /**
     * Instantiates a new Tile.
     *
     * @param type the type
     * @param o    the o
     */
    public Tile (TileType type, Object o) {
        this.type=type;
        this.ref = o;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TileType getType() {
        return type;
    }

    /**
     * Gets ref.
     *
     * @return the ref
     */
    public Object getRef() {return ref;}
}
