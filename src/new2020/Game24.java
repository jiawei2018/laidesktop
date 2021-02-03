package new2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game24 {
    public static void main(String[] args) {
        int[] a = {1,3,4,6};

        Game24 t = new Game24();
        System.out.println(t.can24(a));
    }

    public boolean can24(int[] nums) {
        //nums contains 1 to 9
        List<Card> cards = new ArrayList<>();
        for (int num : nums) {
            cards.add(new Card(num, 1));
        }
        return recur(cards);
    }

    private boolean recur(List<Card> cards) {
        //System.out.println(cards);
        if(cards.size() == 1){
            if(cards.get(0).top == 24 ||
                    cards.get(0).top == 48 ||
                    cards.get(0).top == 72 ||
                    cards.get(0).top == 96 ){
                System.out.println(cards);
            }


            return cards.get(0).getValue() == 24;
        }

        for(int i = 0; i < cards.size(); i++) {
            for(int j = 0; j < cards.size(); j++){
                if(j == i) continue; //?
                List<Card> nc = new ArrayList<>();
                for(int k = 0; k < cards.size(); k++){
                    if(k != i && k != j){
                        nc.add(cards.get(k));
                    }
                }

                for(int op = 1; op < 5; op++){
                    nc.add(merge(cards.get(i), cards.get(j), op));
                    if(recur(nc)){
                        return true;
                    }
                    nc.remove(nc.size() - 1);//bug here
                }
            }
        }
        return false;
    }


    private Card merge(Card a, Card b, int op) {
        Card res = new Card(0, 0);
        if (op == 1) { //+
            res.top = a.top * b.bot + b.top * a.bot;
            res.bot = a.bot * b.bot;
        } else if (op == 2) {//-
            res.top = a.top * b.bot - b.top * a.bot;
            res.bot = a.bot * b.bot;
        } else if (op == 3) { // *
            res.top = a.top * b.top;
            res.bot = a.bot * b.bot;
        } else if (op == 4) { // '/'
            res.top = a.top * b.bot;
            res.bot = a.bot * b.top;
        } else {
            throw new RuntimeException(" no such operator!");
        }
        return res;
    }


    class Card {
        int top;
        int bot;

        public Card(int t, int b) {
            top = t;
            bot = b;
        }

        private boolean isCard() {
            if (bot == 0) return false;
            return top % bot == 0;
        }

        public int getValue() {
            if (isCard()) {
                return top / bot;
            }
            return -1;
        }

        @Override
        public String toString(){
            return top+"/"+bot;
        }
    }
}
