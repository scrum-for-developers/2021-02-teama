package de.codecentric.psd.worblehat.web.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.mockito.Mockito.mock;

public class NumericConstraintValidatorTest {

    private NumericConstraintValidator numericConstraintValidator;

    ConstraintValidatorContext constraintValidatorContext;

    @BeforeEach
    public void setUp() {
        numericConstraintValidator = new NumericConstraintValidator();
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void shouldReturnTrueIfBlank() {
        boolean actual = numericConstraintValidator.isValid("", constraintValidatorContext);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfNumeric() {
        boolean actual = numericConstraintValidator.isValid("1", constraintValidatorContext);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalsIfNotNumeric() {
        boolean actual = numericConstraintValidator.isValid("x", constraintValidatorContext);
        Assertions.assertFalse(actual);
    }
}
