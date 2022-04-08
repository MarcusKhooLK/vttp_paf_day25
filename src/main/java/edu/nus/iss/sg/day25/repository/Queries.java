package edu.nus.iss.sg.day25.repository;

public class Queries {
    public static final String SQL_SELECT_USER_BY_PASS = "select * from user where username = ? and password = sha1(?);";
}
