public class Main {
    public static void main(String[] args) throws InvalidIntValueException, IllegalAccessException, InvalidStringLengthException {
        RegisterForm registerForm = new RegisterForm();
        registerForm.fullName = "John Doe";
        registerForm.age = 10;
        registerForm.height = -100;

        ValidateAnnotationImplementation validateImpl = new ValidateAnnotationImplementation(registerForm);

        System.out.println("Initial values");
        System.out.println(registerForm.toString());

        validateImpl.validate();

        System.out.println("\nAfter Validation");
        System.out.println(registerForm.toString());
    }
}
