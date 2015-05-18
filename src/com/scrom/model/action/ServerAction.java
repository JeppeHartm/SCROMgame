package com.scrom.model.action;

import com.scrom.model.SCROM;
import com.scrom.model.card.Card;

/**
 * Created by jeppe on 09-04-15.
 */
public class ServerAction extends ScromAction {
    public enum ActionType{CardPlayed,CardDealt,Initialize}

    private ActionType actionType;

    public ServerAction(String player_id,Object sub) {
        super(player_id, sub);
    }

    public ActionType getActionType() {
        return actionType;
    }


}
