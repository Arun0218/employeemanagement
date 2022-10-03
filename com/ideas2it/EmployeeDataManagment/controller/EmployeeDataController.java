package com.ideas2it.EmployeeDataManagment.controller;

import com.ideas2it.EmployeeDataManagment.exception.CustomException;
import com.ideas2it.EmployeeDataManagment.model.Trainee;
import com.ideas2it.EmployeeDataManagment.model.Trainer;
import com.ideas2it.EmployeeDataManagment.service.TraineeService;
import com.ideas2it.EmployeeDataManagment.service.TrainerService;
import com.ideas2it.EmployeeDataManagment.util.ValidationUtil;
import com.ideas2it.EmployeeDataManagment.constant.Constant;

import java.time.format.DateTimeParseException;
import java.time.LocalDate;
import java.time.Period;
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
    TraineeService traineeService = new TraineeService();
    TrainerService trainerService = new TrainerService();
    Logger logger = LogManager.getLogger(EmployeeDataController.class);

    public static void main(String args[]) {
        int operation;
        EmployeeDataController controller = new EmployeeDataController();

        do {
            operation = controller.selectOperation();
            switch (operation) {
                case 1:
                    controller.addDetails();
                    break;

                case 2:
                    controller.viewDetails();
                    break;

                case 3:
                    controller.updateDetails();
                    break;

                case 4:
                    controller.deleteDetails();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    controller.defaultMessage();
            }
        } while(operation != 5);
    }

    public int operation() {
        boolean isValidSelection = true;
        int operation = 1;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                logger.info(Constant.EMPLOYEE_DATA_MANAGEMENT_MENU_OPERATION);
                operation = Integer.parseInt(scanner.nextLine());
                isValidSelection= false;
            } catch(NumberFormatException exception){
                logger.error(Constant.INVALID_INPUT);
            }
        } while(isValidSelection);
        return operation;
    }

    public int selectOperation() {
        int operation;
        logger.info(Constant.EMPLOYEE_DATA_MANAGEMENT_MAIN_MENU);
        operation = operation();
        return operation;
    }


    public int getID() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        int employeeId;

        do {
            logger.info(Constant.EMPLOYEE_ID);
            employeeId = isValidEmployeeId();
            if(ValidationUtil.isValidInput(Constant.EMPLOYEE_ID_PATTERN, employeeId)) {
                if(traineeService.isEmployeeIdExist(employeeId) &&
                    trainerService.isEmployeeIdExist(employeeId)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException
                            .ValueExistException(Constant.EMPLOYEE_ID_EXIST);
                    } catch (CustomException.ValueExistException error) {
                        logger.info(error.getMessage());
                    } 
                }
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while (isValid);
        return employeeId;
    }

    public int isValidEmployeeId() {
        boolean isValid = true;
        int id = 0;

        do {
            try {
                id = Integer.parseInt(scanner.nextLine());
                isValid = false;
            } catch(NumberFormatException exception) {
                logger.error(Constant.VALID_EMPLOYEE_ID);
                isValid = true;
            }
        } while(isValid);
    return id;
    }

    public String getName() throws CustomException.InvalidInputException {
        boolean isValid = true;
        String name;

        do {
            logger.info(Constant.EMPLOYEE_NAME);
            name = scanner.nextLine();
            if(ValidationUtil.isValidInput(Constant.NAME_PATTERN, name)) {
                isValid = false;
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while (isValid);
        return name;
    }

    public long getPhoneNumber() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        long phoneNumber;

        do {
            logger.info(Constant.EMPLOYEE_PHONE_NUMBER);
            phoneNumber = isValidPhoneNumber();
            if (ValidationUtil.isValidInput(Constant.PHONE_NUMBER_PATTERN,
                                             phoneNumber)) {
                if(traineeService.isPhoneNumberExist(phoneNumber) &&
                   trainerService.isPhoneNumberExist(phoneNumber)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException
                            .ValueExistException(Constant
                                             .EMPLOYEE_PHONE_NUMBER_EXIST);
                    } catch (CustomException.ValueExistException error) {
                        logger.info(error.getMessage());
                    } 
                }
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while (isValid);

        return phoneNumber;
    }

    public long isValidPhoneNumber() {
        boolean isValid = true;
        long phoneNumber = 0;

        do {
            try {
                phoneNumber = Long.parseLong(scanner.nextLine());
                isValid = false;
            } catch(NumberFormatException exception) {
                logger.error(Constant.VALID_EMPLOYEE_PHONE_NUMBER);
                isValid = true;
            }
        } while(isValid);
    return phoneNumber;
    }

    public String getEmail() throws CustomException.InvalidInputException,
                 CustomException.ValueExistException {
        boolean isValid = true;
        String email;

        do {
            logger.info(Constant.EMPLOYEE_EMAIL);
            email = scanner.nextLine();
            if(ValidationUtil.isValidInput(Constant.EMAIL_PATTERN, email)) {
                if(traineeService.isEmailExist(email) &&
                    trainerService.isEmailExist(email)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException
                           .ValueExistException(Constant.EMPLOYEE_EMAIL_EXIST);
                    } catch (CustomException.ValueExistException error) {
                        logger.info(error.getMessage());
                    } 
                }
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while (isValid);
        return email;
    }

    public String getBloodGroup() throws CustomException.InvalidInputException {
        boolean isValid = true;
        String bloodGroup;

        do {
            logger.info(Constant.EMPLOYEE_BLOOD_GROUP);
            bloodGroup = scanner.nextLine();
            if(ValidationUtil.isValidInput(Constant.BLOODGROUP_PATTERN,
                                             bloodGroup)) {
                isValid = false;
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while (isValid);
        return bloodGroup;
    }

    public LocalDate getTrainerDateOfBirth()
                   throws CustomException.InvalidInputException {
        boolean isValid = true;
        LocalDate dateOfBirth;

        do {
            logger.info(Constant.EMPLOYEE_DATE_OF_BIRTH);
            String birthDay = scanner.nextLine();
            dateOfBirth = getDateOfBirth(birthDay);
            if(dateOfBirth != null) {
                if(trainerService.isValidDateOfBirth(dateOfBirth)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                    } catch (CustomException.InvalidInputException error) {
                        logger.error(Constant.INVALID_INPUT);
                    }
                }
            } else {
                isValid = true;
            }
        } while(isValid);
        return dateOfBirth;
    }

    public LocalDate getTraineeDateOfBirth()
                     throws CustomException.InvalidInputException {
        boolean isValid = true;
        LocalDate dateOfBirth;
        String birthDay;

        do {
            logger.info(Constant.EMPLOYEE_DATE_OF_BIRTH);
            birthDay = scanner.nextLine();
            dateOfBirth = getDateOfBirth(birthDay);
            if(dateOfBirth != null) {
                if(traineeService.isValidDateOfBirth(dateOfBirth)) {
                    isValid = false;
                } else {
                    try {
                        throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                    } catch (CustomException.InvalidInputException error) {
                        logger.error(Constant.INVALID_INPUT);
                    }
                }
            } else {
                isValid = true;
            }
        } while(isValid);
        return dateOfBirth;
    }


    public LocalDate getDateOfBirth(String birthDay) {
        LocalDate dateOfBirth = null;

        try {
            dateOfBirth = LocalDate.parse(birthDay);
        } catch (DateTimeParseException dateException) {
            logger.error(Constant.INVALID_INPUT);
        }
        return dateOfBirth;
    }

    public float getExperience() throws CustomException.InvalidInputException {
        boolean isValid = true;
        float experience;

        do {
            logger.info(Constant.EMPLOYEE_EXPERIENCE);
            experience = isValidExperience();
            if(ValidationUtil.isValidInput(Constant.EXPERIENCE_PATTERN,
                                            experience)) {
                isValid = false;
            } else {
                try {
                    throw new CustomException
                           .InvalidInputException(Constant.INVALID_INPUT);
                } catch (CustomException.InvalidInputException error) {
                    logger.error(Constant.INVALID_INPUT);
                }
            }
        } while(isValid);
        return experience;
    }

    public float isValidExperience() {
        boolean isValid = true;
        float experience = 0;

        do {
            try {
                experience = Float.parseFloat(scanner.nextLine());
                isValid = false;
            } catch(NumberFormatException exception) {
                logger.error(Constant.VALID_EMPLOYEE_EXPERIENCE);
                isValid = true;
            }
        } while(isValid);
        return experience;
    }

    public void addDetails() {

        do {
            logger.info(Constant.EMPLOYEE_ROLE);
            select = operation();

            switch (select) {
                case 1:
                    addTrainerDetail();
                    break;

                case 2:
                    addTraineeDetail();
                    break;

                case 3:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 3);
    }

    public void addTrainerDetail() {

        try {
            Trainer trainer = new Trainer(getID(), getName(),
                                          getPhoneNumber(), getEmail(),
                                          getTrainerDateOfBirth(),
                                          getExperience(),
                                          getBloodGroup());
            trainer.setAge(trainerService.getAge(trainer.getDateOfBirth()));
            trainerService.addTrainerDetail(trainer);
            trainer.setTrainee(assignTrainee());
            trainerService.updateTrainer(trainer);
        } catch (CustomException.InvalidInputException error) {
            logger.error(Constant.INVALID_INPUT);
        } catch (CustomException.ValueExistException error) {
            logger.info(error.getMessage());
        }
    }

    public void addTraineeDetail() {

        try {
            Trainee trainee = new Trainee(getID(), getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getTraineeDateOfBirth(),
                                          getBloodGroup());
            trainee.setAge(traineeService.getAge(trainee.getDateOfBirth()));
            traineeService.addTraineeDetail(trainee);
        } catch (CustomException.InvalidInputException error) {
            logger.error(Constant.INVALID_INPUT);
        } catch (CustomException.ValueExistException error) {
            logger.info(error.getMessage());
        }
    }

    public List<Trainee> assignTrainee() {
        List<Trainee> traineeList = new ArrayList<Trainee>();
        int traineeId = 0;
        int employeeId;

        do {
            try {
                assignTraineeSelection();
                switch (select) {
                    case 1:
                        Trainee trainee = createNewTraineeDetail();
                        traineeList.add(trainee);
                        break;

                    case 2:
                        logger.info(Constant.EMPLOYEE_ID);
                        employeeId = isValidEmployeeId();

                        if (traineeService.checkTraineeById(traineeId)) {
                            logger.info(Constant.EMPLOYEE_NOT_FOUND);
                        } else {
                            traineeList.add(traineeService
                                            .getTraineeDetailById(traineeId));
                        }
                        break;

                    case 3:
                        logger.info(Constant.ASSIGN_LATER);
                        break;

                    default:
                        defaultMessage();
                }
            } catch(NumberFormatException exception) {
                logger.error(Constant.VALID_ASSIGN_OPERATION);
            }
        } while(select != 3);
        return traineeList;
    }

    public int assignTraineeSelection() {
        logger.info(Constant.ASSIGN_TRIANEE_MENU);
        select = operation();
        return select;
    }

    public Trainee createNewTraineeDetail() {
        Trainee trainee = null;

        try {
            trainee = new Trainee(getID(), getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getTraineeDateOfBirth(),
                                          getBloodGroup());
            trainee.setAge(traineeService.getAge(trainee.getDateOfBirth()));
            traineeService.addTraineeDetail(trainee);
        } catch (CustomException.InvalidInputException error) {
            logger.error(Constant.INVALID_INPUT);
        } catch (CustomException.ValueExistException error) {
            logger.info(error.getMessage());
        }
        return trainee;
    }

    public void viewDetails() {

        do {
            logger.info(Constant.EMPLOYEE_ROLE);
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                        viewTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                        viewTraineeDetail();
                    }
                    break;

                case 3:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 3);
    }

    public int viewOperation() {
        int operation;

        logger.info(Constant.READ_OPERATION_MENU);
        operation = operation();
        return operation;
    }

    public void viewTraineeDetail() {

        do {
            select = viewOperation();
            int traineeId;

            switch(select) {
                case 1:
                    String trainees = traineeService
                                          .getAllTraineeDetails()
                                              .toString();
                    logger.info(traineeService
                                           .getTraineeDetails(trainees));
                    break;

                case 2:
                    logger.info(Constant.TRAINEE_ID);
                    traineeId = isValidEmployeeId();
                    if (traineeService.checkTraineeById(traineeId)) {
                        logger.info(traineeService
                                      .getTraineeDetailById(traineeId));
                    } else {
                        logger.info(Constant.ID_NOT_FOUND);
                    }
                    break;

                case 9:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 9);
    }

    public void viewTrainerDetail() {

        do {
            select = viewOperation();

            switch(select) {
                case 1:
                    String trainers = trainerService
                                          .getAllTrainerDetails()
                                              .toString();
                    logger.info(trainerService.getTraineeDetails(trainers));
                    break;

                case 2:
                    logger.info(Constant.TRAINER_ID);
                    int trainerId = isValidEmployeeId();
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
                        logger.info(Constant.ID_NOT_FOUND);
                    }
                    break;

                case 9:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 9);
    }


    public void updateDetails() {

        do {
            logger.info(Constant.EMPLOYEE_ROLE);
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                       trainerService.updateTrainer(updateTrainerDetail());
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                        traineeService.updateTrainee(updateTraineeDetail());
                    }
                    break;

                case 3:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 3);
    }

    public int updateTraineeOperation() {
        int operation;
        logger.info(Constant.TRAINEE_UPDATE_OPERATION);
        operation = operation();
        return operation;
    }

    public Trainee updateTraineeDetail() {
        logger.info(Constant.TRAINEE_ID);
        int traineeId = isValidEmployeeId();
        Trainee trainee = traineeService.getTraineeDetailById(traineeId);

        do {
            try {
                select = updateTraineeOperation();
                switch(select) {
                    case 1:
                        trainee.setName(getName());
                        break;

                    case 2:
                        trainee.setPhoneNumber(getPhoneNumber());
                        break;

                    case 3:
                        trainee.setEmail(getEmail());
                        break;

                    case 4:
                        trainee.setBloodGroup(getBloodGroup());
                        break;

                    case 5:
                        trainee.setDateOfBirth(getTrainerDateOfBirth());
                        trainee.setAge(traineeService
                                       .getAge(trainee.getDateOfBirth()));
                        break;

                    case 9:
                        logger.info(Constant.BACK_TO_MENU);
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        defaultMessage();
                }
            } catch (CustomException.InvalidInputException error) {
                logger.error(Constant.INVALID_INPUT);
            } catch (CustomException.ValueExistException error) {
                logger.info(error.getMessage());
            }
        } while(select != 9);
        return trainee;
    }

    public int updateTrainerOperation() {
        int operation;

        logger.info(Constant.TRAINER_UPDATE_OPERATION);
        operation = operation();
        return operation;
    }

    public Trainer updateTrainerDetail() {
        int trainerId;

        logger.info(Constant.TRAINER_ID);
        trainerId = isValidEmployeeId();
        Trainer trainer = trainerService.getTrainerDetailById(trainerId);

        do {
            try {
                select = updateTrainerOperation();
                switch(select) {
                    case 1:
                        trainer.setName(getName());
                        break;

                    case 2:
                        trainer.setPhoneNumber(getPhoneNumber());
                        break;

                    case 3:
                        trainer.setEmail(getEmail());
                        break;

                    case 4:
                        trainer.setBloodGroup(getBloodGroup());
                        break;

                    case 5:
                        trainer.setDateOfBirth(getTrainerDateOfBirth());
                        trainer.setAge(trainerService
                                      .getAge(trainer.getDateOfBirth()));
                        break;

                    case 6:
                        trainer.setExperience(getExperience());
                        break;

                    case 7:
                        assignTrainee();
                        break;

                    case 9:
                        logger.info(Constant.BACK_TO_MENU);
                        break;

                    case 0:
                        System.exit(0);
                        break;

                    default:
                        defaultMessage();
                }
            } catch (CustomException.InvalidInputException error) {
                logger.error(Constant.INVALID_INPUT);
            } catch (CustomException.ValueExistException error) {
                logger.info(error.getMessage());
            }
        } while (select != 9);
        return trainer;
    }

    public void deleteDetails() {

        do {
            logger.info(Constant.EMPLOYEE_ROLE);
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                        deleteTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        logger.info(Constant.EMPLOYEE_LIST_NOT_FOUND);
                    } else {
                        deleteTraineeDetail();
                    }
                    break;

                case 3:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 3);
    }

    public void deleteTrainerDetail() {
        int trainerId;

        do {
            select = deleteOperation();
            switch(select) {
                case 1:
                    trainerService.deleteAllTrainer();
                    break;

                case 2:
                    logger.info(Constant.TRAINER_ID);
                    trainerId = isValidEmployeeId();
                    trainerService.deleteTrainerById(trainerId);
                    break;

                case 9:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 9);
    }

    public void deleteTraineeDetail() {
        int traineeId;

        do {
            select = deleteOperation();
            switch(select) {
                case 1:
                    traineeService.deleteAllTrainee();
                    break;

                case 2:
                    logger.info(Constant.TRAINEE_ID);
                    traineeId = isValidEmployeeId();
                    traineeService.deleteTraineeById(traineeId);
                    break;

                case 9:
                    logger.info(Constant.BACK_TO_MENU);
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    defaultMessage();
            }
        } while(select != 9);
    }

    public int deleteOperation() {
        int operation;

        logger.info(Constant.DELETE_OPERATION_MENU);
        operation = operation();
        return operation;
    }

    public void defaultMessage() {
        logger.warn(Constant.DEFAULT_MESSAGE);
    }
}