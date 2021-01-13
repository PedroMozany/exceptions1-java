package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date ckeckIn;
	private Date ckeckOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date ckeckIn, Date ckeckOut) {
		this.roomNumber = roomNumber;
		this.ckeckIn = ckeckIn;
		this.ckeckOut = ckeckOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCkeckIn() {
		return ckeckIn;
	}

	public Date getCkeckOut() {
		return ckeckOut;
	}

	public long duration() {
		long diff = ckeckOut.getTime() - ckeckIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public String updateDates(Date ckeckIn, Date ckeckOut) {
		Date now = new Date();

		if (ckeckIn.before(now) || ckeckOut.before(now)) {
			return "Reservation dates for update must be future dates";

		}
		if (!ckeckOut.after(ckeckIn)) {
			return "Check-out date must be after check-in date";
		}
		this.ckeckIn = ckeckIn;
		this.ckeckOut = ckeckOut;
		return null;

	}

	@Override
	public String toString() {
		return " Room " + roomNumber + ", check-in: " + sdf.format(ckeckIn) + ", check-out: " + sdf.format(ckeckOut)
				+ ", " + duration() + " nights";

	}
}
