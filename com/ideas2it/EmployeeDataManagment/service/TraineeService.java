package com.ideas2it.EmployeeDataManagment.service;

import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class TraineeService {

    TraineeDAO traineeDAO = new TraineeDAO();

    public boolean isTraineeListIsEmpty() {

        return traineeDAO.traineeDetails.isEmpty();
    }

    public boolean isPhoneNumberAlreadyExist(long phoneNumber) {

        boolean isExist = true;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getPhoneNumber() == phoneNumber) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmployeeIdAlreadyExist(int employeeId) {

        boolean isExist = true;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getID() == employeeId) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmailAlreadyExist(String email) {

        boolean isExist = true;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getEmail()
                   .equals(email)) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isValidDateOfBirth(LocalDate dateOfBirth) {

        int age;
        boolean isValid = false;

        age = getAge(dateOfBirth);
        if((age > 18) && (age < 60)) {
            isValid = true;
        }
        return isValid;
    }

    public int getAge(LocalDate dateOfBirth) {

        int age = 0;

        LocalDate currentDate = LocalDate.now();
        if((dateOfBirth != null) && (currentDate != null)) {
            age = Period.between(dateOfBirth, currentDate).getYears();
        }
        return age;
    }

    public void addTraineeDetail(Trainee trainee) {

        traineeDAO.addTraineeDetails(trainee);
    }

    public List<Trainee> diplayAllTraineeDetails() {

        return traineeDAO.diplayAllTraineeDetails();
    }    

    public boolean checkTraineeById(int traineeId) {

        boolean isValid = false;

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getID() == traineeId) {
                isValid = true;
            }
        }
        return isValid;
    }

    public String getTraineeDetails(String trainees) {

        trainees = trainees.substring(1, trainees.length()-1);
        trainees = trainees.replace(',', ' ');

        return trainees;
    }

    public Trainee getTraineeDetailById(int traineeId) {

        Trainee trainee = new Trainee();

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (traineeDAO.traineeDetails.get(index).getID() == traineeId) {
                trainee = traineeDAO.getTraineeDetailById(index);
            }
        }
        return trainee;
    }

    public int getTraineePositionById(Trainee trainee) {

        int position = 0;

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (trainee.getID() == traineeDAO.traineeDetails.get(index)
                                       .getID()) {
                position = index;
            }
        }
        return position;
    }

    public void updateTrainee(Trainee trainee) {

        int position = getTraineePositionById(trainee);
        traineeDAO.updateTraineeDetails(position, trainee);
    }

    public void deleteAllTrainee() {

        traineeDAO.deleteAllTraineeDetails();
    }

    public void deleteTraineeById(int traineeId) {

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (traineeDAO.traineeDetails.get(index).getID()
                == traineeId) {
                traineeDAO.deleteTraineeById(index);
            }
        }
    }

}