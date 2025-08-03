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

            Date now = new Date();
            if (checkIN.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be on future dates.");
            }
            else if (!checkOut.after(checkIN)){
                System.out.println("Error in reservation: Check-out date must be after check-in date.");
            }
            else {
                reservation.updateDates(checkIN, checkOut);
                System.out.println("Resevation: " + reservation);
            }


        }

        scanner.close();

    }
}
