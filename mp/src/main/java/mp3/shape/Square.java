package mp3.shape;

public class Square extends Shape {

    private int sideLength;

    public Square(String name, int sideLength) {
        super(name);
        setSideLength(sideLength);
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength < 0) {
            throw new IllegalArgumentException("sideLength cannot be negative");
        }
        this.sideLength = sideLength;
    }

    @Override
    double area() {
        return sideLength * sideLength;
    }
}
