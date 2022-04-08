package edu.nus.iss.sg.day25.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.nus.iss.sg.day25.repository.LogInRepo;

@Service
public class LogInService {

    @Autowired
    private LogInRepo logInRepo;

    public boolean authenticate(String username, String password) {
        return logInRepo.queryUserAndPass(username, password);
    }

}