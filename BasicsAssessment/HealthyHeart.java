import java.util.Scanner;

public class HealthyHeart {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.print("What is your age?");
        int age = in.nextInt();

        int maxBeat = 220 - age;
        double targMin = maxBeat/2;
        double targMax = maxBeat * 0.85;

        System.out.println("Your maximum heart rate should be " + maxBeat + " beats per minute");
        System.out.println("Your target HR Zone is " + (int) targMin + " - " + (int) targMax + " beats per minute");
    }
}
