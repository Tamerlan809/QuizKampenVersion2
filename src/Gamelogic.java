public class Gamelogic extends Thread { // I denna klass hanterar vi all logik i spelet

    Serversideplayer player1;
    Serversideplayer player2;


    int countQ = 1;

    // här deklareras en array av String
    String[] qList = new String[]{
            "QVad heter huvudstaden i Sverige?,Stockholm,London,Berlin,Kairo",
            "QVilket av dessa länder har flest invånare?,Kina,Indien,Pakistan,Ryssland"
    };
    // konstruktorn ställer in och initierar viktiga attribut för spelet när en ny instans av Gamelogic skapas
public Gamelogic(Serversideplayer player1, Serversideplayer player2){
    this.player1=player1;
    this.player2=player2;
    this.player1.setOpponent(player2);
    this.player2.setOpponent(player1);


}
    // checkWin-metoden informerar vilken spelare som har högst poäng och skickar meddelanden till båda spelarna om resultat.
public void checkWin(int player1Score, int player2Score){

    String p1Score = " Your score: " + player1Score + "   Opponent score: " + player2Score;
    String p2Score = " Your score: " + player2Score + "   Opponent score: " + player1Score;
    if (player1Score>player2Score){
        player1.send("Swin!!" + p1Score);
        System.out.println("Swin" + p1Score);
        player2.send("Slose..." + p2Score);
    } else if (player2Score>player1Score){
        player1.send("Slose..." + p1Score);
        System.out.println("Slose" + p1Score);
        player2.send("Swin!!" + p2Score);
    } else {
        player1.send("Sequal" + p1Score);
        player2.send("Sequal" + p2Score);
    }
}


    //  sköter själva flödet av spelet genom att ställa frågor och kontrollera vem som vinner
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