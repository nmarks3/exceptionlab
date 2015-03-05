package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException or a custom exception if the validation
 * fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    private static int maxVacationDays = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }

    public final int getDaysVacation() {
        return daysVacation;
    }
    /*
     Rules for validation: cannot be null or empty,
     cannot exceed maxVacationDays and cannot be less than 0
     */

    public final void setDaysVacation(int daysVacation) throws IllegalArgumentException {
        if (daysVacation > maxVacationDays || daysVacation < 0) {
            throw new IllegalArgumentException(
                    "Sorry daysVacation must be between 0 and maxVAcationDays");
        }
        this.daysVacation = daysVacation;
    }

    public final String getFirstName() {
        return firstName;
    }
    /*
     Rules for validation: cannot be null or empty,
     and msut be a minimum length of 2 and no longer 
     than 12 characters.
     */

    public final void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null
                || firstName.length() < 2 || firstName.length() > 12) {
            throw new IllegalArgumentException(
                    "firstName must be between 2 and 12 characters");
        }
        this.firstName = firstName;
    }

    public final Date getHireDate() {
        return hireDate;
    }

    public final void finalsetHireDate(Date hireDate) {

        this.hireDate = hireDate;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    // 333-33-3333
    // 333333333
    /*
     Rules for Validatin: null, empty, letters, length, 
     */
    public final void setSsn(String ssn) {
        if (ssn == null
                || ssn.length() != 9) {
            int hasHyphen = ssn.indexOf("-");
            if (hasHyphen > -1) {
                ssn.replaceAll("-", "");
            } else {
                throw new IllegalArgumentException();
            }
            char[] chars = ssn.toCharArray();
            for(char c : chars) {
                if(!Character.isDigit(c)) {
                    throw new IllegalArgumentException();
        }
        this.ssn = ssn;
    }
