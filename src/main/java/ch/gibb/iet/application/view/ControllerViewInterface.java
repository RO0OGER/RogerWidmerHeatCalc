package ch.gibb.iet.application.view;

import ch.gibb.iet.application.model.InterfaceTank;

/**
 * Interface representing the view component in the MVC architecture.
 */
public interface ControllerViewInterface {

    /**
     * Starts the view with the specified tank data.
     *
     * @param data the tank data to display
     */
    void startView(InterfaceTank data);
}
