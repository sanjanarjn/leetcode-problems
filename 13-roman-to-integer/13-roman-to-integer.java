import java.util.*;

enum Symbol {
    
    M(1000), CM(900), D(500), CD(400), C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);
    
    private static final Map<String, Symbol> mMap = new HashMap<>();

    static {
        for (Symbol s: Symbol.values()) {
            mMap.put(s.toString(), s);
        }
    }
    
    private int value;
    Symbol(int value) {
        
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public static Symbol getSymbol(String symbol) {
        return mMap.get(symbol);
    }
}

class Solution {
    
    public int romanToInt(String s) {
        
        int i = 0;
        int number = 0;
        while(i < s.length()) {
            
            char current = s.charAt(i);
            Symbol currentSymbol = Symbol.getSymbol(String.valueOf(current));
            
            if(i < s.length() -1) {
                char next = s.charAt(i+1);
                Symbol nextSymbol = Symbol.getSymbol(String.valueOf(next));
                
                if(currentSymbol.getValue() < nextSymbol.getValue()) {
                    currentSymbol = Symbol.getSymbol(current + ""+next);
                    i++;
                }
            }
            i++;
            number += currentSymbol.getValue();
        }
        return number;
    }
}