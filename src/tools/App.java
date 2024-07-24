package tools;

import daos.implementation.ReservationDAO;
import daos.implementation.UserDAO;
import java.sql.Date;
import java.sql.Timestamp;
import models.Reservation;
import models.User;

public class App {
  public static void main(String[] args) {
    DbConnection connection = new DbConnection();
    System.out.println(connection.getConnection());

    ReservationDAO reservationDAO = new ReservationDAO(connection.getConnection());
    UserDAO userDAO = new UserDAO(connection.getConnection());

    // //LOGIN
    // System.out.println(userDAO.login("nilamd.cahya", "nilam"));

    // //GET USER BY ID
    // User user = userDAO.get(3);
    // System.out.println("Name : " + user.getFirstName() + " " + user.getLastName() + " \n" +  "Email : " + user.getEmail() + "\n" + "Division : " + user.getDivisionId()+ "\n" + "Username : " + user.getUsername());

    // //GET ALL DATA
    // for (Reservation reservation : reservationDAO.get()) {
    //   System.out.println( "Id : " + reservation.getId() + ", User ID: " + reservation.getUserId() + ", Room ID: " + reservation.getRoomId() + ", Status ID: " + reservation.getStatusId() + ", Begin Reservation: " + reservation.getBeginReservation() + ", End Reservation: " + reservation.getEndReservation() + ", Submit Transaction: " + reservation.getSubmitTransaction());
    // }

    // //GET DATA BY ID
    // Reservation reservation = reservationDAO.get(1);
    // System.out.println("Id : " + reservation.getId() + ", User ID: " + reservation.getUserId() + ", Room ID: " + reservation.getRoomId() + ", Status ID: " + reservation.getStatusId() + ", Begin Reservation: " + reservation.getBeginReservation() + ", End Reservation: " + reservation.getEndReservation() + ", Submit Transaction: " + reservation.getSubmitTransaction());

    // //INSERT DATA
    // Reservation reservation2 = new Reservation(61, 1, 1, 1, Date.valueOf("2024-07-25"), Date.valueOf("2024-07-26"), Timestamp.valueOf("2024-07-25 12:00:00"));
    // System.out.println("Affected row(s) : " + reservationDAO.insert(reservation2));

    // //DELETE DATA
    System.out.println("Affected Row(s) = " + reservationDAO.delete(61));
  }
}
