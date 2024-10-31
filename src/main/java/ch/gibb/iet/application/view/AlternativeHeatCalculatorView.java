package ch.gibb.iet.application.view;

import ch.gibb.iet.application.controller.HeatCalculatorController;
import ch.gibb.iet.application.model.InterfaceTank;
import ch.gibb.iet.application.property.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represents an alternative view for the heat calculator ch.gibb.iet.application.
 * @author Ivo Graber
 * @version 1.0
 * @since 2024
 */
public class AlternativeHeatCalculatorView implements ControllerViewInterface {
    protected HeatCalculatorController controller;
    protected Stage stage;

    /**
     * Constructs an AlternativeHeatCalculatorView with the specified stage and controller.
     *
     * @param stage the stage for the view
     * @param controller the controller for handling actions
     */
    public AlternativeHeatCalculatorView(Stage stage, HeatCalculatorController controller) {
        this.controller = controller;
        this.stage=stage;
        stage.setTitle("LabelCreator");
    }

    /**
     * Starts the view with the specified tank data.
     *
     * @param data the tank data to display
     */
    @Override
    public void startView(InterfaceTank data) {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        /* Titel erstellen und dem Layout anfügen */
        Text labelText = getLabelNode(data.getTitle());
        layout.getChildren().add(labelText);

        /* Eigenschaften untereinander in einer VBox darstellen und dem Layout anfügen */
        VBox propertiesLayout = new VBox();
        for(Property property : data.getProperties()){
            // Label mit der Beschriftung erstellen und dem Layout anfügen
            addPropertyToPane(property, propertiesLayout);
        }
        layout.getChildren().add(propertiesLayout);

        /* Button erstellen und dem Layout anfügen, um zwischen den Labels navigieren zu können */
        Button btnNext = new Button("→");
        btnNext.setOnAction(controller);
        layout.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout,600,600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Creates a text node for the label with the specified title.
     *
     * @param title the title of the label
     * @return the text node for the label
     */
    protected Text getLabelNode(String title){
        Text labelText = new Text();
        labelText.setText(title);
        labelText.setFont(Font.font ("Arial", FontWeight.EXTRA_BOLD, 30));
        labelText.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, darkblue 0%, black 50%);");
        return labelText;
    }

    /**
     * Adds a property to the specified pane.
     *
     * @param property the property to add
     * @param propertiesLayout the pane to add the property to
     */
    protected void addPropertyToPane(Property property, Pane propertiesLayout){
        // Label mit der Beschriftung erstellen und dem Layout anfügen
        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(Font.font ("Arial", FontWeight.BOLD, 20));
        propertiesLayout.getChildren().add(keyText);
        // Label mit dem Wert erstellen und dem Layout anfügen
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(Font.font ("Arial", FontWeight.NORMAL, 16));
        propertiesLayout.getChildren().add(valueText);
    }
}
