package ch.gibb.iet.application.model;

import ch.gibb.iet.application.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivo Graber
 * @version 1.0
 * @since 2024
 * Represents a generic tank with specific properties.
 */
public class Tank implements InterfaceTank {
    /** The maximum temperature the tank can handle. */
    protected float maxTemperature;

    /** The name of the tank. */
    protected String name;

    /** The volume of the tank in liters. */
    protected float volume;

    /** The daily energy consumption in kWh. */
    protected float dailyEnergy;

    /**
     * Constructs a Tank with the specified properties.
     *
     * @param maxTemperature the maximum temperature the tank can handle
     * @param name the name of the tank
     * @param volume the volume of the tank in liters
     * @param dailyEnergy the daily energy consumption in kWh
     * @throws IllegalArgumentException if maxTemperature is less than 30 or any other parameter is zero or empty
     */
    public Tank(float maxTemperature, String name, float volume, float dailyEnergy) {
        setMaxTemperature(maxTemperature);
        setName(name);
        setVolume(volume);
        setDailyEnergy(dailyEnergy);
    }

    public Tank (float maxTemperature, String name, float dailyEnergy) {
        setMaxTemperature(maxTemperature);
        setName(name);
        setDailyEnergy(dailyEnergy);
    }

    /**
     * Returns a string representation of the Tank.
     *
     * @return a string representation of the Tank
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
     * Calculates the number of days the tank can provide heating.
     *
     * @return the number of days the tank can provide heating
     */
    public float calculateDaysHeated() {
        return calculateStoredEnergy() / dailyEnergy;
    }

    /**
     * Calculates the stored energy in the tank.
     *
     * @return the stored energy in kWh
     */
    public float calculateStoredEnergy() {
        return (int) (volume * 4.18 * (maxTemperature - 23) / (double) 3600);
    }

    //Getters and Setters

    /**
     * Gets the maximum temperature the tank can handle.
     *
     * @return the maximum temperature
     */
    public float getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * Sets the maximum temperature the tank can handle.
     *
     * @param maxTemperature the maximum temperature
     * @throws IllegalArgumentException if maxTemperature is less than 30
     */
    public void setMaxTemperature(float maxTemperature) {
        if (maxTemperature < 30) {
            throw new IllegalArgumentException("MaxTemperatur kann nicht unter 30 sein");
        }
        this.maxTemperature = maxTemperature;
    }

    /**
     * Gets the name of the tank.
     *
     * @return the name of the tank
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the tank.
     *
     * @param name the name of the tank
     * @throws IllegalArgumentException if name is empty
     */
    public void setName(String name) {
        if (name == "") {
            throw new IllegalArgumentException("Name kann nicht null sein");
        }
        this.name = name;
    }

    /**
     * Gets the volume of the tank in liters.
     *
     * @return the volume of the tank in liters
     */
    public float getVolume() {
        return volume;
    }

    /**
     * Sets the volume of the tank in liters.
     *
     * @param volume the volume of the tank in liters
     * @throws IllegalArgumentException if volume is zero
     */
    public void setVolume(float volume) {
        if (volume == 0) {
            throw new IllegalArgumentException("Volume kann nicht null sein");
        }
        this.volume = volume;
    }

    /**
     * Gets the daily energy consumption in kWh.
     *
     * @return the daily energy consumption in kWh
     */
    public float getDailyEnergy() {
        return dailyEnergy;
    }

    /**
     * Sets the daily energy consumption in kWh.
     *
     * @param dailyEnergy the daily energy consumption in kWh
     * @throws IllegalArgumentException if dailyEnergy is zero
     */
    public void setDailyEnergy(float dailyEnergy) {
        if (dailyEnergy == 0) {
            throw new IllegalArgumentException("DailyEnergy kann nicht null sein");
        }
        this.dailyEnergy = dailyEnergy;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();
        Property maxTemperature = new Property("Maximale Temperatur", String.valueOf(getMaxTemperature()));
        Property name = new Property("Name", getName());
        Property volume = new Property("Fassungsvermögen", String.valueOf(getVolume()));
        Property dailyEnergy = new Property("Tägliche Energie", String.valueOf(getDailyEnergy()));
        Property daysHeated = new Property("Tage heizen", String.valueOf(calculateDaysHeated()));
        Property storedEnergy = new Property("Gespeicherte Energie", String.valueOf(calculateStoredEnergy()));
        properties.add(maxTemperature);
        properties.add(name);
        properties.add(volume);
        properties.add(dailyEnergy);
        properties.add(daysHeated);
        properties.add(storedEnergy);
        return properties;
    }
}