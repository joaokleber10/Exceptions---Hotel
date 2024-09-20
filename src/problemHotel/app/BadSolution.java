package problemHotel.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import problemHotel.entities.Reservation;

public class BadSolution {
      public static void main(String [] args) throws ParseException{
    
    Scanner sc = new Scanner(System.in);

    //definindo o modo de data que o usuário deve passar 
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");



    //Solicitando ao usuário as preferências de hospedagem com numero do quarto e data da reserva
    System.out.print("Room Number: ");
    int number = sc.nextInt();
    System.out.print("Check-in date (dd/MM/yyyy): ");
    Date checkIn = sdf.parse(sc.next());
    System.out.print("Check-out date (dd/MM/yyyy): ");
    Date checkOut = sdf.parse(sc.next());


     if (!checkOut.after(checkIn)){
        System.out.println("Error in reservation: Check-Out Date must be after check-In date");
    }
    else{
        //Instanciando o Objeto e imprimindo as informações da reserva
        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println(reservation.toString());
 //update de data
        System.out.println("\n Enter Data to update the reservation: ");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = sdf.parse(sc.next());
        

        //O método vai retornar uma string e armazenar nessa variável abaixo:
        String error = reservation.updateDates(checkIn, checkOut);
        
        //fará uma verificação se algum erro foi retornado;
        if(error != null){
            System.out.println("Error in reservation: " + error);
        } else{
            System.out.println("Reservation: " + reservation);
        }

    }
  }
}
