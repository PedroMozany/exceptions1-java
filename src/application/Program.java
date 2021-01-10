package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number:");
		int mumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date ckeckIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date ckeckOut = sdf.parse(sc.next());
		if (!ckeckOut.after(ckeckIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}

		else {
			Reservation reservation = new Reservation(mumber, ckeckIn, ckeckOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			ckeckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			ckeckOut = sdf.parse(sc.next());
			reservation.updateDates(ckeckIn, ckeckOut);
			System.out.println("Reservation: " + reservation);
		}

		sc.close();

	}

}
