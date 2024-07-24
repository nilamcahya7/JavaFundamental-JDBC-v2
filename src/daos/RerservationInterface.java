package daos;

import java.util.List;

import models.Reservation;

public interface RerservationInterface {
  public List<Reservation> get();
  public Reservation get(int id);
  public Integer insert(Reservation reservation);
}
