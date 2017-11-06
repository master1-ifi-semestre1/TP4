package factory;

import creatures.AbstractCreature;
import creatures.BouncingCreature;
import creatures.IEnvironment;
import creatures.SmartCreature;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class FactoryBouncingCreature {

    private IEnvironment environment;
    private List<AbstractCreature> bouncingCreatureList = new ArrayList<>();

    public FactoryBouncingCreature(IEnvironment environment) {
        this.environment = environment;
    }

    public List<AbstractCreature> createCreatures(IEnvironment environment, Point2D position, double direction,
                                                  double speed, Color color) {
        for (int i = 0; i < 10; i++) {
            bouncingCreatureList.add(new BouncingCreature(environment, position, direction, speed, color));
        }
        return bouncingCreatureList;
    }

}
