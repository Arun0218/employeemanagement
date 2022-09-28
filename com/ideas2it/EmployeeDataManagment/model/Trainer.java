package com.ideas2it.EmployeeDataManagment.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Trainer Details.
 * @version 1.0
 * @author  Arun Kumar M. 
 */
public class Trainer {
    private int id;
    private String name;
    private long phoneNumber;
    private String email;
    private String bloodGroup;
    private float experience;
    private LocalDate dateOfBirth;
    private int age;
    private List<Trainee> trainee;

    public Trainer() {}

    public Trainer(int id, String name,long phoneNumber,
                   String email,LocalDate dateOfBirth,
                   float experience, String bloodGroup) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.experience = experience;
    this.dateOfBirth = dateOfBirth;
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

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
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

    public void setDateOfBirth(LocalDate dateofBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTrainee() {
        return trainee.toString();
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    public String toString() {
        StringBuilder stringBuilderDetails = new StringBuilder();
        stringBuilderDetails.append("\nTrainer ID\t\t: ").append(id)
                            .append("\nName\t\t\t: ").append(name)
                            .append("\nPhone Number\t\t: ").append(phoneNumber)
                            .append("\nEmail\t\t\t: ").append(email)
                            .append("\nBlood Group\t\t: ").append(bloodGroup)
                            .append("\nExperience\t\t: ").append(experience)
                            .append("\nDateOfBirth\t\t: ").append(dateOfBirth)
                            .append("\nAge\t\t\t: ").append(age)
                            .append("\n");
        return stringBuilderDetails.toString();
    }
}