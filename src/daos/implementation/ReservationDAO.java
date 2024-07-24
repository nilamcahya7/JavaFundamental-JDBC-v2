package daos.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daos.RerservationInterface;
import models.Reservation;

public class ReservationDAO implements RerservationInterface {
  private Connection connection;

  public ReservationDAO(Connection connection){
    this.connection = connection;
  }

  @Override
  public List<Reservation> get(){
    List<Reservation> reservations = new ArrayList<>();
    String query = "SELECT * FROM tbl_tr_transaction";

    try{
      ResultSet resultSet = connection.prepareStatement(query).executeQuery();

      while(resultSet.next()){
        Reservation reservation = new Reservation(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getInt("room_id"), resultSet.getInt("status_id"), resultSet.getDate("begin_reservation"), resultSet.getDate("end_reservation"), resultSet.getTimestamp("submit_transaction"));
        reservations.add(reservation);
      }
    } catch (SQLException e){
      e.getMessage();
    }
    return reservations;
  }

  @Override //overload
  public Reservation get(int id){
    Reservation reservation = null;
    String query = "SELECT id, user_id, room_id, status_id, begin_reservation, end_reservation, submit_transaction FROM tbl_tr_transaction WHERE id = ?";

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      
      while(resultSet.next()){
        reservation = new Reservation(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getInt("room_id"), resultSet.getInt("status_id"), resultSet.getDate("begin_reservation"), resultSet.getDate("end_reservation"), resultSet.getTimestamp("submit_transaction"));
      }
    } catch (SQLException e){
      e.getMessage();
      }
    return reservation;
  }

  @Override
  public Integer insert(Reservation reservation) {
    String query = "INSERT INTO tbl_tr_transaction (id, user_id, room_id, status_id, begin_reservation, end_reservation, submit_transaction) VALUES (?,?,?,?,?,?,?)";

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, reservation.getId());
      preparedStatement.setInt(2, reservation.getUserId());
      preparedStatement.setInt(3, reservation.getRoomId());
      preparedStatement.setInt(4, reservation.getStatusId());
      preparedStatement.setDate(5, reservation.getBeginReservation());
      preparedStatement.setDate(6, reservation.getEndReservation());
      preparedStatement.setTimestamp(7, reservation.getSubmitTransaction());

      int count = preparedStatement.executeUpdate();
      return count;
    } catch(SQLException e){
      e.printStackTrace(); 
  }
    return 0;
  }

  @Override
  public Integer delete(int id) {
    String query = "DELETE FROM tbl_tr_transaction WHERE id = ?";
    Reservation reservation = get(id);

    if (reservation == null){
      return 0;
    }

    try{
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, reservation.getId());
      int count = preparedStatement.executeUpdate();
      return count;
    } catch (SQLException e){
      e.getMessage();
    }
    return 0;
  }
}
