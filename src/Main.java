import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        while (true) {
            try {
                System.out.println("In your account " + account.getAmount() + "$");
                System.out.println("Enter the amout: ");
                Scanner scanner = new Scanner(System.in);
                account.withDraw(scanner.nextInt());
                System.out.println("Success. Your remaining account: " + account.getAmount() + "$");
            }catch (LimitException le) {
                System.out.println(le.getMessage());
                try {
                    account.withDraw((int) account.getAmount());
                }catch (LimitException le2){
                    throw new RuntimeException(le2);
                }
                System.out.println("In your account " + account.getAmount() + "$");
                break;
            }
        }

    }
}