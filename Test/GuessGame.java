public class GuessGame {
    Player p1; 
    Player p2; 
    Player p3; 

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean p1IsRight = false;
        boolean p2IsRight = false;
        boolean p3IsRight = false;

        int targetNumber = (int) (Math.random() * 10);
        System.out.println("I'm thinking about a number 0 and 9...");

        while(true) {
            System.out.println("Number to guess is " + targetNumber);

            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player 1 guessed " + guessp1);

            guessp2 = p2.number;
            System.out.println("Player 2 guessed " + guessp2);

            guessp3 = p3.number;
            System.out.println("Player 3 guessed " + guessp3);

            p1IsRight = guessp1 == targetNumber;
            p2IsRight = guessp2 == targetNumber;
            p3IsRight = guessp3 == targetNumber;

            if(p1IsRight || p2IsRight || p3IsRight) {
                System.out.println("We have a winner!");
                System.out.println("Player 1 got it right? " + p1IsRight);
                System.out.println("Player 2 got it right? " + p2IsRight);
                System.out.println("Player 3 got it right? " + p3IsRight);
                System.out.println("Game is over!");
                break;
            } else {
                System.out.println("Player will have to try again");
            }
        }
    }
}
