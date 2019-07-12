import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ValidateAnnotation {
    /**
     * Minimum string length allowed. If it's exceeded, throws error.
     *
     * @throws InvalidStringLengthException
     */
    int minStringLength() default 5;

    /**
     * Maximum string length allowed. If it's exceeded, throws error.
     *
     * @throws InvalidStringLengthException
     */
    int maxStringLength() default 128;

    /**
     * Minimum integer value allowed. If it's exceeded, throws error.
     *
     * @throws InvalidIntValueException
     */
    int minValue() default -100000;

    /**
     * Maximum string length allowed. If it's exceeded, throws error.
     *
     * @throws InvalidIntValueException
     */
    int maxValue() default 1024;

    /**
     * Turns negative int values into positive if true is passed.
     */
    boolean absValue() default false;
}
