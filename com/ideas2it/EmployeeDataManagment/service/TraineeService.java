package com.ideas2it.EmployeeDataManagment.service;

import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;

import java.util.List;

public class TraineeService {

    TraineeDAO traineeDAO = new TraineeDAO();

    public boolean isTraineeListIsEmpty() {

        return traineeDAO.traineeDetails.isEmpty();
    }

    public boolean isPhoneNumberAlreadyExist(String phoneNumber) {

        boolean isExist = true;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getPhoneNumber()
                   .equals(phoneNumber)) {
                isExist = false;
            }
        }
        return isExist;
    }

    public boolean isEmployeeIdAlreadyExist(String employeeId) {

        boolean isExist = true;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getID()
                   .equals(employeeId)) {
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

    public void addTraineeDetail(Trainee trainee) {

        traineeDAO.addTraineeDetails(trainee);
    }

    public List<Trainee> diplayAllTraineeDetails() {

        return traineeDAO.diplayAllTraineeDetails();
    }    

    public boolean checkTraineeById(String traineeId) {

        boolean isValid = false;

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if(traineeDAO.traineeDetails.get(index).getID().equals(traineeId)) {
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

    public Trainee getTraineeDetailById(String traineeId) {
        Trainee trainee = new Trainee();

        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (traineeDAO.traineeDetails.get(index).getID()
                .equals(traineeId)) {
                trainee = traineeDAO.getTraineeDetailById(index);
            }
        }
        return trainee;
    }

    public int getTraineePositionById(Trainee trainee) {
        int position = 0;
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (trainee.getID().equals(traineeDAO.traineeDetails.get(index)
                                       .getID())) {
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

    public void deleteTraineeById(String traineeId) {
        for(int index = 0; index < traineeDAO.traineeDetails.size(); index++) {
            if (traineeDAO.traineeDetails.get(index).getID()
                .equals(traineeId)) {
                traineeDAO.deleteTraineeById(index);
            }
        }
    }

}