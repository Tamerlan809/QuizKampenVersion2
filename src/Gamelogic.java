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
        player1.send("WELCOME " + player1.mark);
        player1.send("MESSAGE Waiting for opponent to connect");

        player2.send("WELCOME " + player2.mark);
        player2.send("MESSAGE All players connected");

        player1.send("MESSAGE Your move");

        String command;
        currentPlayer = player1;
    }
}