package com.bucikft.Items.Interface;

/**
 * Nincs az eredeti tárgyra jellemző jó tulajdonsága.
 * Például a hamis logarléc felvételével nem lehet nyerni.
 * <p>
 * When an item is generated that may or may not be fake, you must specify in its construction whether it will be fake or not
 */
public interface FalseItem {

    boolean isFalse();

}
