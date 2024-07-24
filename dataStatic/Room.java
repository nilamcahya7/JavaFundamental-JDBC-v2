package dataStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {
  public static List<Integer> user_id = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
  public static List<Integer> room_id = new ArrayList<>(Arrays.asList(2, 2, 2, 4));
  public static List<Integer> status_id = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
  public static List<String> begin_reservation = new ArrayList<>(Arrays.asList("2024-07-16", "2024-07-20", "2024-07-24", "2024-07-30"));
  public static List<String> end_reservation = new ArrayList<>(Arrays.asList("2024-07-18", "2024-07-21", "2024-07-25", "2024-07-31"));
  public static List<String> submit_transaction = new ArrayList<>(Arrays.asList("2024-07-15", "2024-07-19", "2024-07-23", "2024-07-19"));
}