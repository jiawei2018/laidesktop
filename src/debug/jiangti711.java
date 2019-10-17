package debug;

import java.util.ArrayList;
import java.util.List;

public class jiangti711 {
    public boolean judgePoint24(int[] nums) {
        return check(toCard(nums));
    }
    private boolean card24(Card card) {
        int up = card.up;
        int bot = card.bot;
        if (bot == 0) return false;  //bug!
        if (up / bot == 24 && up % bot == 0) {
            return true;
        }
        return false;
    }

    private boolean check(List<Card> cards) {
        if (cards.size() == 0) return false;
        if (cards.size() == 1 && card24(cards.get(0))) {
                return true;
        }

        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                if (i == j) continue;

                List<Card> tmp = new ArrayList<>();
                for (int k = 0; k < cards.size(); k++) {
                    if (k == i && k == j) continue;
                    tmp.add(cards.get(k)); //add the rest two ele
                }

                for (int k = 1; k <= 4; k++) {
                    Card a = cards.get(i);
                    Card b = cards.get(j);
                    // card c is a new card; computed by a & b
                    Card c = merge(a, b, k);
                    tmp.add(c);
                    if (check(tmp)) {
                        return true;
                    }
                    tmp.remove(tmp.size() - 1);
                }
            }//for inner
        }//for
        return false;
    }

    private List<Card> toCard(int[] nums) {
        List<Card> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(new Card(nums[i], 1));
        }
        return res;
    }

    private Card merge(Card a, Card b, int op) {//1 2 3 4
        if (op == 1) {// PLUS
            int up = a.up * b.bot + b.up * a.bot;
            int bot = a.bot * b.bot;
            return new Card(up, bot);
        } else if (op == 3) {// MINUS 3
            int up = a.up * b.bot - b.up * a.bot;
            int bot = a.bot * b.bot;
            return new Card(up, bot);
        } else if (op == 2) {// MULTIPLE 2
            int up = a.up * b.up;
            int bot = a.bot * b.bot;
            return new Card(up, bot);
        } else {// DIVIDE 4
            int up = a.up * b.bot;
            int bot = a.bot * b.up;
            return new Card(up, bot);
        }
    }
}

class Card {
    int up;
    int bot;

    public Card(int up, int bot) {
        this.up = up;
        this.bot = bot;
    }
     @Override
     public String toString() {
         String res ="";
         return res + up + " <> " + bot;
     }
}


