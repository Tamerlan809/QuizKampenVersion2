import java.net.ServerSocket;

public class Serverlistener { // Server som vi först stratar som lyssnar efter att vi startar 2 clienter

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(43972);
        System.out.println("Quizkampen");
        try {
            while (true) {
                Serversideplayer player1 = new Serversideplayer(listener.accept(), '1');
                Serversideplayer player2 = new Serversideplayer(listener.accept(), '2');
                Gamelogic game = new Gamelogic(player1, player2);
                game.start();
            }
        } finally {
            listener.close();
        }
    }
}