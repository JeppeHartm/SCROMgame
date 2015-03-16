package com.scrom.model.card;

import com.scrom.model.card.event.EventCard;
import com.scrom.model.card.interfaces.Immediate;

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


}
class SampleEventCard extends EventCard implements Immediate{

}