package mp4.attribute;

public class Reservoir {

    private int limit;
    private int currentContent;

    public int getLimit() {
        return limit;
    }

    public Reservoir(int limit, int currentContent) {
        setLimit(limit);
        setCurrentContent(currentContent);
    }

    public void setLimit(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("Limit cannot be negative");
        }
        if (limit < currentContent) {
            throw new IllegalArgumentException("New limit cannot be smaller than current content");
        }
        this.limit = limit;
    }

    public int getCurrentContent() {
        return currentContent;
    }

    public void setCurrentContent(int currentContent) {
        if (currentContent < 0) {
            throw new IllegalArgumentException("currentContent cannot be negative");
        }
        if (currentContent > limit) {
            throw new IllegalArgumentException("currentContent cannot be greater than limit");
        }
        this.currentContent = currentContent;
    }

    public void increaseContentByOne() {
        setCurrentContent(currentContent + 1);
    }

    public void decreaseContentByOne() {
        setCurrentContent(currentContent - 1);
    }
}
