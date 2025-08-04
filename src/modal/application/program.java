package modal.application;

import modal.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIN = sdf.parse(scanner.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkIN)){
            System.out.println("Error in reservation: Check-out date must be after check-in date.");
        }
        else {
            Reservation reservation = new Reservation(number, checkIN, checkOut);
            System.out.println("Resevation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIN = sdf.parse(scanner.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            String error = reservation.updateDates(checkIN, checkOut);
            if (error != null) {
                System.out.println("Erro in reservation: " + error);
            }
            else {
                System.out.println("Resevation: " + reservation);

            }


            //Teste
        }

        scanner.close();

    }
}
