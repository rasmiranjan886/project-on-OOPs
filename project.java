import java.util.Scanner;

public class Entry1 {

    public static String chooseMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("         [ Let's find the perfect choice for your evening ]");
        System.out.println("               <<<<<< Here's Your Movie List >>>>>>");
        System.out.println();
        System.out.println("[1] ABCD2 :: || A high-energy dance drama that will get your feet tapping! ||");
        System.out.println("[2] London 1920 :: || A historical romance that will sweep you off your feet ||");
        System.out.println("[3] The End Of the Earth :: || A thrilling sci-fi adventure that will take you to new worlds ||");
        System.out.println("[4] The Great Escape :: || A classic action movie that will keep you on ||");
        System.out.println("[5] The Notebook :: || A timeless romantic drama that will make you cry ||");
        System.out.println();

        while (true) {
            System.out.print("Select your Movie [1-5]: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    return "ABCD2";
                case 2:
                    return "London 1920";
                case 3:
                    return "The End Of the Earth";
                case 4:
                    return "The Great Escape";
                case 5:
                    return "The Notebook";
                default:
                    System.out.println("Oops! That's not a valid choice. Please try again.");
            }
        }
    }

    public static double selectTickets(int numTickets, String[] choices) {
        Scanner sc = new Scanner(System.in);
        double totalCost = 0;
        for (int i = 0; i < numTickets; i++) {
            System.out.println();
            System.out.println("              <<<<<< Choose Your Age-Group [Price] >>>>>>");
            System.out.println();
            System.out.println("[1] Adult [Rs 50/-] :: || Enjoy the movie like a pro! ||");
            System.out.println("[2] Child [Rs 20/-] :: || Bring the little ones for a magical time! ||");
            System.out.println("[3] Senior Citizen [Rs 40/-] :: || Relax and unwind with a classic film ||");
            System.out.println();

            while (true) {
                System.out.print("Select Your Age [1-3]: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        choices[i] = "Adult";
                        totalCost += 50;
                        break;
                    case 2:
                        choices[i] = "Child";
                        totalCost += 20;
                        break;
                    case 3:
                        choices[i] = "Senior Citizen";
                        totalCost += 40;
                        break;
                    default:
                        System.out.println("Oops! That's not a valid choice. Please try again.");
                        continue;
                }
                break;
            }
        }
        System.out.println();
        System.out.println("_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println();
        System.out.println("Total Number of Tickets choosed: " + numTickets);
        for (String choice : choices) {
            System.out.println(choice + " ticket selected.");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Total payment to be done: Rs " + totalCost + "/-");
        System.out.println("-----------------------------------------------------------------");
        return totalCost;
    }

    public static void manageSeats(int[][] seats, int numTickets) {
        Scanner sc = new Scanner(System.in);

        while (numTickets > 0) {
            System.out.println();
            System.out.println("  [ Wherever the popcorn lands, that's my seat! ]");
            System.out.println("        <<<<<< Choose your Seats >>>>>>");
            System.out.println();
            System.out.println(":: Available seats ::");
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[0].length; j++) {
                    if (seats[i][j] == 0) {
                        System.out.print("[ ] ");
                    } else {
                        System.out.print("[" + seats[i][j] + "] ");
                    }
                }
                System.out.println();
            }
            System.out.print("Enter the seat number you want to book : ");
            int seatNumber = sc.nextInt();

            boolean seatBooked = false;
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[0].length; j++) {
                    if (seats[i][j] == seatNumber) {
                        System.out.println("Your seat has been booked! Seat number: [" + seats[i][j] + "]");
                        seats[i][j] = 0;
                        seatBooked = true;
                        numTickets--;
                        break;
                    }
                }
                if (seatBooked) break;
            }
            if (!seatBooked) {
                System.out.println("Oops! This seat is either already booked or invalid. Please choose another one.");
            }
        }
    }
    public static void displaySummary(String chosenMovie, String[] ticketChoices, double totalPayment) {
        System.out.println();
        System.out.println("***********************  Check your Summary  ***********************");
        System.out.println("Chosen Movie: " + chosenMovie);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Ticket Choices:");
        for (int i = 0; i < ticketChoices.length; i++) {
            System.out.println("- " + ticketChoices[i] );
        }
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Total Payment: Rs " + totalPayment + "/-");
        System.out.println("-----------------------------------------------------------------------");
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("******************   Welcome To Our Movie Theater    ******************");
        System.out.println();
        String chosenMovie = chooseMovie();
        System.out.println("( Great! You selected: " + chosenMovie + ")");
        System.out.println("_______________________________________________________________________");
        System.out.println("");
        System.out.println("[ Just grab a ticket, the real adventure starts with the movie itself! ]");
        System.out.println("                   <<<<<< Choose your Ticket >>>>>>");
        System.out.println();
        System.out.print("Enter the number of tickets you want to purchase: ");
        int numTickets = sc.nextInt();
        String[] ticketChoices = new String[numTickets];
        double totalPayment = selectTickets(numTickets, ticketChoices);
        System.out.println();

        int[][] seats = {
            {11, 12, 13, 14},
            {21, 22, 23, 24}
        };

        manageSeats(seats, numTickets);
        displaySummary(chosenMovie, ticketChoices, totalPayment);
        System.out.println();
        System.out.println("<< Thank you for visiting our movie theater! Have a wonderful time at the movies! See you soon... >>");
        System.out.println();
        System.out.println("*******************************  EXITING  ******************************");
    }
}
