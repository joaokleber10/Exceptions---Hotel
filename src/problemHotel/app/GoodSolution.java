package problemHotel.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import problemHotel.entities.Reservation;
import problemHotel.exceptions.DomainException;

public class GoodSolution {
      public static void main(String [] args) {
    
    Scanner sc = new Scanner(System.in);

    //definindo o modo de data que o usuário deve passar 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    try{
        //Solicitando ao usuário as preferências de hospedagem com numero do quarto e data da reserva
        System.out.print("Room Number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //Instanciando o Objeto e imprimindo as informações da reserva
        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println(reservation.toString());
        //update de data
        System.out.println("\n Enter Data to update the reservation: ");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());

        reservation.updateDates(checkIn, checkOut);   
        System.out.println("Reservation: " + reservation);

    } 
    catch(ParseException e){
        System.out.println("Invalid Date format");
    } 
    catch(DomainException e){
        System.out.println("Error in reservation "+e.getMessage());
    }
    catch(RuntimeException e){
        System.out.println("Unexpected error");
    }
    
  }
}
