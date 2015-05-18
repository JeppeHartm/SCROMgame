package com.scrom.model.action;

import com.scrom.model.card.Card;

/**
 * Created by jeppe on 09-04-15.
 */
public class ServerAction extends ScromAction {
    public enum ActionType{CardPlayed,CardDealt}
    private ActionType actionType;

    public ServerAction(String player_id,Card card) {
        super(player_id, card);
    }

    public ActionType getActionType() {
        return actionType;
    }


}
