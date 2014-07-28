package TicTac;

public class TicTac {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Controller p = new Controller();
        if(args.length > 0){
            if(args[0].equals("multiplayer")){
                p.enableMultiplayer();
            }
        }
        
        p.play();

    }
}
