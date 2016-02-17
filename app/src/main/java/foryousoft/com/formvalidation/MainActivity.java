package foryousoft.com.formvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmEmail;
import com.mobsandgeeks.saripaar.annotation.DecimalMax;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Validator.ValidationListener, View.OnClickListener {

    private Validator validator;
    @NotEmpty(messageResId = R.string.emailCantBeEmpty)
    @Email(messageResId = R.string.InvalidEmailTitle)
    private EditText emailEditText;

    @NotEmpty(messageResId = R.string.emailCantBeEmpty)
    @ConfirmEmail(messageResId = R.string.confirmEmailError)
    private EditText confirmEmail;

    @DecimalMax(value = 4, messageResId = R.string.invalidCodeNumber)
    EditText codeNumber;

    @NotEmpty(messageResId = R.string.phoneCantBeEmpty)
    @CGLibPhoneValidator(messageResId = R.string.wrongPhone)
    EditText phoneEditText;
    Button validationButton;
    TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        emailEditText = (EditText) findViewById(R.id.email);
        confirmEmail = (EditText) findViewById(R.id.confirmEmail);
        phoneEditText = (EditText) findViewById(R.id.phone);
        codeNumber = (EditText) findViewById(R.id.codeNumber);
        validationButton = (Button) findViewById(R.id.validate);

        com.mobsandgeeks.saripaar.Validator.registerAnnotation(CGLibPhoneValidator.class); // adds the custom Phone input field validation
        validator = new Validator(this);
        validator.setValidationListener(this);
        validationButton.setOnClickListener(this);
    }

    @Override
    public void onValidationSucceeded() {

        statusTextView = (TextView) findViewById(R.id.status);
        statusTextView.setText("Ok");
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            ((EditText) view).setError(message);
        }
    }

    @Override
    public void onClick(View v) {
        validator.validate();
    }
}
