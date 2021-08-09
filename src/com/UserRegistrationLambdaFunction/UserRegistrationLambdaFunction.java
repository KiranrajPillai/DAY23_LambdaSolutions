package com.UserRegistrationLambdaFunction;


import java.util.Random;
import java.util.RandomAccess;
import java.util.Scanner;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserIsValid {
    boolean mathPattern(String pattern, String name);
}

public class UserRegistrationLambdaFunction {
    static String namePattern1 = "^[A-Z]{1}+[a-z]{3,}$";
    static String namePattern2 = "^[A-Z]{1}+[a-z]{3,}$";
    static String emailPattern1 = "^[a-z]*([.]?[a-z]+)*@bl[.]co([.]?in)*";
    static String emailPattern2 = "[a-zA-Z0-9_.]*[-]*[+]*[0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
    static String phoneNumPattern = "^91\\s[6789][0-9]{9}";
    static String passWordPattern1 = "[a-zA-Z0-9_.]*[-]*[+]*[0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+";
    static String passWordPattern2 = "[A-Z]{1}[a-z]{5,}[0-9]{1}[!@#$%^&*~]{1}";

    UserIsValid checkValid = (String pattern, String name) -> Pattern.matches(pattern, name);

    public void nameIsValid(String name) throws UserRegistrationException{
        try {
            if ((checkValid.mathPattern(namePattern1, name)) || (checkValid.mathPattern(namePattern2, name))){
                System.out.println("Name Entered is Valid");
            }else {
                throw new UserRegistrationException("Name Entered is not Valid");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }

    public void eMailIsValid(String email) throws UserRegistrationException{
        try {
            if ( (checkValid.mathPattern(emailPattern1, email)) || (checkValid.mathPattern(emailPattern2, email)) ){
                System.out.println("Email-Id is Valid");
            }else {
                throw new UserRegistrationException("Email-Id is not Valid");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }


    public void phoneNumIsValid(String phonenum) throws UserRegistrationException{
        try {
            if (checkValid.mathPattern(phoneNumPattern, phonenum)){
                System.out.println("Mobile Number is Valid");
            }else {
                throw new UserRegistrationException("Mobile Number is not Valid");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }


    public void passWordIsValid(String password) throws UserRegistrationException{
        try {
            if ( (checkValid.mathPattern(passWordPattern1, password)) || (checkValid.mathPattern(passWordPattern2, password)) ){
                System.out.println("Password is Valid");
            }else {
                throw new UserRegistrationException("Password is not Valid");
            }
        }catch (UserRegistrationException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws UserRegistrationException {
        UserRegistrationLambdaFunction usr = new UserRegistrationLambdaFunction();
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        do {
            System.out.println("Welcome to User Registration Problem using LAMBDA");
            System.out.println("1: Enter First Name");
            System.out.println("2: Enter Last Name");
            System.out.println("3: Enter Email-ID");
            System.out.println("4: Enter Mobile Number");
            System.out.println("5: Enter Password");
            System.out.println("6: Exit");
            System.out.println("Enter to option : ");
            int opt = sc.nextInt();
            switch (opt){
                case 1:
                    System.out.println("Enter First Name : ");
                    String name =  sc.next();
                    usr.nameIsValid(name);
                    break;
                case 2:
                    System.out.println("Enter Last Name : ");
                    String LastName =  sc.next();
                    usr.nameIsValid(LastName);
                    break;
                case 3:
                    System.out.println("Enter EMail-Id : ");
                    String eMail =  sc.next();
                    usr.nameIsValid(eMail);
                    break;
                case 4:
                    System.out.println("Enter Mobile Number : ");
                    String phoneNum =  sc.next();
                    usr.nameIsValid(phoneNum);
                    break;
                case 5:
                    System.out.println("Enter Password : ");
                    String passWord =  sc.next();
                    usr.nameIsValid(passWord);
                    break;
                case 6:
                    flag = true;
                    break;
            }

        }
        while (flag);
    }
}