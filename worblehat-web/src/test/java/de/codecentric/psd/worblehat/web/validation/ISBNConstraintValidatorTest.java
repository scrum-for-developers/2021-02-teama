package de.codecentric.psd.worblehat.web.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.mockito.Mockito.mock;

public class ISBNConstraintValidatorTest {

    private ISBNConstraintValidator isbnConstraintValidator;

    private ConstraintValidatorContext constraintValidatorContext;

    @BeforeEach
    public void setUp() {
        isbnConstraintValidator = new ISBNConstraintValidator();
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
    }

    @Test
    public void shouldReturnTrueIfBlank() {
        boolean actual = isbnConstraintValidator.isValid("", constraintValidatorContext);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfValidISBN() {
        boolean actual = isbnConstraintValidator.isValid("0132350882", constraintValidatorContext);
        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseIfInvalidISBN() {
        boolean actual = isbnConstraintValidator.isValid("0123459789", constraintValidatorContext);
        Assertions.assertFalse(actual);
    }
}
