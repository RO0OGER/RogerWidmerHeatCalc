package ch.gibb.iet.application;

import ch.gibb.iet.application.model.CubicTank;
import ch.gibb.iet.application.model.CylindricalTank;
import ch.gibb.iet.application.model.Tank;

/**
 * @author Ivo Graber
 * @version 1.0
 * @since 2024
 * The HeatCalculator class is the main class of the ch.gibb.iet.application.
 */
public class HeatCalculator {

    /**
     * The main method of the ch.gibb.iet.application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tank tank = new Tank(70, "Fredi", 1000, 20);
        CubicTank cubicTank = new CubicTank(80, "Ueli", 400, 100, 200, 100);
        CylindricalTank cylindricalTank = new CylindricalTank(80, "Lisbeth", 400, 100, 200);
        System.out.println(cylindricalTank);
        System.out.println(cubicTank);
        System.out.println(tank);

        tank.setMaxTemperature(75);
        tank.setName("Fred");
        tank.setVolume(1100);
        tank.setDailyEnergy(25);

        cubicTank.setMaxTemperature(85);
        cubicTank.setName("Urs");
        cubicTank.setDailyEnergy(450);
        cubicTank.setLength(110);
        cubicTank.setWidth(210);
        cubicTank.setHeight(110);

        cylindricalTank.setMaxTemperature(85);
        cylindricalTank.setName("Lisa");
        cylindricalTank.setDailyEnergy(450);
        cylindricalTank.setHeight(110);
        cylindricalTank.setWidth(210);

        System.out.println("Tank: " + tank.getName() + ", Max Temp: " + tank.getMaxTemperature() + ", Volume: " + tank.getVolume() + ", Daily Energy: " + tank.getDailyEnergy());
        System.out.println("CubicTank: " + cubicTank.getName() + ", Max Temp: " + cubicTank.getMaxTemperature() + ", Volume: " + cubicTank.getVolume() + ", Daily Energy: " + cubicTank.getDailyEnergy() + ", Length: " + cubicTank.getLength() + ", Width: " + cubicTank.getWidth() + ", Height: " + cubicTank.getHeight());
        System.out.println("CylindricalTank: " + cylindricalTank.getName() + ", Max Temp: " + cylindricalTank.getMaxTemperature() + ", Volume: " + cylindricalTank.getVolume() + ", Daily Energy: " + cylindricalTank.getDailyEnergy() + ", Height: " + cylindricalTank.getHeight() + ", Width: " + cylindricalTank.getWidth());
    }
}
