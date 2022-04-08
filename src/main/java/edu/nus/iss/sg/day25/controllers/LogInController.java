package edu.nus.iss.sg.day25.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.nus.iss.sg.day25.services.LogInService;

@Controller
@RequestMapping(path="")
public class LogInController {

    @Autowired
    private LogInService logInSvc;
    
    @PostMapping(path="/authenticate")
    public ModelAndView postLogIn(@RequestBody MultiValueMap<String, String> form) {
        boolean result = logInSvc.authenticate(form.getFirst("username"), form.getFirst("password"));
        final ModelAndView mav = new ModelAndView();

        if(result) {
            mav.setViewName("welcome");
            mav.setStatus(HttpStatus.OK);
            mav.addObject("username", form.getFirst("username"));
        } else {
            mav.setViewName("forbidden");
            mav.setStatus(HttpStatus.FORBIDDEN);
            mav.addObject("errorMsg", "Incorrect username and password");
        }

        return mav;
    }
}
