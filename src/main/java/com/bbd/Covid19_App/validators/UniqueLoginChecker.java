package com.bbd.Covid19_App.validators;

import com.bbd.Covid19_App.dao.UserRepository;
import com.bbd.Covid19_App.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueLoginChecker implements ConstraintValidator<UniqueLogin, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        User user = userRepository.findByLogin(login);
        return (user == null ? true : false);
    }
}
