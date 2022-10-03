package com.ideas2it.EmployeeDataManagment.service;

import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class TraineeService {
    TraineeDAO traineeDAO = new TraineeDAO();

    public List<Trainee> getAllTraineeDetails() {
        return traineeDAO.getAllTraineeDetails();
    }    

    public boolean isTraineeListIsEmpty() {
        return getAllTraineeDetails().isEmpty();
    }

    public boolean isPhoneNumberExist(long phoneNumber) {
        boolean isExist = true;

        for(Trainee traineelist : getAllTraineeDetails()) {
            if(traineelist.getPhoneNumber() == phoneNumber) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmployeeIdExist(int employeeId) {
        boolean isExist = true;

        for(Trainee traineelist : getAllTraineeDetails()) {
            if(traineelist.getID() == employeeId) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmailExist(String email) {
        boolean isExist = true;

        for(Trainee traineelist : getAllTraineeDetails()) {
            if(traineelist.getEmail()
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
        if((dateOfBirth != null)) {
            age = Period.between(dateOfBirth, currentDate).getYears();
        }
        return age;
    }

    public void addTraineeDetail(Trainee trainee) {
        traineeDAO.addTraineeDetails(trainee);
    }

    public boolean checkTraineeById(int traineeId) {
        boolean isValid = false;

        for(Trainee traineelist : getAllTraineeDetails()) {
            if(traineelist.getID() == traineeId) {
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

        for(int index = 0; index < getAllTraineeDetails().size(); index++) {
            if (getAllTraineeDetails().get(index).getID() == traineeId) {
                trainee = traineeDAO.getTraineeDetailById(index);
            }
        }
        return trainee;
    }

    public int getTraineePositionById(Trainee trainee) {
        int position = 0;

        for(int index = 0; index < getAllTraineeDetails().size(); index++) {
            if (trainee.getID() == getAllTraineeDetails().get(index)
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

        for(int index = 0; index < getAllTraineeDetails().size(); index++) {
            if (getAllTraineeDetails().get(index).getID() == traineeId) {
                traineeDAO.deleteTraineeById(index);
            }
        }
    }
}