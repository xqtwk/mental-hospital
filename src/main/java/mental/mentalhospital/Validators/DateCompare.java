package mental.mentalhospital.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateCompareValidator.class)
@Documented
public @interface DateCompare {
	String message() default "Bloga atvykimo data";
	String arrivalDate();
	String departureDate();
	Class<?>[] groups() default {};
	Class <? extends Payload>[] payload() default {};
	@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@interface List{
		FieldsValueMatch[] value();
	}
}
