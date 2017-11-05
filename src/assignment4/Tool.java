package assignment4;

public class Tool {
    protected int strength;
    protected char type;
    protected void setStrength(int strength) {
        this.strength = strength;
    }
    Tool(char type) {
        this.type = type;
    }
    }

class Rock extends Tool {
    public Rock(int r) {
        super('r');
        setStrength(r);
    }
    protected boolean fight(Tool s) {
        if (s.type == 'p') {
            return this.strength > s.strength * 2;
        } else if (s.type == 's'){
            return this.strength * 2 > s.strength;
        }
        else{
            return this.strength > s.strength;
        }
    }
}

class Paper extends Tool {
        public Paper(int t) {
            super('p');
            setStrength(t);
        }

    protected boolean fight(Tool s) {
        if (s.type == 'r') {
            return this.strength * 2> s.strength;
        } else if (s.type == 's'){
            return this.strength > s.strength * 2;
        }
        else{
            return this.strength > s.strength;
        }
    }
}
class Scissors extends Tool {
        public Scissors(int s) {
            super('s');
            setStrength(s);
        }
        protected boolean fight(Tool s) {
            if (s.type == 'r') {
                return this.strength > s.strength * 2;
            } else if (s.type == 'p'){
                return this.strength * 2 > s.strength;
            }
            else{
                return this.strength > s.strength;
            }
        }
}
class RockPaperScissorsGame {
    public void main(String[] args) {
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + "," + p.fight(s));
        System.out.println(p.fight(r) +  "," + r.fight(p));
        System.out.println(r.fight(s) +  "," + s.fight(r));
    }
}