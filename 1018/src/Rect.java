public class Rect extends Shape {
    private double x, y;

    public Rect(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Rect() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double area() {
        return x * y;
    }

    @Override
    public double girth() {
        return 2 * (x + y);
    }
}
