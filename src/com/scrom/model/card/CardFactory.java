package com.scrom.model.card;

import com.scrom.model.Player;
import com.scrom.model.card.asset.AssetCard;
import com.scrom.model.card.event.EmergencyEventCard;
import com.scrom.model.card.event.EncounterEventCard;
import com.scrom.model.card.event.EventCard;

import java.util.ArrayList;

/**
 * Created by jeppe on 26-02-15.
 */
public class CardFactory {
    private static CardFactory ourInstance = new CardFactory();

    public static CardFactory getInstance() {
        return ourInstance;
    }

    private CardFactory() {
    }
    public static ArrayList<Card> getDeck(){
        EventCard d = new SampleEmergencyCard();
        ArrayList<Card> o = new ArrayList<Card>();
        o.add(d);
        return o;
    }


    public static ArrayList<EventCard> getEventCards() {
        return null;
    }

    public static ArrayList<AssetCard> getAssetCards() {
        return null;
    }
}
class SampleEmergencyCard extends EmergencyEventCard {
    private int mod;
    @Override
    public void apply(Player p) {
        mod = p.getLevel();
        p.setLevel(0);
    }

    @Override
    public void remove(Player p) {
        int l = p.getLevel();
        p.setLevel(l + mod);
    }
}
class SampleEncounterCard extends EncounterEventCard {


    @Override
    public void apply(Player p) {

    }

    @Override
    public void remove(Player p) {

    }

    @Override
    public int getLevel() {
        return 0;
    }
}