package com.scrom.model;

import com.scrom.model.card.Card;
import com.scrom.model.card.CardFactory;
import com.scrom.model.card.event.EventCard;
import com.scrom.model.card.asset.AssetCard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class SCROM {
    int turnNumber = 0;
    Player current;
    ArrayList<Player> players;
    ArrayList<EventCard> eventCards;
    ArrayList<EventCard> eventCardDiscards;
    ArrayList<AssetCard> assetCards;
    ArrayList<AssetCard> assetCardDiscards;

    private void pregame(){
        initialize();
        dealCards();
    }
    private void preturn(){
        checkWin();
        checkAssets();
        checkEvents();
        turnNumber++;
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
            //do win stuff
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
}
