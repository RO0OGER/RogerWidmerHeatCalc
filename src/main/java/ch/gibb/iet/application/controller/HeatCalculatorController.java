package ch.gibb.iet.application.controller;

import ch.gibb.iet.application.model.Tank;
import ch.gibb.iet.application.view.ControllerViewInterface;
import javafx.event.ActionEvent;

import java.util.List;

public class HeatCalculatorController implements javafx.event.EventHandler<ActionEvent>  {

    protected List<Tank> models;
    protected ControllerViewInterface view;
    protected int currentModel = 0;

    public HeatCalculatorController(List<Tank> models) {
        this.models = models;
    }

    public void setView(ControllerViewInterface view) {
        this.view = view;
    }

    public void startView() {
        view.startView(models.get(currentModel));
    }

    public void showNextLabel(){
        //erhöht die Zahl currentLabel um eins, sofern man nicht am Ende der Liste ist
        if(currentModel < models.size()-1) {
            currentModel++;
        }else{
            currentModel = 0;
        }
        view.startView(models.get(currentModel));
    }

    public String getModel(){
        return models.get(currentModel).toString();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        showNextLabel();
    }
}
