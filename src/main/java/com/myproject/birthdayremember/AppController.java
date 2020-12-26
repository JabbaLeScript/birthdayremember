package com.myproject.birthdayremember;

import com.myproject.birthdayremember.links.PersonLink;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(PersonLink.BASE_URL)
public class AppController {

    @RequestMapping({"/"})
    public String loadUi(){
        return "welcolme to my UI";
    }
}
