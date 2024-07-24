package daos;

import models.User;

public interface UserManagementInterface {
  public boolean login(String username, String password);
  public User get(int id);
}
