package ch.gibb.iet.application;

import ch.gibb.iet.application.controller.HeatCalculatorController;
import ch.gibb.iet.application.model.CubicTank;
import ch.gibb.iet.application.model.CylindricalTank;
import ch.gibb.iet.application.model.Tank;
import ch.gibb.iet.application.view.AlternativeHeatCalculatorView;
import ch.gibb.iet.application.view.HeatCalculatorView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// Note: The Class has to be started using the following maven command: mvn clean javafx:run

public class
HeatCalculatorFX extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        List<Tank> models = createModels();
        HeatCalculatorController controller = new HeatCalculatorController(models);
        HeatCalculatorView view = new HeatCalculatorView(stage, controller);
        AlternativeHeatCalculatorView alternativeView = new AlternativeHeatCalculatorView(stage, controller);
        controller.setView(alternativeView);
        controller.startView();
    }

    public List<Tank> createModels() {
        ArrayList<Tank> models = new ArrayList<>();
        models.add(new Tank(100, "Freduard", 1000, 10));
        models.add(new CylindricalTank(200, "Hansi", 2000, 500, 500));
        models.add(new CubicTank(300, "Peschä", 3000, 500, 500, 500));
        return models;
    }
}
