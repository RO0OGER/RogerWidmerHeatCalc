package ch.gibb.iet.application.property;

/**
 * Represents a property with a key and a value.
 * @author Roger Widmer
 * @version 1.0
 * @since 2024
 */
public class Property {
    private String key;
    private String value;

    /**
     * Constructs a Property with the specified key and value.
     *
     * @param key the key of the property
     * @param value the value of the property
     */
    public Property(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key of the property.
     *
     * @return the key of the property
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the value of the property.
     *
     * @return the value of the property
     */
    public String getValue() {
        return value;
    }
}