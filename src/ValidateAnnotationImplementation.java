import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class ValidateAnnotationImplementation {
    RegisterForm registerForm;
    List<Field> fields;
    ValidateAnnotation validateAnnotation;

    public ValidateAnnotationImplementation(RegisterForm registerForm) {
        this.registerForm = registerForm;
        this.fields = Arrays.asList(registerForm.getClass().getDeclaredFields());
        this.validateAnnotation = registerForm.getClass().getAnnotation(ValidateAnnotation.class);
    }

    public void validate() throws IllegalAccessException, InvalidIntValueException, InvalidStringLengthException {
        for (Field field : fields) {

            String fieldType = field.getType().getTypeName();

            if (fieldType.equals("int")) {
                validateInt(field);
            }

            if (fieldType.endsWith("String")) {
                validateString(field);
            }
        }
    }

    private void validateInt(Field field) throws InvalidIntValueException, IllegalAccessException {
        int intValue = field.getInt(registerForm);

        if (validateAnnotation.absValue()) {
            field.setInt(registerForm, Math.abs(intValue));
        }

        if (intValue > validateAnnotation.maxValue() || intValue < validateAnnotation.minValue()) {
            throw new InvalidIntValueException();
        }
    }

    private void validateString(Field field) throws IllegalAccessException, InvalidStringLengthException {
        int stringLength = field.get(registerForm).toString().length();
        if (stringLength > validateAnnotation.maxStringLength() ||
                stringLength < validateAnnotation.minStringLength()) {
            throw new InvalidStringLengthException();
        }
    }
}
