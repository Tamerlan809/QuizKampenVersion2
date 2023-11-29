import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client { // Clientarkitektur och GUI


    JFrame frame = new JFrame("");
    JButton buttonStartANewGame = new JButton();
    JButton buttonPlayAFriend = new JButton();
    JLabel question = new JLabel();
    JFrame welcomeFrame = new JFrame();
    JTextField welcomeTextField = new JTextField("Hej och välkommen");

    JTextField scoreTextField = new JTextField("Result: ");
    JButton buttonAnswerA = new JButton("A:röd");
    JButton buttonAnswerB = new JButton("B:grå");
    JButton buttonAnswerC = new JButton("C;vit");
    JButton buttonAnswerD = new JButton("D;blå");

    JTextField forRecTestMsg = new JTextField("testprinting...");

    /// GUI ............
    private static int port = 43972;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;


    public Client(String ServerAdress, int port) {
        try {
            socket = new Socket(ServerAdress, Client.port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);


            frame = frameTemplate();

            frame.setContentPane(welcomePanel());
            Thread.sleep(1500);
            welcomePanel().setVisible(false);
            frame.setContentPane(startNewGamePanel());
            frame.revalidate();

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }
    //// GUI.......


    //main frame
    //public JPanel welcomPanel
    //frame.set(welcomePanel)
    //public JPanel frågaPanel
    //frame.remove(welcomePanel)
    //frame.set(frågaPanel)
    //frame.revalidate()

    public JFrame frameTemplate(){
        JFrame temp = new JFrame();
        temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        temp.setSize(800, 650);
        temp.getContentPane().setBackground(new Color(50, 50, 50));
        temp.setLayout(null);
        temp.setResizable(false);
        temp.setTitle("Quizkampen");

        temp.setVisible(true);

        return temp;
    }

    public JPanel welcomePanel() {
        JPanel temp = new JPanel();
        //retrun Jpanel welcomePanel
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 650);
//        frame.getContentPane().setBackground(new Color(50, 50, 50));
//        frame.setLayout(null);
//        frame.setResizable(false);
//        frame.setTitle("Quizkampen");

        temp.add(welcomeTextField);

        welcomeTextField.setBounds(0,0,650,50);
        welcomeTextField.setBackground(new Color(25,25,25));
        welcomeTextField.setForeground(new Color(25,255,0));
        welcomeTextField.setFont(new Font("Ink Free",Font.BOLD,30));
        welcomeTextField.setBorder(BorderFactory.createBevelBorder(1));
        welcomeTextField.setHorizontalAlignment(JTextField.CENTER);
        welcomeTextField.setEditable(false);

//        frame.setVisible(true);

        return temp;
    }

    public JPanel startNewGamePanel() {
        JPanel temp = new JPanel();
        temp.setLayout(new GridLayout(6,1));
        //startNewGamePanel
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 650);
//        frame.getContentPane().setBackground(new Color(50, 50, 50));
//        frame.setLayout(null);
//        frame.setResizable(false);
//        frame.setTitle("Quizkampen");

//        frame.setVisible(true);

        temp.add(question);
        temp.add(buttonAnswerA);
        temp.add(buttonAnswerB);
        temp.add(buttonAnswerC);
        temp.add(buttonAnswerD);
        temp.add(forRecTestMsg);


        buttonAnswerA.setBounds(0, 100, 500, 100);
        buttonAnswerA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonAnswerA.setFocusable(false);

        buttonAnswerB.setBounds(0, 200, 500, 100);
        buttonAnswerB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonAnswerB.setFocusable(false);

        buttonAnswerC.setBounds(0, 300, 500, 100);
        buttonAnswerC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonAnswerC.setFocusable(false);

        buttonAnswerD.setBounds(0, 400, 500, 100);
        buttonAnswerD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonAnswerD.setFocusable(false);

        forRecTestMsg.setBounds(0,500,650,50);
        forRecTestMsg.setBackground(new Color(25,25,25));
        forRecTestMsg.setForeground(new Color(25,255,0));
        forRecTestMsg.setFont(new Font("Ink Free",Font.BOLD,30));
        forRecTestMsg.setBorder(BorderFactory.createBevelBorder(1));
        forRecTestMsg.setHorizontalAlignment(JTextField.CENTER);
        forRecTestMsg.setEditable(false);

        question.setForeground(Color.black);
        question.setText("Vilken färg har äpple?");
        question.setSize(200, 200);
        question.setBounds(0, 0, 500, 100);
        question.setFont(new Font("MV Boli", Font.BOLD, 35));

        buttonAnswerA.addActionListener(e -> {

            out.println("Correct"); // Send 'Correct' to the server for the correct answer
            System.out.println("Button A clicked - Correct answer!");
        });

        ActionListener incorrectAnswerListener = e -> {

            out.println("Incorrect"); // Send 'Incorrect' to the server for incorrect answers
            System.out.println("Incorrect answer!");
        };

        // Assign the incorrectAnswerListener to buttons B, C, D
        buttonAnswerB.addActionListener(incorrectAnswerListener);
        buttonAnswerC.addActionListener(incorrectAnswerListener);
        buttonAnswerD.addActionListener(incorrectAnswerListener);

        return temp;

    }

    public JPanel scorePanel() {
        JPanel temp = new JPanel();

        temp.add(scoreTextField);

        scoreTextField.setBounds(0,0,650,50);
        scoreTextField.setBackground(new Color(25,25,25));
        scoreTextField.setForeground(new Color(25,255,0));
        scoreTextField.setFont(new Font("Ink Free",Font.BOLD,30));
        scoreTextField.setBorder(BorderFactory.createBevelBorder(1));
        scoreTextField.setHorizontalAlignment(JTextField.CENTER);
        scoreTextField.setEditable(false);

        return temp;
    }

    public void play(){
        String temp2;
        try {
            while (true){
                if ((temp2 = in.readLine()) != null){
                    System.out.println(temp2);
                    startNewGamePanel().setVisible(false);
                    frame.setContentPane(scorePanel());
                    scoreTextField.setText(temp2);
                    frame.revalidate();
                    frame.repaint();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void playAFriend() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Quizkampen");


        buttonPlayAFriend.setBounds(100, 400, 600, 200);
        buttonPlayAFriend.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonPlayAFriend.setFocusable(false);
        //buttonPlayAFriend.addActionListener(this);
        buttonPlayAFriend.setText("Start A New Game!");

        frame.setVisible(true);
        frame.add(buttonPlayAFriend);
    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 43972;
        Client c = new Client(ip, port);
        c.play();

    }

}