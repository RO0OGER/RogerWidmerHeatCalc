package ch.gibb.iet.application.model;

import ch.gibb.iet.application.property.Property;

import java.util.List;

/**
 * @author Roger Widmer
 * @version 1.0
 * @since 2024
 * Represents a cylindrical tank with specific dimensions and properties.
 */
public class CylindricalTank extends Tank implements InterfaceTank {
    /** The height of the tank in meters. */
    private float height;

    /** The width of the tank in meters. */
    private float width;

    /**
     * Constructs a CylindricalTank with the specified properties.
     *
     * @param maxTemperature the maximum temperature the tank can handle
     * @param name the name of the tank
     * @param dailyEnergy the daily energy consumption
     * @param height the height of the tank
     * @param width the width of the tank
     * @throws IllegalArgumentException if maxTemperature is less than 30 or any other parameter is zero or empty
     */
    public CylindricalTank(float maxTemperature, String name, float dailyEnergy, float height, float width) {
        super(maxTemperature, name, dailyEnergy);
        setHeight(height);
        setWidth(width);
        super.setVolume(calculateRoundTankVolumeInLiters());
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property width = new Property("Breite", Float.toString(getWidth()));
        Property height = new Property("Höhe", Float.toString(getHeight()));
        properties.add(width);
        properties.add(height);
        return properties;
    }

    @Override
    public String getTitle() {
        return "Zylindrischer Tank";
    }

    /**
     * Returns a string representation of the CylindricalTank.
     *
     * @return a string representation of the CylindricalTank
     */
    @Override
    public String toString() {
        return "Fassungsvermögen: " + volume + " Liter\n" +
                "Gespeicherte Energie: " + calculateStoredEnergy() + " kWh\n" +
                "Tägliche Energie: " + dailyEnergy + " kWh\n" +
                "Tage heizen: " + calculateDaysHeated() + " Tage\n" +
                "Name: " + name + "\n" +
                "Maximale Temperatur: " + maxTemperature + "Grad Celsius";
    }

    /**
     * Calculates the volume of the cylindrical tank in liters.
     *
     * @return the volume of the cylindrical tank in liters
     */
    public int calculateRoundTankVolumeInLiters() {
        return (int) ((double) (width * width * height) / 4 / 1000 * Math.PI);
    }


    /**
     * Gets the height of the tank in meters.
     *
     * @return the height of the tank in meters
     */
    public float getHeight() {
        return height;
    }

    /**
     * Sets the height of the tank in meters.
     *
     * @param height the height of the tank in meters
     * @throws IllegalArgumentException if height is zero
     */
    public void setHeight(float height) {
        if(height == 0) {
            throw new IllegalArgumentException("Height kann nicht null sein");
        }
        this.height = height;
    }

    /**
     * Gets the width of the tank in meters.
     *
     * @return the width of the tank in meters
     */
    public float getWidth() {
        return width;
    }

    /**
     * Sets the width of the tank in meters.
     *
     * @param width the width of the tank in meters
     * @throws IllegalArgumentException if width is zero
     */
    public void setWidth(float width) {
        if (width == 0) {
            throw new IllegalArgumentException("Width kann nicht null sein");
        }
        this.width = width;
    }
}