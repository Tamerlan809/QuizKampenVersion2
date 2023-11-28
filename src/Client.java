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

    JFrame welcomeFrame = new JFrame();

    JTextField welcomeTextField = new JTextField("Hej och välkommen");
    JTextField textField = new JTextField("Vilken färg är äpple?");
    JButton buttonAnswerA = new JButton("A:röd");
    JButton buttonAnswerB = new JButton("B:grön");
    JButton buttonAnswerC = new JButton("C;vit");
    JButton buttonAnswerD = new JButton("D;blå");

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

        welcomeFrame();

    }


    //// GUI.......

    public  void welcomeFrame(){
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setSize(800,650);
        welcomeFrame.getContentPane().setBackground(new Color(50,50,50));
        welcomeFrame.setLayout(null);
        welcomeFrame.setResizable(false);
        welcomeFrame.setTitle("Quizkampen");

        welcomeTextField.setBounds(0,0,500,100);
        welcomeTextField.setFont(new Font("MV Boli",Font.BOLD,35));

        welcomeFrame.setVisible(true);
        welcomeFrame.add(welcomeTextField);
    }

    public void startANewGame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Quizkampen");

        buttonAnswerA.setBounds(0,100,500,100);
        buttonAnswerA.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonAnswerA.setFocusable(false);

        buttonAnswerB.setBounds(0,200,500,100);
        buttonAnswerB.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonAnswerB.setFocusable(false);

        buttonAnswerC.setBounds(0,300,500,100);
        buttonAnswerC.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonAnswerC.setFocusable(false);

        buttonAnswerD.setBounds(0,400,500,100);
        buttonAnswerD.setFont(new Font("MV Boli",Font.BOLD,35));
        buttonAnswerD.setFocusable(false);

        textField.setBounds(0,0,500,100);
        textField.setFont(new Font("MV Boli",Font.BOLD,35));


        frame.setVisible(true);
        frame.add(textField);
        frame.add(buttonAnswerA);
        frame.add(buttonAnswerB);
        frame.add(buttonAnswerC);
        frame.add(buttonAnswerD);

        while(true){

        }
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