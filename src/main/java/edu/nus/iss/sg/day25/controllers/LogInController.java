package edu.nus.iss.sg.day25.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/authenticate/logout")
    public String getLogOut(HttpSession session) {
        System.out.println("HELLO");
        session.invalidate();
        return "index";
    }
    
    @PostMapping(path="/authenticate")
    public ModelAndView postLogIn(@RequestBody MultiValueMap<String, String> form, HttpSession session) {
        boolean result = logInSvc.authenticate(form.getFirst("username"), form.getFirst("password"));
        final ModelAndView mav = new ModelAndView();

        if(result) {
            session.setAttribute("name", form.getFirst("username"));
            return new ModelAndView("redirect:/protected/welcome");
        } else {
            mav.setViewName("forbidden");
            mav.setStatus(HttpStatus.UNAUTHORIZED);
            mav.addObject("errorMsg", "Incorrect username and password");
        }

        return mav;
    }
}
