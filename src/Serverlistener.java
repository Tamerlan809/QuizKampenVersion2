import java.net.InetAddress;
import java.net.ServerSocket;

import static java.lang.System.out;

public class Serverlistener { // Server som vi först stratar som lyssnar efter att vi startar 2 clienter

    public static void main(String[] args) throws Exception {
        int port = 43972;
        ServerSocket listener = new ServerSocket(port);
        System.out.println("Quizkampen");
        try {
            while (true) {
                Serversideplayer player1 = new Serversideplayer(listener.accept(), '1');
                System.out.println("Spelare 1 har anslutit");
                Serversideplayer player2 = new Serversideplayer(listener.accept(), '2');
                System.out.println("Spelare 2 har anslutit");
                Gamelogic game = new Gamelogic(player1, player2);
                System.out.println("Välkommen");
                game.start();
            }
        } finally {
            listener.close();
        }
    }
}