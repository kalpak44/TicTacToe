package TicTac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class Saves {
    public String saveFile = "GameSave.sav";
    private String sFile = "SaveFile";
    private SaveStruct s = new SaveStruct();

    public void saveGame(Stack<char[][]> history, char player) {
        s.player = player;
        s.history = history;
        saveHistory();
    }

    public Stack<char[][]> getHistory() {
        loadHistory();
        return s.history;
    }

    public char getPlayer() {
        loadHistory();
        return s.player;
    }

    private void saveHistory() {
        try {
            FileOutputStream fos = new FileOutputStream(sFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            if (s != null) {
                oos.writeObject(s);
                oos.flush();
                oos.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadHistory() {
        try {
            FileInputStream fis = new FileInputStream(sFile);
            @SuppressWarnings("resource")
            ObjectInputStream oin = new ObjectInputStream(fis);
            s = (SaveStruct) oin.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
