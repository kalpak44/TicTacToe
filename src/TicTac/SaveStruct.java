package TicTac;

import java.io.Serializable;
import java.util.Stack;

@SuppressWarnings("serial")
public class SaveStruct implements Serializable {
    
    public Stack<char[][]> history;
    public char player;
}
