import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static Queue queue;
    public static Stack stack;

    public static void main(String[] args) throws Exception {
        int choiceNumber;
        queue = new Queue();
        stack = new Stack();
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("==========Menu==========");
                System.out.println("1.Input the Message");
                System.out.println("2.Send message");
                System.out.println("3.View message");
                System.out.println("4.Exit");
                System.out.println("========================");

                choiceNumber = scanner.nextInt();

                if (choiceNumber == 1) {
                    inputMessage();
                } else if (choiceNumber == 2) {
                    sendMessage();

                } else if (choiceNumber == 3) {
                    viewMessage();

                } else if (choiceNumber == 4) {
                    System.out.println("Thank you for using our system");
                    break;
                }

                else {
                    throw new Exception("the progam run 1 to 4, Try again!!!");
                }

            } while (choiceNumber != 4);
        } catch (InputMismatchException e) {
            System.out.println("You can't enter word on select number");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void inputMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message here: ");
        String str = scanner.nextLine();

        if (str.length() < 250) {
            queue.enqueue(str);
            System.out.println(" ");
            System.out.println("Done");
        } else {
            System.out.println(" ");
            System.out.println("the texting must below 250 words put again please!!! ");
        }

    }

    public static void sendMessage() throws Exception {
        if (queue.isEmpty()) {
            System.out.println("The Queue is empty!");
        }
        while (!queue.isEmpty()) {
            String message = (String) queue.dequeue();
            stack.push(message);
            System.out.println("Message sent successfully");
        }

    }

    public static void viewMessage() {
        if (stack.isEmpty()) {
            System.out.println("No Message");
        }
        while (!stack.isEmpty()) {
            String message = (String) stack.pop();
            System.out.println("The message you input:");
            System.out.println(message);
        }
    }

}