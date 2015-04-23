package com.scrom.model.action;

import com.scrom.model.card.Card;

/**
 * Created by jeppe on 09-04-15.
 */
public class PlayerAction extends ScromAction {
    public enum ActionType{CardPlayed,Intervened}
    private final ActionType ACTION_TYPE;
    private final String PLAYER_ID;
    private final Card CARD;
    public PlayerAction(ActionType action_type, String player_id, Card card) {
        ACTION_TYPE = action_type;
        PLAYER_ID = player_id;
        CARD = card;
    }
}
