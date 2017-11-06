package factory;

import creatures.AbstractCreature;
import creatures.IEnvironment;
import creatures.StupidCreature;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class FactoryStupidCreature {
    private IEnvironment environment;
    private List<AbstractCreature> stupidCreatureList = new ArrayList<>();

    public FactoryStupidCreature(IEnvironment environment) {
        this.environment = environment;
    }

    public List<AbstractCreature> createCreatures(IEnvironment environment, Point2D position, double direction,
                                                  double speed, Color color) {
        for (int i = 0; i < 10; i++) {
            stupidCreatureList.add(new StupidCreature(environment, position, direction, speed, color));
        }
        return stupidCreatureList;
    }

}
