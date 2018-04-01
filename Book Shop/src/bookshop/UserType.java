package bookshop;

public enum UserType {
    ADMINISTRATOR("Administrator"), GUEST("Guest"), NORMAL_USER("Normal User");

    private final String valueAsString;

    private UserType(String asString) {
        this.valueAsString = asString;
    }

    @Override
    public String toString() {
        return this.valueAsString;
    }

}
