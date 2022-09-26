package com.ideas2it.EmployeeDataManagment.service;

import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.dao.TrainerDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;
import com.ideas2it.EmployeeDataManagment.model.Trainer;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class TrainerService {

    TrainerDAO trainerDAO = new TrainerDAO();

    public boolean isTrainerListIsEmpty() {

        return trainerDAO.trainerDetails.isEmpty();
    }

    public boolean isPhoneNumberAlreadyExist(long phoneNumber) {

        boolean isExist = true;
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getPhoneNumber()
                   == phoneNumber) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmployeeIdAlreadyExist(int employeeId) {

        boolean isExist = true;
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getID()
                   == employeeId) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmailAlreadyExist(String email) {

        boolean isExist = true;
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getEmail()
                   .equals(email)) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isValidDateOfBirth(LocalDate dateOfBirth) {

        int age;
        boolean isValid = false;

        try {
            age = getAge(dateOfBirth);
            if((age > 20) && (age < 60)) {
                isValid = true;
            }
        } catch (DateTimeParseException dateException) {
            isValid = false;
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

    public void addTrainerDetail(Trainer trainer) {

        trainerDAO.addTrainerDetails(trainer);
    }

    public List<Trainer> diplayAllTrainerDetails() {

        return trainerDAO.diplayAllTrainerDetails();
    }    

    public boolean checkTrainerById(int trainerId) {

        boolean isValid = false;

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if (trainerDAO.trainerDetails.get(index).getID()
                == trainerId) {
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

    public Trainer getTrainerDetailById(int trainerId) {

        Trainer trainer = new Trainer();

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getID()
               == trainerId) {
                trainer = trainerDAO.trainerDetails.get(index);
            }
        }
        return trainer;
    }

    public String getTrainerDetails(String trainers) {

        trainers = trainers.substring(1, trainers.length()-1);
        trainers = trainers.replace(',', ' ');

        return trainers;
    }

    public int getTrainerPositionById(Trainer trainer){

        int position = 0;

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainer.getID() == (trainerDAO.trainerDetails.get(index)
                                      .getID())) {
                position = index;
            }
        }
        return position;
    }

    public void updateTrainer(Trainer trainer) {

        int position = getTrainerPositionById(trainer);
        trainerDAO.updateTrainerDetails(position, trainer);
    }

    public void deleteAllTrainer() {

        trainerDAO.deleteAllTrainerDetails();
    }

    public void deleteTrainerById(int trainerId) {

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if (trainerDAO.trainerDetails.get(index).getID()
                 == trainerId) {
                trainerDAO.deleteTrainerById(index);
            }
        }
    }
}