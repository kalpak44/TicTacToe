package TicTac;

import java.util.Scanner;
import java.util.Stack;

public class Controller {
    private Board b = new Board();
    private Saves saves = new Saves();
    private Stack<char[][]> history = new Stack<>();
    private char player = 'x';
    private boolean multiplayer = false;
    
    public void enableMultiplayer(){
        this.multiplayer = true;
    }

    @SuppressWarnings("resource")
    public void play() {
        System.out.println("Game Started!!!");
        b.displayField();

        while (b.checkGame() == ' ' && b.canMove()) {
            Scanner sc;
            System.out.println("Go " + player);
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int x = sc.nextInt();
                sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int y = sc.nextInt();
                    if (b.setField(x, y, player)) {
                        history.push(b.getField());

                        if (multiplayer==true) {
                            player = setNextPlayer(player);
                        } else {
                            b.CompMove(setNextPlayer(player));
                        }

                    } else {
                        System.out.println("Incorect Action");
                    }
                }
            } else if (sc.hasNextLine()) {
                String menu = sc.nextLine();
                if (menu.equals("q")) {
                    System.out.println("exit");
                    System.exit(0);
                } else if (menu.equals("s")) {
                    if (!history.isEmpty()) {
                        saves.saveGame(history, player);
                    }
                    System.out.println("save");
                } else if (menu.equals("l")) {
                    Stack<char[][]> save = saves.getHistory();
                    char player = saves.getPlayer();
                    if (save != null) {
                        b.setBoard(save.pop());
                    }
                    this.player = player;
                    System.out.println("loaded");
                } else if (menu.equals("n")) {
                    System.out.println("started new game");
                    b.clearBoard();

                } else {
                    System.out.println("invalid action ");
                }
            }

            b.displayField();
            System.out.println("---");

            if (b.checkGame() == 'x') {
                System.out.println("X WIN!");
            }
            if (b.checkGame() == '0') {
                System.out.println("0 WIN");
            }
            if (b.checkGame() == ' ' && !b.canMove()) {
                System.out.println("STANDOFF!");
            }

        }

    }

    private static char setNextPlayer(char player) {
        if (player == 'x') {
            return '0';
        } else {
            return 'x';
        }
    }

}
