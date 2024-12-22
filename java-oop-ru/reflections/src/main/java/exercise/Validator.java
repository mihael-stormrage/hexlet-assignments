package exercise;

import java.lang.reflect.Field;

// BEGIN
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {
    private static final Function<Object, Predicate<Field>> IS_NULL =
        o -> f -> getFieldVal(f, o) == null;

    private static final Function<Object, Predicate<Field>> IS_LESS_THAN_MIN = o -> f -> {
        Object val = getFieldVal(f, o);
        if (val == null) {
            return false;
        }
        int strLength = getFieldVal(f, o).toString().length();
        int minLength = f.getAnnotation(MinLength.class).minLength();
        return strLength < minLength;
    };

    public static List<String> validate(Object o) {
        return validateAnnotation(o, NotNull.class, IS_NULL.apply(o))
            .keySet().stream().toList();
    }

    public static Map<String, List<String>> advancedValidate(Object o) {
        Map<String, String> nullFields = validateAnnotation(
            o,
            NotNull.class,
            IS_NULL.apply(o),
            a -> "can not be null"
        );
        Map<String, String> lessThanMinFields = validateAnnotation(
            o,
            MinLength.class,
            IS_LESS_THAN_MIN.apply(o),
            a -> "length less than " + a.minLength()
        );

        return Stream.of(nullFields, lessThanMinFields)
            .flatMap(m -> m.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> new ArrayList<>(List.of(e.getValue())),
                (v1, v2) -> {
                    v1.addAll(v2);
                    return v1;
                }
            ));
    }

    private static Map<String, String> validateAnnotation(
            Object o,
            Class<? extends Annotation> a,
            Predicate<Field> p
    ) {
        return validateAnnotation(o, a, p, _a -> a.getName());
    }

    private static <A extends Annotation> Map<String, String> validateAnnotation(
        Object o,
        Class<A> a,
        Predicate<Field> p,
        Function<A, String> messageExtractor
    ) {
        Map<String, String> validationErrors = new HashMap<>();
        Arrays.stream(o.getClass().getDeclaredFields())
            .filter(f -> f.isAnnotationPresent(a))
            .peek(f -> f.setAccessible(true))
            .filter(p)
            .forEach(f -> {
                A annotation = f.getAnnotation(a);
                validationErrors.put(f.getName(), messageExtractor.apply(annotation));
            });
        return validationErrors;
    }

    private static Object getFieldVal(Field f, Object o) {
        try {
            return f.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
