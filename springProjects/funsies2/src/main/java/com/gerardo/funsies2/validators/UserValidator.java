package com.gerardo.funsies2.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gerardo.funsies2.models.User;
import com.gerardo.funsies2.services.UserService;

@Component
public class UserValidator implements Validator{
	
	private UserService userService;
	
	public UserValidator (UserService userService) {
		this.userService = userService;
	}

	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue ("passwordConfirmation", "Match");
        }
        User exists = userService.findByEmail(user.getEmail());
        if (exists != null) {
        	errors.rejectValue ("email", "Unique");
        }
    }
}
