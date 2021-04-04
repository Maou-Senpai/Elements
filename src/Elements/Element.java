package Elements;

public abstract class Element {
    protected int atomicNumber;
    protected String symbol;
    protected String name;
    protected double atomicWeight;
    protected StateOfMatter stateOfMatter;
    protected Subcategory subcategory;
    protected String description;

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public StateOfMatter getStateOfMatter() {
        return stateOfMatter;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public String getDescription() {
        return description;
    }
}