package com.ideas2it.EmployeeDataManagment.constant;

public class Constant {

    public static final String EMPLOYEE_ID_PATTERN = "[1-9]+[0-9]*";
    public static final String NAME_PATTERN = "(([A-Za-z]+)[ ]?([A-Za-z]*)[ ]?([A-Za-z]*)){2}";
    public static final String PHONE_NUMBER_PATTERN = "[6-9][0-9]{9}";
    public static final String EMAIL_PATTERN = "[a-z0-9_\\.]{2,}[@]{1}[a-z]+[\\.]{1}([a-z]{3}|([a-z]{3}[\\.][a-z]{2,3}))";
    public static final String BLOODGROUP_PATTERN = "(([ABO]|([A][B]))[+-])";
    public static final String EXPERIENCE_PATTERN = "([123]?[0-9]?[\\.]?[0-9]?[0-9])";
    public static final String EMPLOYEE_DATA_MANAGEMENT_MAIN_MENU = "Select any one Selection by Numeric Pointers.\n1. Create \n2. View\n3. Update \n4. Delete \n5. Exit";
    public static final String EMPLOYEE_DATA_MANAGEMENT_MENU_OPERATION = "Enter the Operation --";
    public static final String INVALID_INPUT = "In-valid input, enter a valid input ---";
    public static final String EMPLOYEE_ID_EXIST = "Employee-id already exist ";
    public static final String EMPLOYEE_ID = "Enter your employee id: ";
    public static final String VALID_EMPLOYEE_ID = "EmployeeID must be in numbers only----";
    public static final String EMPLOYEE_NAME = "Enter your Name: ";
    public static final String EMPLOYEE_PHONE_NUMBER = "Enter your PhoneNumber [Number should only in 10 digits]: ";
    public static final String EMPLOYEE_PHONE_NUMBER_EXIST = "Phone Number Exist ";
    public static final String VALID_EMPLOYEE_PHONE_NUMBER = "Enter Phone Number in Numbers only----";
    public static final String EMPLOYEE_EMAIL = "Enter your Mail: ";
    public static final String EMPLOYEE_EMAIL_EXIST = "Email-ID Exist ";
    public static final String EMPLOYEE_BLOOD_GROUP = "Enter your Blood Group[Blood Group - A+/-, B+/-, O+/-, AB+/-]: ";
    public static final String EMPLOYEE_DATE_OF_BIRTH = "Enter the Date of Birth in YYYY-MM-DD fromat[Between 18-60 age limit]:";
    public static final String EMPLOYEE_EXPERIENCE = "Enter your Experience: ";
    public static final String VALID_EMPLOYEE_EXPERIENCE = "Experience must be in numbers only---";
    public static final String EMPLOYEE_ROLE = "Select \n1. Trainer. \n2. Trainee. \n3. Back-To-Main-Menu.";
    public static final String BACK_TO_MENU = "Back-to-Main-Menu";
    public static final String ASSIGN_TRIANEE_MENU = "Select to assign the trainee:\n1--Create and assign Trainee.\n2--Assign already enrolled Trainee.\n3--Assign Trainee later.";
    public static final String EMPLOYEE_NOT_FOUND = "Employee-not found_____";
    public static final String EMPLOYEE_LIST_NOT_FOUND = "No Employee Details to Display.";
    public static final String ASSIGN_LATER = "Assign Trainee Later";
    public static final String VALID_ASSIGN_OPERATION = "Enter the Valid Selection ---";
    public static final String READ_OPERATION_MENU = "Select any one Operation by Numeric Pointers.\n1. View All. \n2. View by ID.\n9. Back. \n\t\t\t0-Exit. ";
    public static final String TRAINEE_ID = "Enter the Trainee ID: ";
    public static final String TRAINER_ID = "Enter the Trainer ID: ";
    public static final String ID_NOT_FOUND = "Employee not found, Enter valid id...";
    public static final String TRAINEE_UPDATE_OPERATION = "Enter The Field to Update: \n1-Name. \n2-PhoneNumber. \n3-Email. \n4-BloodGroup. \n5-Date-of-Birth. \n9-Back. \n0-Exit";
    public static final String TRAINER_UPDATE_OPERATION = "Enter The Field to Update: \n1-Name. \n2-PhoneNumber. \n3-Email. \n4-BloodGroup. \n5-Date-of-Birth. \n6-Experience. \n7-Assign Trainee. \n9-Back. \n0-Exit";
    public static final String DELETE_OPERATION_MENU = "Enter The Selection: \n1. Delete All. \n2. Delete by ID. \n9. Back-to-Main-Menu. \t\t\t0-Exit.";
    public static final String DEFAULT_MESSAGE = "*INVALID* Number Selected, try again!";
}