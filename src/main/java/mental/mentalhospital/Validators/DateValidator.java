package mental.mentalhospital.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DateConstraint, String>{
	@Override
	public void initialize(DateConstraint dateConstraint) {
		
	}
	@Override
	public boolean isValid(String dateField, ConstraintValidatorContext cxt) {
		return dateField != null && dateField.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
	}
	
}
