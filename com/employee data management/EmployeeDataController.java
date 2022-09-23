import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Class is Manipulate EmployeeData.
 * @version 1.0
 * @author  Arun Kumar M.
 */
public class EmployeeDataController {
    Scanner scanner = new Scanner(System.in);
    int select;
    Trainee trainee = new Trainee();
    Trainer trainer = new Trainer();
    TraineeService traineeService = new TraineeService();
    TrainerService trainerService = new TrainerService();

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
                    System.out.println("*INVALID* Selection, try again!");
            }
        }
    }

    public int selectOperation() {
        System.out.println("Select any one Selection by Numeric Pointers."
                           +"\n1. Create \n2. Read"
                           + "\n3. Update \n4. Delete \n5. Exit");
        int operation = operation();
        return operation;
    }


    public String getID() {
        boolean isValid = true;
        String employeeId;

        do {
            System.out.print("Enter your Employee ID: \nI");
            employeeId = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.employeeId, employeeId)) {
                if(traineeService.isPhoneNumberAlreadyExist(employeeId) &&
                    trainerService.isPhoneNumberAlreadyExist(employeeId)) {
                    isValid = false;
                    } else {
                        try {
                            throw new ValueAlreadyExist("Input Already Exist ");
                        } catch (ValueAlreadyExist error) {
                            System.out.println(error);
                        }
                    }
                } else {
                    try {
                        throw new InvalidInputException("In-valid Entry,"
                                                        + "Enter the Valid ");
                    } catch (InvalidInputException error) {
                        System.out.println(error);
                    }
                }
        } while (isValid);
        return employeeId;
    }

    public String getName() throws InvalidInputException{
        boolean isValid = true;
        String name;

        do {
            System.out.println("Enter your Name: ");
            name = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.namePattern, name)) {
                isValid = false;
            } else {
                try {
                    throw new InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid ");
                } catch(InvalidInputException error) {
                   System.out.println(error);
                }
            }
        } while (isValid);
        return name;
    }

    public String getPhoneNumber() throws InvalidInputException, ValueAlreadyExist{
        boolean isValid = true;
        String phoneNumber;

        do {
            System.out.println("Enter your PhoneNumber: ");
            phoneNumber = scanner.nextLine();
                if (ValidationUtil.isValidDetail(ValidationUtil.phoneNumberPattern, phoneNumber)) {
                    if(traineeService.isPhoneNumberAlreadyExist(phoneNumber) &&
                       trainerService.isPhoneNumberAlreadyExist(phoneNumber)) {
                        isValid = false;
                    } else {
                        try {
                            throw new ValueAlreadyExist("Input Already Exist ");
                        } catch (ValueAlreadyExist error) {
                            System.out.println(error);
                        }
                    }
                } else {
                    try {
                        throw new InvalidInputException("In-valid Entry,"
                                                        + "Enter the Valid ");
                    } catch (InvalidInputException error) {
                        System.out.println(error);
                    }
                }
        } while (isValid);

        return phoneNumber;
    }

    public String getEmail() throws InvalidInputException, ValueAlreadyExist{
        boolean isValid = true;
        String email;

        do {
            System.out.println("Enter your Mail: ");
            email = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.emailPattern, email)) {
                if(traineeService.isPhoneNumberAlreadyExist(email) &&
                    trainerService.isPhoneNumberAlreadyExist(email)) {
                    isValid = false;
                } else {
                    try {
                        throw new ValueAlreadyExist("Input Already Exist ");
                    } catch (ValueAlreadyExist error) {
                        System.out.println(error);
                    }
                }
            } else {
                try {
                    throw new InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid ");
                } catch (InvalidInputException error) {
                    System.out.println(error);
                }
            }
        } while (isValid);
        return email;
    }

    public String getBloodGroup() {
        boolean exit = true;
        String bloodGroup;

        do {
            System.out.println("Enter your Blood Group: ");
            bloodGroup = scanner.nextLine();
            if(ValidationUtil.isValidDetail(ValidationUtil.bloodGroupPattern, bloodGroup)) {
                exit = false;
            } else {
                try {
                    throw new InvalidInputException("In-valid Entry,"
                                                    + "Enter the Valid ");
                } catch (InvalidInputException error) {
                    System.out.println(error);
                }
            }
        } while (exit);
        return bloodGroup;
    }

    public void addDetails() {

        do {
            System.out.println("Select \n1. Trainer. \n2. Trainee."
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
                    System.out.println("Back-to-Main-Menu");
                    break;

                default:
                    System.out.println("**INVALID** Selection, try again!");
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
        } catch (InvalidInputException error) {
            System.out.println("In-valid Entry, Enter the Valid ");
        } catch (ValueAlreadyExist error) {
            System.out.println("Phone Number Already Exist ");
        }
    }

    public void addTraineeDetail() {

        try {
            Trainee trainee = new Trainee(getID(), getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getBloodGroup());
            traineeService.addTraineeDetail(trainee);
        } catch (InvalidInputException error) {
            System.out.println("In-valid Entry, Enter the Valid ");
        } catch (ValueAlreadyExist error) {
            System.out.println("Phone Number Already Exist ");
        }
    }

    public List<Trainee> assignTrainee() {
        System.out.print("Enter the Trainee ID: \nI");
        String traineeId = scanner.nextLine();
        List<Trainee> traineeList = new ArrayList<Trainee>();;

        if (traineeService.checkTraineeById(traineeId)) {
            trainee = traineeService.getTraineeDetailById(traineeId);
        } else {
            System.out.println("No Details Found___");
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
                                System.out.println("No Details Found___");
                            } else {
                                traineeList.add(traineeService
                                                .getTraineeDetailById(traineeId));
                            }
                            break;

                        case 3:
                            System.out.println("Assign Trainee Later");
                            break;

                        default:
                            System.out.println("*INVALID* Selection, try again!");
                    }
                } catch(NumberFormatException exception) {
                    System.out.println("Enter the Valid Selection ---");
                }
            } while(select != 3);
        }
        return traineeList;
    }

    public int assignTraineeSelection() {
        System.out.println(" Select to assign the trainee:" 
                           + "\n1--Create and Assign Trainee."
                           + "\n2--Assign Already Enrolled Trainee."
                           + "\n3--Assign Trainee Later.");
        select = operation();
        return select;
    }

    public Trainee createNewTraineeDetail(String traineeId) {
        try {
            System.out.println("Create your Trainee Details");
            System.out.println("Enter the Trainee ID: \nI");
            traineeId = scanner.nextLine();
            Trainee trainee = new Trainee(traineeId, getName(), 
                                          getPhoneNumber(), getEmail(),
                                          getBloodGroup());
            traineeService.addTraineeDetail(trainee);
        } catch (InvalidInputException error) {
            System.out.println("In-valid Entry, Enter the Valid ");
        } catch (ValueAlreadyExist error) {
            System.out.println("Phone Number Already Exist ");
        }
        return trainee;
    }

    public void readDetails() {

        do {
            System.out.println("Select to Read: \n1. Trainer." 
                               + "\n2. Trainee. \n3.Back-To-Main-Menu.");
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        System.out.println("No Employee Details to Display.");
                    } else {
                        readTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        System.out.println("No Employee Details to Display.");
                    } else {
                        readTraineeDetail();
                    }
                    break;

                case 3:
                    System.out.println("Back-to-Main-Menu");
                    break;

                default:
                    System.out.println("**INVALID** Selection, try again!");
            }
        } while(select !=3);
    }

    public int readOperation() {
        System.out.println("Trainer Details \3 ");
        System.out.println("Select any one Operation by Numeric Pointers."
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
                System.out.println(traineeService
                                       .getTraineeDetails(trainees));
                break;

            case 2:
                System.out.println("Enter the Trainee ID: ");
                String traineeId = scanner.nextLine();
                if (traineeService.checkTraineeById(traineeId)) {
                    System.out.println(traineeService
                                           .getTraineeDetailById(traineeId));
                } else {
                    System.out.println("Employee Not Fount,"
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
                System.out.println("**INVALID** Selection, try again!");
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
                    System.out.println(trainerService
                                           .getTrainerDetails(trainers));
                    break;

                case 2:
                    System.out.println("Enter the Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    if(trainerService.checkTrainerById(trainerId)) {
                        System.out.println(trainerService
                                           .getTrainerDetailById(trainerId));
                        String trainees = trainerService
                                              .getTrainerDetailById(trainerId)
                                              .getTrainee().toString();
                        if(trainees != null) {
                            System.out.println(trainerService
                                               .getTraineeDetails(trainees));
                        }
                    } else {
                        System.out.println("Employee Not Fount,"
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
                    System.out.println("**INVALID** Selection, try again!");
            }
        }
    }


    public void updateDetails() {
        System.out.println("Select \n1. Trainer. \n2. Trainee.");
        select = operation();

        switch (select) {
            case 1:
                if (trainerService.isTrainerListIsEmpty()) {
                    System.out.println("No Employee Details to update.");
                } else {
                    trainerService.updateTrainer(updateTrainerDetail());
                }
                break;

            case 2:
                if (traineeService.isTraineeListIsEmpty()) {
                    System.out.println("No Employee Details to update.");
                } else {
                    traineeService.updateTrainee(updateTraineeDetail());
                }
                break;

            default:
                System.out.println("**INVALID** Selection, try again!");
        }
    }

    public int updateTraineeOperation() {
        System.out.println("Enter The Field to Update: \n1-Name."
                            + "\n2-PhoneNumber. \n3-Email."
                            + "\n4-BloodGroup. \n9-Back. \n0-Exit");
        int operation = operation();
        return operation;
    }

    public Trainee updateTraineeDetail() {
        boolean entry = true;
        System.out.println("Enter the Trainee ID: ");
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
                        System.out.println("*INVALID* Selection, try again!");
                }
            } catch (InvalidInputException error) {
                System.out.println("In-valid Entry, Enter the Valid ");
            } catch (ValueAlreadyExist error) {
                System.out.println("Phone Number Already Exist ");
            }
        }        
        return trainee;
    }

    public int updateTrainerOperation() {
        System.out.println("Enter The Field to Update: \n1-Name."
                            + "\n2-PhoneNumber. \n3-Email."
                            + "\n4-BloodGroup. \n5-Assign Trainee."
                            + "\n9-Back. \n0-Exit");
        int operation = operation();
        return operation;
    }

    public Trainer updateTrainerDetail() {
        boolean entry = true;
        System.out.println("Enter the Trainer ID: ");
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
                        System.out.println("*INVALID* Selection, try again!");
                }
            } catch (InvalidInputException error) {
                System.out.println("In-valid Entry, Enter the Valid ");
            } catch (ValueAlreadyExist error) {
                System.out.println("Phone Number Already Exist ");
            }
        }
        return trainer;
    }

    public void deleteDetails() {
        try {
            System.out.println("Select \n1. Trainer. \n2. Trainee.");
            select = operation();

            switch (select) {
                case 1:
                    if (trainerService.isTrainerListIsEmpty()) {
                        System.out.println("No Employee Details to Delete.");
                    } else {
                        deleteTrainerDetail();
                    }
                    break;

                case 2:
                    if (traineeService.isTraineeListIsEmpty()) {
                        System.out.println("No Employee Details to Delete.");
                    } else {
                        deleteTraineeDetail();
                    }
                    break;

                default:
                    System.out.println("**INVALID** Selection, try again!");
            }
        } catch(NumberFormatException exception) {
            System.out.println("Enter the Valid Selection ---");
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
                    System.out.println("Enter the Trainer ID: ");
                    String trainerId = scanner.nextLine();
                    trainerService.deleteTrainerById(trainerId);
                    break;

                case 9:
                    System.out.println("Back-to-Main-Menu.");
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("**INVALID** Selection, try again!");
            }
        } while(select != 9);
    }

    public void deleteTraineeDetail() {

        do {
            select = deleteOperation();
            switch(select) {
                case 1:
                    traineeService.deleteAllTrainee();
                    System.out.println("All Trainee Details Deleted.");
                    break;

                case 2:
                    System.out.println("Enter Ther Trainee ID: ");
                    String traineeId = scanner.nextLine();
                    traineeService.deleteTraineeById(traineeId);
                    break;

                case 9:
                    System.out.println("Back-to-Main-Menu.");
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("**INVALID** Selection, try again!");
            }
        } while(select != 9);
    }

    public int deleteOperation() {
        System.out.println("Enter The Selection: \n1. Delete All."
                           + "\n2. Delete by ID. \n9. Back-to-Main-Menu."
                           + "\t\t\t0-Exit.");
        int operation = operation();
        return operation;
    }

    public int operation() {

    boolean isValidSelection = false;
    int operation = 0;

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                operation = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException exception){
                System.out.println("Enter the Valid Number ---");
            }
        } while(isValidSelection);
        return operation;
    }
}