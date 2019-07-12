@ValidateAnnotation(absValue = true, minStringLength = 5, maxValue = 150)
public class RegisterForm {
    public String fullName;
    public int age;
    public int height;

    @Override
    public String toString() {
        return String.format("Full name: %s\nAge: %d\nHeight: %d", fullName, age, height);
    }
}
