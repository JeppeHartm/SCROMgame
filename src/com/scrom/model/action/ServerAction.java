package com.scrom.model.action;

/**
 * Created by jeppe on 09-04-15.
 */
public class ServerAction extends ScromAction {
    private int actionType;

    public int getActionType() {
        return actionType;
    }

    public enum ActionType{CardPlayed,CardDealt}
}
