import java.net.InetAddress;
import java.net.ServerSocket;

import static java.lang.System.out;

public class Serverlistener { // Server som vi först stratar som lyssnar efter att vi startar 2 clienter

    public static void main(String[] args) throws Exception {
        int port = 43972;
        InetAddress ipAdress = InetAddress.getByName("127.0.0.1");
        ServerSocket listener = new ServerSocket(port, 2, ipAdress);
        out.println("Quizkampen");
        try {
            while (true) {
                Serversideplayer player1 = new Serversideplayer(listener.accept(), '1');
                out.println("Spelare 1 har anslutit");
                Serversideplayer player2 = new Serversideplayer(listener.accept(), '2');
                out.println("Spelare 2 har anslutit");
                Gamelogic game = new Gamelogic(player1, player2);
                out.println("Välkommen");
                game.start();


            }
        } finally {
            listener.close();
        }
    }
}