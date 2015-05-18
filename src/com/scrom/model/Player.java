package com.scrom.model;

import com.scrom.model.card.Card;
import com.scrom.model.card.asset.AssetCard;
import com.scrom.model.card.event.EventCard;

import java.util.ArrayList;

/**
 * Created by jeppe on 26-02-15.
 */
public class Player {
    private int level;
    private int swiftness;
    private int capacity;

    ArrayList<Card> hand;
    ArrayList<Card> affecting;
    ArrayList<Player> opponents;
    SCROM scrom;
    private final String ID;

    public Player(SCROM s, String id){
        ID = id;
        hand = new ArrayList<>();
        affecting = new ArrayList<>();
        opponents = new ArrayList<>();
        scrom = s;
    }
    public void setOpponents(ArrayList<Player> players){
        this.opponents.addAll(players);
    }
    public ArrayList<Player> getOpponents(){
        return opponents;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int i){
        level = i;
    }

    public void give(Card c) {
        hand.add(c);
    }

    public String getID() {
        return ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSwiftness() {
        return swiftness;
    }

    public void setSwiftness(int swiftness) {
        this.swiftness = swiftness;
    }
    public void playCard(Card card) {
        for(Card c : hand){
            if(c == card){
                hand.remove(c);
                scrom.play(this,c);
                return;
            }
        }
    }
}
