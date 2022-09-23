package com.ideas2it.EmployeeDataManagment.dao;

import java.util.ArrayList;
import java.util.List;

public class TraineeDAO {
    List<Trainee> traineeDetails = new ArrayList<Trainee>();

    public void addTraineeDetails(Trainee trainee) {

        traineeDetails.add(trainee);
    }

    public List<Trainee> diplayAllTraineeDetails() {

        return traineeDetails;
    }

    public Trainee getTraineeDetailById(int index) {

        return traineeDetails.get(index);
    }

    public void updateTraineeDetails(int position, Trainee trainee) {

        traineeDetails.set(position, trainee);
    }

    public void deleteAllTraineeDetails() {

        traineeDetails.clear();
    }

    public void deleteTraineeById(int index) {

        traineeDetails.remove(index);
    }
}