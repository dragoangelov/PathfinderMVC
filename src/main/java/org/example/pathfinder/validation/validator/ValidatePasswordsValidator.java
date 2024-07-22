package org.example.pathfinder.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.pathfinder.validation.annotation.ValidatePasswords;
import org.example.pathfinder.web.dto.UserRegisterDTO;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class ValidatePasswordsValidator implements ConstraintValidator<ValidatePasswords, UserRegisterDTO> {

    private String message;

    @Override
    public void initialize(ValidatePasswords constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterDTO dto, ConstraintValidatorContext constraintValidatorContext) {
        if (dto.getPassword() == null || dto.getConfirmPassword() == null) {
            return true;
        }

        boolean isValid = dto.getPassword().equals(dto.getConfirmPassword());

        if (!isValid) {
            constraintValidatorContext
                    .unwrap(HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
