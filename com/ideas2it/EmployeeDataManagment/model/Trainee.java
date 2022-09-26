package com.ideas2it.EmployeeDataManagment.model;

import java.time.LocalDate;
import java.util.Date;

 /**
 * Trainee Details.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class Trainee {
    private int id;
    private String name;
    private long phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private int age;
    private String bloodGroup;

    public Trainee() {}

    public Trainee(int id, String name, long phoneNumber,
                   String email,LocalDate dateOfBirth,
                   String bloodGroup) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.email = email;
    this.bloodGroup = bloodGroup;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        StringBuilder stringBuilderDetails = new StringBuilder();
        stringBuilderDetails.append("\nTrainee ID\t\t: ").append(id)
                            .append("\nName\t\t\t: ").append(name)
                            .append("\nPhone Number\t\t: ").append(phoneNumber)
                            .append("\nEmail\t\t\t: ").append(email)
                            .append("\nBlood Group\t\t: ").append(bloodGroup)
                            .append("\nDateOfBirth\t\t: ").append(dateOfBirth)
                            .append("\nAge\t\t\t: ").append(age)
                            .append("\n");
        return stringBuilderDetails.toString();
    }
}