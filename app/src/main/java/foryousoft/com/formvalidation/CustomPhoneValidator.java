package foryousoft.com.formvalidation;

/**
 * Created by I-Tang HIU  on 10/02/2016.
 */
import com.mobsandgeeks.saripaar.annotation.ValidateUsing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ihiu on 22/12/2015.
 */
@ValidateUsing(PhoneValidationRule.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CustomPhoneValidator {

    public int messageResId()   default -1;                     // Mandatory attribute
    // public String message()     default ICsts.WRONG_PHONE_NUMBER;   // Mandatory attribute
    public String message()     default "";   // Mandatory attribute
    public int sequence()       default -1;                     // Mandatory attribute
}
