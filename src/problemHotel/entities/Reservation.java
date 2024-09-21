package problemHotel.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import problemHotel.exceptions.DomainException;

public class Reservation {
    private int roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(int roomNumber, Date checkIn, Date checkOut){
        //Tratar a exceção no inicio dos métodos: programação Defensiva (boa prática)
        if (!checkOut.after(checkIn)){
            throw new DomainException("Check-Out Date must be after check-In date");
         } 
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public Date getCheckin() {
        return checkIn;
    }
   
    public Date getCheckout() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates (Date checkIn, Date checkOut){
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException( "Reservation date for update must be future dates");
        }
         if (!checkOut.after(checkIn)){
           throw new DomainException("Check-Out Date must be after check-In date");
        } 
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: Room " + roomNumber + ", checkIn: " + sdf.format(checkIn) 
        + ", checkOut: " + sdf.format(checkOut)+", " + duration() + " nights";
    }
    
}
