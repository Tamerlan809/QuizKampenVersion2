import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client { // Clientarkitektur och GUI




    /// GUI ............
    private static int port = 43972;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;



    public Client (String ServerAdress) throws IOException {
        socket = new Socket(ServerAdress, port);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }


    //// GUI.......


}