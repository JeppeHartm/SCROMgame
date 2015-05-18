package com.scrom.model;

import com.scrom.model.card.Card;
import com.scrom.model.card.CardFactory;
import com.scrom.model.card.event.EmergencyEventCard;
import com.scrom.model.card.event.EncounterEventCard;
import com.scrom.model.card.event.EventCard;
import com.scrom.model.card.asset.AssetCard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class SCROM {
    int turnNumber = 0;
    Player current;
    EventCard currentCard;
    ArrayList<Player> players;
    ArrayList<EventCard> eventCards;
    ArrayList<EventCard> eventCardDiscards;
    ArrayList<AssetCard> assetCards;
    ArrayList<AssetCard> assetCardDiscards;
    private GameState state;

    public void pregame(){
        initialize();
        dealCards();
    }
    public void preturn(){
        state = GameState.waiting;
        checkWin();
        checkAssets();
        checkEvents();
        turnNumber++;
        currentCard = eventCards.remove(0);
    }
    private void initialize(){
        eventCards = CardFactory.getEventCards();
        eventCardDiscards = new ArrayList<EventCard>();
        assetCards = CardFactory.getAssetCards();
        assetCardDiscards = new ArrayList<AssetCard>();
    }
    private void dealCards(){
        for(Player p : players){
            p.give(eventCards.remove(0));
            p.give(eventCards.remove(0));
            p.give(assetCards.remove(0));
            p.give(assetCards.remove(0));
        }
    }
    private void checkAssets(){
        if(assetCards.isEmpty()){
            assetCards.addAll((ArrayList<AssetCard>)shuffle(assetCardDiscards));
            assetCardDiscards.clear();
        }
    }
    private void checkEvents(){
        if(eventCards.isEmpty()){
            eventCards.addAll((ArrayList<EventCard>)shuffle(eventCardDiscards));
            eventCardDiscards.clear();
        }
    }
    private void checkWin(){
        ArrayList<Player> winners = new ArrayList<Player>();
        for(Player p:players){
            if(p.getLevel() >= 10)winners.add(p);
        }
        if(!winners.isEmpty()){
            state = GameState.complete;
        }
    }
    private ArrayList<? extends Card> shuffle(ArrayList<? extends Card> cards) {
        Random r = new Random();
        ArrayList<Card> output = new ArrayList<Card>();
        while (!cards.isEmpty()){
            output.add(cards.remove(r.nextInt(cards.size()-1)));
        }
        return output;
    }

    public Player getPlayer(String playerId) {
        for(Player p : players){
            if(p.getID() == playerId) return p;
        }
        return null;
    }
    public void addPlayer(String name){
        players.add(new Player(this,name));
    }

    public void play(Player p,Card c) {
        if(c instanceof AssetCard){
            c.apply(p);
            assetCardDiscards.add((AssetCard)c);
        }else if(c instanceof EventCard){
            c.apply(current);
            eventCardDiscards.add((EventCard)c);
        }

    }
    public void resolve(){
        EventCard ec = getCurrentCard();
        if(ec instanceof EncounterEventCard){
            EncounterEventCard eec = (EncounterEventCard) ec;
            if(getCurrent().getLevel() > eec.getLevel()){
                getCurrent().setLevel(getCurrent().getLevel()+1);
            }else{
                ec.apply(getCurrent());
            }
        }else if(ec instanceof EmergencyEventCard){
            ec.apply(getCurrent());
        }
    }
    public GameState getState() {
        return state;
    }

    public Player getCurrent() {
        return current;
    }

    public EventCard getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(EventCard currentCard) {
        if (this.currentCard != null) eventCardDiscards.add(this.currentCard);
        this.currentCard = currentCard;
    }

    public void setCurrent(Player current) {
        this.current = current;
    }

    public void incrementTurn() {
        turnNumber++;
    }

    public void setGameState(GameState gameState) {
        this.state = gameState;
    }

    public enum GameState {waiting,complete}
}
