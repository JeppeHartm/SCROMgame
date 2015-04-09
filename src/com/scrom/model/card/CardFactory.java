package com.scrom.model.card;

import com.scrom.model.card.asset.AssetCard;
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
        EventCard d = new SampleEventCard();
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
class SampleEventCard extends EventCard{

}