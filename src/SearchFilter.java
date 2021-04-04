public enum SearchFilter {
    ALL,
    ATOMIC_NUMBER,
    SYMBOL,
    NAME,
    ATOMIC_WEIGHT,
    DESCRIPTION;

    @Override
    public String toString() {
        if (this == ALL) return "All";
        else if (this == ATOMIC_NUMBER) return "Atomic Number";
        else if (this == SYMBOL) return "Symbol";
        else if (this == NAME) return "Name";
        else if (this == ATOMIC_WEIGHT) return "Atomic Mass";
        else if (this == DESCRIPTION) return "Description";
        return null;
    }
}