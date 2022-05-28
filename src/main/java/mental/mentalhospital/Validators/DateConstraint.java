package mental.mentalhospital.Validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateValidator.class)

public @interface DateConstraint {
	String message() default "Neteisinga data";
	Class<?>[] groups() default {};
	Class <? extends Payload>[] payload() default {};
}
