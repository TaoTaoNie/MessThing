package annotations;

public @interface Uniqueness {
    Constraints constriants() default @Constraints(unique = true);
}
