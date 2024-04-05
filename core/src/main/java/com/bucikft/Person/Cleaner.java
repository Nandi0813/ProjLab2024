package com.bucikft.Person;

import com.bucikft.Room;

/*
 * A szobák befogadóképessége rá is érvényes.
 * Ha belép egy szobába, minden mozogni képes (nem bénult / ájult) embert kitessékel onnan.
 * Ha gázos szobába lép, kiszellőztet, megszüntetve a szoba gázosságát.
 * A szobák a takarítást követően adott számú látogató után ragacsossá válnak:
 * a bennük lévő és bennük letett tárgyakat nem lehet felvenni.
 */
public class Cleaner extends Person {

    @Override
    public void move(Room room) {

    }

}
