package com.scrom.model.action;

import com.scrom.model.card.Card;

import java.io.Serializable;

/**
 * Created by jeppe on 09-04-15.
 */
public abstract class ScromAction implements Serializable {
    private final String PLAYER_ID;
    private final Card CARD;

    protected ScromAction(String player_id, Card card) {
        PLAYER_ID = player_id;
        CARD = card;
    }

    public String getPlayerId() {
        return PLAYER_ID;
    }

    public Card getCard() {
        return CARD;
    }
}
