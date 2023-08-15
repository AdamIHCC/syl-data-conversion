// This torment was created by Syl and Martin.

import java.util.*;

public class Main {
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args) {
        //Build a scanner ---- DONE

        //Prompt and store double amount ---- DONE
        System.out.print("Enter the amount of data >> ");
        double amount = Double.parseDouble(userInput.nextLine());

        //Prompt and store String unit ---- DONE
        System.out.print("Enter the data unit (bytes, kilobytes, megabytes, gigabytes) >> ");
        String unit = userInput.nextLine();

        //Prompt and store download speed (in megabits) ---- DONE
        System.out.print("Enter download speed (in megabits per second) >> ");
        int downloadSpeed = Integer.parseInt(userInput.nextLine());

        //Build a Data object with these three values
        Data data = new Data(amount, unit, downloadSpeed);

        data.setAmount(amount);
        data.setUnit(unit);
        data.setDownloadSpeed(downloadSpeed);
        //Print out the data Object with your toString();

        System.out.println(data.toString());

        // Good variable names throughout the project!
    }
}
