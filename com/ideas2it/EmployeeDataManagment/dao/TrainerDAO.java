package com.ideas2it.EmployeeDataManagment.dao;

import com.ideas2it.EmployeeDataManagment.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainerDAO {

    public List<Trainer> trainerDetails = new ArrayList<Trainer>();

    public void addTrainerDetails(Trainer trainer) {

        trainerDetails.add(trainer);
    }

    public List<Trainer> diplayAllTrainerDetails() {

        return trainerDetails;
    }

    public Trainer getTrainerDetailById(int index) {

        return trainerDetails.get(index);
    }

    public void updateTrainerDetails(int position, Trainer trainer) {

        trainerDetails.set(position, trainer);
    }

    public void deleteAllTrainerDetails() {

        trainerDetails.clear();
    }

    public void deleteTrainerById(int index) {

        trainerDetails.remove(index);
    }
}