import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client { // Clientarkitektur och GUI



    JFrame frame = new JFrame("");
    JButton buttonStartANewGame = new JButton();
    JButton buttonPlayAFriend = new JButton();
    JButton buttonAnswerA = new JButton();
    JButton buttonAnswerB = new JButton();
    JButton buttonAnswerC = new JButton();
    JButton buttonAnswerD = new JButton();

    /// GUI ............
    private static int port = 43972;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;



    public Client (String ServerAdress, int port) throws IOException {
        socket = new Socket(ServerAdress, Client.port);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        startANewGame();

    }


    //// GUI.......

    public void startANewGame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Quizkampen");

        buttonStartANewGame.setBounds(100,400,600,200);
        buttonStartANewGame.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonStartANewGame.setFocusable(false);
        buttonStartANewGame.addActionListener(this);
        buttonStartANewGame.setText("Start A New Game!");

        frame.setVisible(true);
        frame.add(buttonStartANewGame);
    }

    public void playAFriend(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Quizkampen");

        buttonPlayAFriend.setBounds(100,400,600,200);
        buttonPlayAFriend.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonPlayAFriend.setFocusable(false);
        //buttonPlayAFriend.addActionListener(this);
        buttonPlayAFriend.setText("Start A New Game!");

        frame.setVisible(true);
        frame.add(buttonPlayAFriend);
    }

    public static void main(String[] args) throws IOException {
        String ip = "127.0.0.1";
        int port = 43972;
        Client c = new Client(ip,port);

    }



}