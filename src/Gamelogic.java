public class Gamelogic extends Thread { // I denna klass hanterar vi all logik i spelet

    Serversideplayer player1;
    Serversideplayer player2;
    Serversideplayer currentPlayer;

public Gamelogic(Serversideplayer player1, Serversideplayer player2){
    this.player1=player1;
    this.player2=player2;
    this.currentPlayer = player1;
    this.player1.setOpponent(player2);
    this.player2.setOpponent(player1);
}

//public void checkWin(int player1Score, int player2Score){
//    if (player1Score>player2Score){
//        player1.send("win");
//        player2.send("lose");
//    }
//}



    @Override
    public void run() {
        // Your game logic here

        while (true) {
            String dataFromPlayer1 = player1.receive();
            System.out.println("player1 " + dataFromPlayer1);
            if (dataFromPlayer1.equals("Correct")){
                System.out.println("player1 before calculation: " + player1.getScore());
                player1.setScore(player1.getScore()+1);
            }
            System.out.println("player1 after calculation: " + player1.getScore());
            // Handle data received from player1

            String dataFromPlayer2 = player2.receive();
            System.out.println("player2 " + dataFromPlayer2);
            if (dataFromPlayer2.equals("Correct")){
                System.out.println("player2 before calculation: " + player2.getScore());
                player2.setScore(player2.getScore()+1);
            }
            System.out.println("player2 after calculation: " + player2.getScore());

            player1.send("player1 testing testing");
            System.out.println("sent to player1 testing testing");
            player2.send("player2 testing testing");
            System.out.println("sent to player2 testing testing");
            // Handle data received from player2

            // Perform game logic based on received data

            // Example:
            // If dataFromPlayer1 indicates a move, process the move
            // If dataFromPlayer2 is a response or another move, process accordingly
        }
    }
}