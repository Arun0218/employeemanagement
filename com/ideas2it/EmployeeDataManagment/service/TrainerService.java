package com.ideas2it.EmployeeDataManagment.service;

import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.dao.TrainerDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;
import com.ideas2it.EmployeeDataManagment.model.Trainer;

import java.util.List;

public class TrainerService {

    TrainerDAO trainerDAO = new TrainerDAO();

    public boolean isTrainerListIsEmpty() {

        return trainerDAO.trainerDetails.isEmpty();
    }

    public boolean isPhoneNumberAlreadyExist(String phoneNumber) {

        boolean isExist = true;
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getPhoneNumber()
                   .equals(phoneNumber)) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmployeeIdAlreadyExist(String employeeId) {

        boolean isExist = true;
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getID()
                   .equals(employeeId)) {
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

    public void addTrainerDetail(Trainer trainer) {

        trainerDAO.addTrainerDetails(trainer);
    }

    public List<Trainer> diplayAllTrainerDetails() {

    return trainerDAO.diplayAllTrainerDetails();
    }    

    public boolean checkTrainerById(String trainerId) {

        boolean isValid = false;

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if (trainerDAO.trainerDetails.get(index).getID()
                .equals(trainerId)) {
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

    public Trainer getTrainerDetailById(String trainerId) {
        Trainer trainer = new Trainer();

        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if(trainerDAO.trainerDetails.get(index).getID()
               .equals(trainerId)) {
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
            if(trainer.getID().equals(trainerDAO.trainerDetails.get(index)
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

    public void deleteTrainerById(String trainerId) {
        for(int index = 0; index < trainerDAO.trainerDetails.size(); index++) {
            if (trainerDAO.trainerDetails.get(index).getID()
                 .equals(trainerId)) {
                trainerDAO.deleteTrainerById(index);
            }
        }
    }
}