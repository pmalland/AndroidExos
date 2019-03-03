package com.paulmalland.view;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * We use the annotation @Size @NotEmpty and @Email for the validation process
 * note that notempty and email hibernate validators are deprecated and we use
 * the standard javax instead.
 * The check of these validator will trigger ther error version of our forms we needed
 * 
 * So to add validation we
 * 		 add the javax and hibernate dependency
 * 		 add annotation and condition here in the model object
 * 		 change the signature in the controller POST RequestMethod with @Valid Attendee attendee, BindingResult result, Model m
 * 			//	and ask the bindingResult has catch an error : if (reuslt.hasError()) and return to "attendee" to get another input
 * 		 add the form:error  version of our form in the Front End page
 *  	 		and of course customize the error messages and internationalize them I18n
 *  In messages_en.properties Size.attendee.name   
 *  	Size referes to the annotation @Size
 *  	attendee refers to the object attendee
 *  	name refers to the attribute name
 *  Same convention for the other messages linked to annotations 
 * 
 * To create a custom validation for Phone number we
 * 		create a Phone annotation aka
 * 			create public @interface Phone the @ is mandatory, otherwise it's the an interface
 * 			on this @interface we have 4 annotations @Documented
 *														 @Constraint(validatedBy=PhoneConstraintValidator.class)
 *														 	with PhoneConstraintValidator being the Constraint Validator
 *													@Target({ElementType.METHOD, ElementType.FIELD})
 *														it describe where we can place this annotation in our code. where it is recognize
 *													@Retention(RetentionPolicy.RUNTIME)
 *														the retention policy. how it runs and how we interact with it
 *
 *
 * 		create a PhoneConstraintValidator implementsConstraintValidator<Phone, String> and
 * 				overriding initialize() and  isvalid() using a regex to chack for a phone number
 * 		anotate our new phone variable
 * 		add new messages in messages.properties and a new form un attendee.jsp
 * 
 */
@Documented
@Constraint(validatedBy=PhoneConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {

	/**
	 * "{Phone}" refers to the key inside messages.properties when we gonna looks things up like we 
	 * did with other annotations. (ex: Size.attendee.name, or NotEmpty hibernate version)
	 * @return
	 */
	String message() default "{Phone}";
	
	Class<?>[] groups() default {};
	/**
	 *  This how we pass in the values associated with our annotation.
	 *  We can pass in default value if they don't define any
	 * @return
	 */
	Class<? extends Payload>[] payload() default{};
}
