package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number:");
			int mumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date ckeckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date ckeckOut = sdf.parse(sc.next());

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

		} catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
		catch (DomainException e) {
			System.out.println("Error in revervatio: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	
	}
}
