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





    @Override
    public void run() {
        // Your game logic here

        while (true) {
            String dataFromPlayer1 = player1.receive();
            // Handle data received from player1

            String dataFromPlayer2 = player2.receive();
            // Handle data received from player2

            // Perform game logic based on received data

            // Example:
            // If dataFromPlayer1 indicates a move, process the move
            // If dataFromPlayer2 is a response or another move, process accordingly
        }
    }
}