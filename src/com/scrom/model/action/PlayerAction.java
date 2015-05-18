package com.scrom.model.action;

import com.scrom.model.card.Card;

/**
 * Created by jeppe on 09-04-15.
 */
public class PlayerAction extends ScromAction {
    public enum ActionType{CardPlayed}
    private final ActionType ACTION_TYPE;

    public ActionType getActionType() {
        return ACTION_TYPE;
    }

    public PlayerAction(ActionType action_type, String player_id, Card card) {
        super(player_id, card);
        ACTION_TYPE = action_type;
    }
}
