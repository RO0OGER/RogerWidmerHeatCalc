package ch.gibb.iet.application.model;

import ch.gibb.iet.application.property.Property;

import java.util.List;

/**
 * Interface representing a tank with properties.
 * @author Ivo Graber
 * @version 1.0
 * @since 2024
 */
public interface InterfaceTank {

    /**
     * Gets the title of the tank.
     *
     * @return the title of the tank
     */
    String getTitle();

    /**
     * Gets the properties of the tank.
     *
     * @return a list of properties of the tank
     */
    List<Property> getProperties();
}
