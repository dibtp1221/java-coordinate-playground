package coordCalc.controller;

import coordCalc.model.Figure;
import coordCalc.model.FigureFactory;
import coordCalc.model.Point;
import coordCalc.view.InputService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MainController {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<Point> points = InputService.inputCoords();
        Figure figure = FigureFactory.getInstance(points);
        figure.showArea();
    }
}
