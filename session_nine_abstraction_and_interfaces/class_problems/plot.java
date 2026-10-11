package session_nine_abstraction_and_interfaces.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    protected String owner;
    public Plot(String owner) {
        this.owner = owner;
    }
    public abstract double calculateArea();
    public abstract String getShapeName();
    public String getOwner() { return owner; }
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override public double calculateArea() { return Math.PI * radius * radius; }
    @Override public String getShapeName() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override public double calculateArea() { return length * width; }
    @Override public String getShapeName() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override public double calculateArea() { return 0.5 * base * height; }
    @Override public String getShapeName() { return "TRIANGLE"; }
}

public class plot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = scanner.next();
            String owner = scanner.next();
            if (shape.equals("CIRCLE")) {
                plots.add(new CirclePlot(owner, scanner.nextDouble()));
            } else if (shape.equals("RECTANGLE")) {
                plots.add(new RectanglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
            } else if (shape.equals("TRIANGLE")) {
                plots.add(new TrianglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
            }
        }
        scanner.close();

        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}