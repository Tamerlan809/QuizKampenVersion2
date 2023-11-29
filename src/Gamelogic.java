public class Gamelogic extends Thread { // I denna klass hanterar vi all logik i spelet

    Serversideplayer player1;
    Serversideplayer player2;
    Serversideplayer currentPlayer;

    int countQ = 1;

    String[] qList = new String[]{
            "QVad heter huvudstaden i Sverige?,Stockholm,London,Berlin,Kairo",
            "QVilket land har flest invånare?,Kina,Indien,Pakistan,Ryssland"
    };

public Gamelogic(Serversideplayer player1, Serversideplayer player2){
    this.player1=player1;
    this.player2=player2;
    this.currentPlayer = player1;
    this.player1.setOpponent(player2);
    this.player2.setOpponent(player1);
}

public void checkWin(int player1Score, int player2Score){
    if (player1Score>player2Score){
        player1.send("Swin");
        player2.send("Slose");
    } else if (player2Score>player1Score){
        player1.send("Slose");
        player2.send("Swin");
    } else {
        player1.send("Sequal");
        player2.send("Sequal");
    }
}



    @Override
    public void run() {

    while (true) {

            if (countQ==1){
                player1.send(qList[0]);
                System.out.println(qList[0]);
                player2.send(qList[0]);
                countQ++;
            } else if (countQ==2){
                player1.send(qList[1]);
                System.out.println(qList[1]);
                player2.send(qList[1]);
                countQ++;
            } else {
                System.out.println("check win");
                checkWin(player1.getScore(), player2.getScore());
            }


            String dataFromPlayer1 = player1.receive();
            System.out.println("player1 " + dataFromPlayer1);
            if (dataFromPlayer1.equals("Correct")){
                System.out.println("player1 before calculation: " + player1.getScore());
                player1.setScore(player1.getScore()+1);
            }
            System.out.println("player1 after calculation: " + player1.getScore());


            String dataFromPlayer2 = player2.receive();
            System.out.println("player2 " + dataFromPlayer2);
            if (dataFromPlayer2.equals("Correct")){
                System.out.println("player2 before calculation: " + player2.getScore());
                player2.setScore(player2.getScore()+1);
            }
            System.out.println("player2 after calculation: " + player2.getScore());


        }
    }
}