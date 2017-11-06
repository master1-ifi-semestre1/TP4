package factory;

import creatures.AbstractCreature;
import creatures.IEnvironment;
import creatures.SmartCreature;
import creatures.StupidCreature;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class FactorySmartCreature {

    private IEnvironment environment;
    private List<AbstractCreature> smartCreatureList = new ArrayList<>();

    public FactorySmartCreature(IEnvironment environment) {
        this.environment = environment;
    }

    public List<AbstractCreature> createCreatures(IEnvironment environment, Point2D position, double direction,
                                                  double speed, Color color) {
        for (int i = 0; i < 10; i++) {
            smartCreatureList.add(new SmartCreature(environment, position, direction, speed, color));
        }
        return smartCreatureList;
    }
}
