package com.scrom.model.card;

import com.scrom.model.Player;

import java.io.Serializable;

/**
 * Created by jeppe on 26-02-15.
 */
public abstract class Card implements Serializable {
    // Graphic, Description
    public abstract void apply(Player p);
    public abstract void remove(Player p);

}
