package mental.mentalhospital.Validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateCompareValidator implements ConstraintValidator<DateCompare, Object>{
	private String arrivalDate;
	private String departureDate;
	@Override
	public void initialize(DateCompare constraintAnnotation) {
		
		this.arrivalDate = constraintAnnotation.arrivalDate();
		this.departureDate = constraintAnnotation.departureDate();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		try {
			LocalDate firstValue = LocalDate.parse(new BeanWrapperImpl(value)
				.getPropertyValue(arrivalDate).toString());
		LocalDate secondValue = LocalDate.parse(new BeanWrapperImpl(value)
				.getPropertyValue(departureDate).toString());
		if(firstValue.isAfter(secondValue)) return false;
		return true;
		}catch(DateTimeParseException e) {
			return true;
		}
	
		
		
		
	}
	

}
