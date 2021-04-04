package Elements;

public enum StateOfMatter {
    GAS,
    SOLID,
    LIQUID,
    UNKNOWN;

    @Override
    public String toString() {
        if (this == GAS) return "Gas";
        else if (this == SOLID) return "Solid";
        else if (this == LIQUID) return "Liquid";
        else if (this == UNKNOWN) return "Unknown";
        return null;
    }
}