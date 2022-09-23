package com.ideas2it.EmployeeDataManagment.controller;

import com.ideas2it.EmployeeDataManagment.exception.CustomException;
import com.ideas2it.EmployeeDataManagment.dao.TraineeDAO;
import com.ideas2it.EmployeeDataManagment.dao.TrainerDAO;
import com.ideas2it.EmployeeDataManagment.model.Trainee;
import com.ideas2it.EmployeeDataManagment.model.Trainer;
import com.ideas2it.EmployeeDataManagment.service.TraineeService;
import com.ideas2it.EmployeeDataManagment.service.TrainerService;
import com.ideas2it.EmployeeDataManagment.util.ValidationUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * This Class is Manipulate EmployeeData.
 * @version 2.0
 * @author  Arun Kumar M.
 */
public class EmployeeDataController {
    Scanner scanner = new Scanner(System.in);
    int select;
    Trainee trainee = new Trainee();
    Trainer trainer = new Trainer();
    TraineeService traineeService = new TraineeService();
    TrainerService trainerService = new TrainerService();
    Logger logger = LogManager.getLogger(EmployeeDataController.class);

    public static void main(String args[]) {
        boolean exit = true;
        int operation;

        EmployeeDataController controller = new EmployeeDataController();

        while (exit) {
            operation = controller.selectOperation();
            switch (operation) {
                case 1:
                    controller.addDetails();
                    break;

                case 2:
                    controller.readDetails();
                    break;

                case 3:
                    controller.updateDetails();
                    break;

                case 4:
                    controller.deleteDetails();
                    break;

                case 5:
                    exit = false;
                    break;

                default:
                    controller.warnMessage();
            }
        }
    }

