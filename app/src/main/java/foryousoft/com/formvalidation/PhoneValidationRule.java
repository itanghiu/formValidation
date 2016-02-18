package foryousoft.com.formvalidation;

import com.mobsandgeeks.saripaar.AnnotationRule;

/**
 * Created by ihiu on 22/12/2015.
 */
public class PhoneValidationRule extends AnnotationRule<CustomPhoneValidator, String> {

    protected PhoneValidationRule(CustomPhoneValidator haggle) {
        super(haggle);
    }

    @Override
    public boolean isValid(String phone) {

        boolean isValid = false;
        String[] array = {"6", "06", "7", "07"};
        for (String beginning : array) {
            if (phone.trim().startsWith(beginning)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}