package models;

public class Employee {
  private String firstName;
  private String lastName;
  private String email;
  private Integer divisionId;

  public Employee(){

  }

  public Employee(String firstName, String lastName, String email, Integer divisionId) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.divisionId = divisionId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getDivisionId() {
    return divisionId;
  }

  public void setDivisionId(Integer divisionId) {
    this.divisionId = divisionId;
  }
}