    public int operation() {

    boolean isValidSelection = true;
    int operation = 1;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                logger.info("Enter the Operation ");
                operation = Integer.parseInt(scanner.nextLine());
                isValidSelection= false;
            } catch(NumberFormatException exception){
                logger.error("**INVALID** Entry. Enter the Number ---");
            }
        } while(isValidSelection);
        return operation;
    }

    public int selectOperation() {
        logger.info("Select any one Selection by Numeric Pointers."
                           +"\n1. Create \n2. Read"
                           + "\n3. Update \n4. Delete \n5. Exit");
        int operation = operation();
        return operation;
    }


    public String getID() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        String employeeId;

        do {
            logger.info("Enter your Employee ID: ");
            employeeId = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.employeeId, employeeId)) {
                if(traineeService.isPhoneNumberAlreadyExist(employeeId) &&
                    trainerService.isPhoneNumberAlreadyExist(employeeId)) {
                    isValid = false;
                    } else {
                        try {
                            throw new CustomException.ValueExistException("Employee-ID Already Exist ");
                        } catch (CustomException.ValueExistException error) {
                            logger.error(error);
                        }
                    }
                } else {
                    try {
                        throw new CustomException.InvalidInputException("In-valid Entry,"
                                                        + "Enter the Valid Employee-ID ");
                    } catch (CustomException.InvalidInputException error) {
                        logger.error(error);
                    }
                }
        } while (isValid);
        return employeeId;
    }

    public String getName() throws CustomException.InvalidInputException {
        boolean isValid = true;
        String name;

        do {
            logger.info("Enter your Name: ");
            name = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.namePattern, name)) {
                isValid = false;
            } else {
                try {
                    throw new CustomException.InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid Name");
                } catch(CustomException.InvalidInputException error) {
                   logger.error(error);
                }
            }
        } while (isValid);
        return name;
    }

    public String getPhoneNumber() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        String phoneNumber;

        do {
            logger.info("Enter your PhoneNumber: ");
            phoneNumber = scanner.nextLine();
                if (ValidationUtil.isValidDetail(ValidationUtil.phoneNumberPattern, phoneNumber)) {
                    if(traineeService.isPhoneNumberAlreadyExist(phoneNumber) &&
                       trainerService.isPhoneNumberAlreadyExist(phoneNumber)) {
                        isValid = false;
                    } else {
                        try {
                            throw new CustomException.ValueExistException("Phone Number Already Exist ");
                        } catch (CustomException.ValueExistException error) {
                            logger.error(error);
                        }
                    }
                } else {
                    try {
                        throw new CustomException.InvalidInputException("In-valid Entry,"
                                                        + "Enter the Valid Phone Number");
                    } catch (CustomException.InvalidInputException error) {
                        logger.error(error);
                    }
                }
        } while (isValid);

        return phoneNumber;
    }

    public String getEmail() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        String email;

        do {
            logger.info("Enter your Mail: ");
            email = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.emailPattern, email)) {
                if(traineeService.isPhoneNumberAlreadyExist(email) &&
                    trainerService.isPhoneNumberAlreadyExist(email)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException.ValueExistException("Email-ID Already Exist ");
                    } catch (CustomException.ValueExistException error) {
                        logger.error(error);
                    }
                }
            } else {
                try {
                    throw new CustomException.InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid Mail-ID");
                } catch (CustomException.InvalidInputException error) {
                    logger.error(error);
                }
            }
        } while (isValid);
        return email;
    }

    public String getBloodGroup() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean exit = true;
        String bloodGroup;

        do {
            logger.info("Enter your Blood Group: ");
            bloodGroup = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.bloodGroupPattern,
                                            bloodGroup)) {
                exit = false;
            } else {
                try {
                    throw new CustomException.InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid BloodGroup");
                } catch (CustomException.InvalidInputException error) {
                    logger.error(error);
                }
            }
        } while (exit);
        return bloodGroup;
    }

    public void addDetails() {

        do {
            logger.info("Select \n1. Trainer. \n2. Trainee."
                               + "\n3. Back-To-Main-Menu.");
            select = operation();

            switch (select) {
                case 1:
                    addTrainerDetail();
                    break;

                case 2:
                    addTraineeDetail();
                    break;

                case 3:
                    logger.info("Back-to-Main-Menu");
                    break;

                default:
                    warnMessage();
            }
        } while(select != 3);
    }

    public void addTrainerDetail() {

        try {
            Trainer trainer = new Trainer(getID(), getName(),
                                          getPhoneNumber(), getEmail(),
                                          getBloodGroup(),
                                          assignTrainee());
            trainerService.addTrainerDetail(trainer);
        } catch (CustomException.InvalidInputException error) {
            logger.error("In-valid Entry, Enter the Valid \n");
        } catch (CustomException.ValueExistException error) {
            logger.error("Phone Number Already Exist ");
        }
    }

    public void addTraineeDetail() {

        try {
            Trainee trainee = new Trainee(getID(), getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getBloodGroup());
            traineeService.addTraineeDetail(trainee);
        } catch (CustomException.InvalidInputException error) {
            logger.error("In-valid Entry, Enter the Valid ");
        } catch (CustomException.ValueExistException error) {
            logger.error("Phone Number Already Exist ");
        }
    }

    public List<Trainee> assignTrainee() {
        logger.info("Enter the Trainee ID: ");
        String traineeId = scanner.nextLine();
        List<Trainee> traineeList = new ArrayList<Trainee>();;

        if (traineeService.checkTraineeById(traineeId)) {
            trainee = traineeService.getTraineeDetailById(traineeId);
        } else {
            logger.info("No Details Found___");
            do {
                try {
                    assignTraineeSelection();
                    switch (select) {
                        case 1:
                            createNewTraineeDetail(traineeId);
                            traineeList.add(traineeService
                                            .getTraineeDetailById(traineeId));
                            break;

                        case 2:
                            if (traineeService.checkTraineeById(traineeId)) {
                                logger.info("No Details Found___");
                            } else {
                                traineeList.add(traineeService
                                                .getTraineeDetailById(traineeId));
                            }
                            break;

                        case 3:
                            logger.info("Assign Trainee Later");
                            break;

                        default:
                            warnMessage();
                    }
                } catch(NumberFormatException exception) {
                    logger.error("Enter the Valid Selection ---");
                }
            } while(select != 3);
        }
        return traineeList;
    }

    public int assignTraineeSelection() {
        logger.info(" Select to assign the trainee:" 
                           + "\n1--Create and Assign Trainee."
                           + "\n2--Assign Already Enrolled Trainee."
                           + "\n3--Assign Trainee Later.");
        select = operation();
        return select;
    }

    public Trainee createNewTraineeDetail(String traineeId) {
        try {
            logger.info("Create your Trainee Details");
            logger.info("Enter the Trainee ID: ");
            traineeId = scanner.nextLine();
            Trainee trainee = new Trainee(traineeId, getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getBloodGroup());
            traineeService.addTraineeDetail(trainee);
        } catch (CustomException.InvalidInputException error) {
            logger.error("In-valid Entry, Enter the Valid ");
        } catch (CustomException.ValueExistException error) {
            logger.error("Phone Number Already Exist ");
        }
        return trainee;
    }

    public void readDetails() {

        do {
            logger.info("Select to Read: \n1. Trainer." 
                               + "\n2. Trainee. \n3.Back-To-Main-Menu.");
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        logger.info("No Employee Details to Display.");
                    } else {
                        readTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        logger.info("No Employee Details to Display.");
                    } else {
                        readTraineeDetail();
                    }
                    break;

                case 3:
                    logger.info("Back-to-Main-Menu");
                    break;

                default:
                    warnMessage();
            }
        } while(select !=3);
    }

    public int readOperation() {
        logger.info("Trainer Details \3 ");
        logger.info("Select any one Operation by Numeric Pointers."
                           + "\n1. Read All. \n2. Read by ID."
                           + "\n9. Back-to-Main-Menu. \n\t\t\t0-Exit. ");
        int operation = operation();
        return operation;
    }

    public void readTraineeDetail() {
        boolean entry = true;
        select = operation();
        switch(select) {
            case 1:
                String trainees = traineeService
                                      .diplayAllTraineeDetails()
                                          .toString();
                logger.info(traineeService
                                       .getTraineeDetails(trainees));
                break;

            case 2:
                logger.info("Enter the Trainee ID: ");
                String traineeId = scanner.nextLine();
                if (traineeService.checkTraineeById(traineeId)) {
                    logger.info(traineeService
                                  .getTraineeDetailById(traineeId));
                } else {
                    logger.info("Employee Not Fount,"
                                       + "Enter valid ID");
                }
                break;

            case 9:
                entry = false;
                break;

            case 0:
                System.exit(0);
                break;

            default:
                warnMessage();
        }
    }

    public void readTrainerDetail() {
        boolean entry = true;

        while(entry) {
            select = operation();
            switch(select) {
                case 1:
                    String trainers = trainerService
                                          .diplayAllTrainerDetails()
                                              .toString();
                    logger.info(trainerService
                                           .getTrainerDetails(trainers));
                    break;

                case 2:
                    logger.info("Enter the Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    if(trainerService.checkTrainerById(trainerId)) {
                        logger.info(trainerService
                                           .getTrainerDetailById(trainerId));
                        String trainees = trainerService
                                              .getTrainerDetailById(trainerId)
                                              .getTrainee().toString();
                        if(trainees != null) {
                            logger.info(trainerService
                                               .getTraineeDetails(trainees));
                        }
                    } else {
                        logger.info("Employee Not Fount,"
                                           + "Enter valid ID");
                    }
                    break;

                case 9:
                    entry = false;
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    warnMessage();
            }
        }
    }


    public void updateDetails() {
        logger.info("Select \n1. Trainer. \n2. Trainee.");
        select = operation();

        switch (select) {
            case 1:
                if (trainerService.isTrainerListIsEmpty()) {
                    logger.info("No Employee Details to update.");
                } else {
                    trainerService.updateTrainer(updateTrainerDetail());
                }
                break;

            case 2:
                if (traineeService.isTraineeListIsEmpty()) {
                    logger.info("No Employee Details to update.");
                } else {
                    traineeService.updateTrainee(updateTraineeDetail());
                }
                break;

            default:
                warnMessage();
        }
    }

    public int updateTraineeOperation() {
        logger.info("Enter The Field to Update: \n1-Name."
                            + "\n2-PhoneNumber. \n3-Email."
                            + "\n4-BloodGroup. \n9-Back. \n0-Exit");
        int operation = operation();
        return operation;
    }

    public Trainee updateTraineeDetail() {
        boolean entry = true;
        logger.info("Enter the Trainee ID: ");
        String traineeId = scanner.nextLine();
        trainee = traineeService.getTraineeDetailById(traineeId);

        while(entry) {
            try {
                select = updateTraineeOperation();
                switch(select) {
                    case 1:
                        String name = getName();
                        trainee.setName(name);
                        break;

                    case 2:
                        String phoneNumber = getPhoneNumber();
                        trainee.setPhoneNumber(phoneNumber);
                        break;

                    case 3:
                        String email = getEmail();
                        trainee.setEmail(email);
                        break;

                    case 4:
                        String bloodGroup = getBloodGroup();
                        trainee.setBloodGroup(bloodGroup);
                        break;

                    case 9:
                        entry = false;
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        warnMessage();
                }
            } catch (CustomException.InvalidInputException error) {
                logger.error("In-valid Entry, Enter the Valid ");
            } catch (CustomException.ValueExistException error) {
                logger.error("Phone Number Already Exist ");
            }
        }        
        return trainee;
    }

    public int updateTrainerOperation() {
        logger.info("Enter The Field to Update: \n1-Name."
                            + "\n2-PhoneNumber. \n3-Email."
                            + "\n4-BloodGroup. \n5-Assign Trainee."
                            + "\n9-Back. \n0-Exit");
        int operation = operation();
        return operation;
    }

    public Trainer updateTrainerDetail() {
        boolean entry = true;
        logger.info("Enter the Trainer ID: ");
        String trainerId = scanner.nextLine();
        trainer = trainerService.getTrainerDetailById(trainerId);

        while(entry) {
            try {
                select = updateTrainerOperation();
                switch(select) {
                    case 1:
                        String name = getName();
                        trainer.setName(name);
                        break;

                    case 2:
                        String phoneNumber = getPhoneNumber();
                        trainer.setPhoneNumber(phoneNumber);
                        break;

                    case 3:
                        String email = getEmail();
                        trainer.setEmail(email);
                        break;

                    case 4:
                        String bloodGroup = getBloodGroup();
                        trainer.setBloodGroup(bloodGroup);
                        break;

                    case 5:
                        assignTrainee();
                        break;

                    case 9:
                        entry = false;
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        warnMessage();
                }
            } catch (CustomException.InvalidInputException error) {
                logger.error("In-valid Entry, Enter the Valid ");
            } catch (CustomException.ValueExistException error) {
                logger.error("Phone Number Already Exist ");
            }
        }
        return trainer;
    }

    public void deleteDetails() {
        try {
            logger.info("Select \n1. Trainer. \n2. Trainee.");
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        logger.info("No Employee Details to Delete.");
                    } else {
                        deleteTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        logger.info("No Employee Details to Delete.");
                    } else {
                        deleteTraineeDetail();
                    }
                    break;

                default:
                    warnMessage();
            }
        } catch(NumberFormatException exception) {
            logger.error("**INVALID** Selection. Enter the Valid Selection---");
        }
    }

    public void deleteTrainerDetail() {

        do {
            select = deleteOperation();
            switch(select) {
                case 1:
                    trainerService.deleteAllTrainer();
                    break;

                case 2:
                    logger.info("Enter the Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    trainerService.deleteTrainerById(trainerId);
                    break;

                case 9:
                    logger.info("Back-to-Main-Menu.");
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    warnMessage();
            }
        } while(select != 9);
    }

    public void deleteTraineeDetail() {

        do {
            select = deleteOperation();
            switch(select) {
                case 1:
                    traineeService.deleteAllTrainee();
                    logger.info("All Trainee Details Deleted.");
                    break;

                case 2:
                    logger.info("Enter Ther Trainee ID: ");
                    String traineeId = scanner.nextLine();
                    traineeService.deleteTraineeById(traineeId);
                    break;

                case 9:
                    logger.info("Back-to-Main-Menu.");
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    warnMessage();
            }
        } while(select != 9);
    }

    public int deleteOperation() {
        logger.info("Enter The Selection: \n1. Delete All."
                           + "\n2. Delete by ID. \n9. Back-to-Main-Menu."
                           + "\t\t\t0-Exit.");
        int operation = operation();
        return operation;
    }

    public void warnMessage() {

        logger.warn("*INVALID* Number Selected, try again!");
    }
}