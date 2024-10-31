package ch.gibb.iet.application.model;

import ch.gibb.iet.application.property.Property;

import java.util.List;

/**
 * @author Roger Widmer
 * @version 1.0
 * @since 2024
 * Represents a cubic tank with specific dimensions and properties.
 */
public class CubicTank extends Tank implements InterfaceTank {

    /**
     * The length of the tank in meters.
     */
    private float length;

    /**
     * The width of the tank in meters.
     */
    private float width;

    /**
     * The height of the tank in meters.
     */
    private float height;

    /**
     * Constructs a CubicTank with the specified properties.
     *
     * @param maxTemperature the maximum temperature the tank can handle
     * @param name           the name of the tank
     * @param dailyEnergy    the daily energy consumption
     * @param length         the length of the tank
     * @param width          the width of the tank
     * @param height         the height of the tank
     * @throws IllegalArgumentException if maxTemperature is less than 30 or any other parameter is zero or empty
     */
    public CubicTank(float maxTemperature, String name, float dailyEnergy, float length, float width, float height) {
        super(maxTemperature, name, dailyEnergy);
        setLength(length);
        setWidth(width);
        setHeight(height);
        super.setVolume(calculateSquareTankVolumeInLiters());
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();
        Property length = new Property("Länge", Float.toString(getLength()));
        Property width = new Property("Breite", Float.toString(getWidth()));
        Property height = new Property("Höhe", Float.toString(getHeight()));
        properties.add(length);
        properties.add(width);
        properties.add(height);
        return properties;
    }

    @Override
    public String getTitle() {
        return "Cubic Tank";
    }

    /**
     * Returns a string representation of the CubicTank.
     *
     * @return a string representation of the CubicTank
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
     * Calculates the volume of the cubic tank in liters.
     *
     * @return the volume of the cubic tank in liters
     */
    public int calculateSquareTankVolumeInLiters() {
        return (int) (width * width * height / (double) 1000);
    }


    //Getters and Setters

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
        if (height == 0) {
            throw new IllegalArgumentException("Height kann nicht null sein");
        }
        this.height = height;
    }

    /**
     * Gets the length of the tank in meters.
     *
     * @return the length of the tank in meters
     */
    public float getLength() {
        return length;
    }

    /**
     * Sets the length of the tank in meters.
     *
     * @param length the length of the tank in meters
     * @throws IllegalArgumentException if length is zero
     */
    public void setLength(float length) {
        if (length == 0) {
            throw new IllegalArgumentException("Length kann nicht null sein");
        }
        this.length = length;
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