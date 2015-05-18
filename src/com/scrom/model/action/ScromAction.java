package com.scrom.model.action;

import com.scrom.model.card.Card;

import java.io.Serializable;

/**
 * Created by jeppe on 09-04-15.
 */
public abstract class ScromAction implements Serializable {
    private final String PLAYER_ID;
    private final Object SUBJECT;

    protected ScromAction(String player_id, Object sub) {
        PLAYER_ID = player_id;
        SUBJECT = sub;
    }

    public String getPlayerId() {
        return PLAYER_ID;
    }

    public Object getSubject() {
        return SUBJECT;
    }
}
