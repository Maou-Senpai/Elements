package Elements;

public enum Subcategory {
    ALKALI_METALS,
    ALKALINE_EARTH_METALS,
    TRANSITION_METALS,
    LANTHANIDES,
    ACTINIDES,
    POST_TRANSITION_METALS,
    METALLOIDS,
    REACTIVE_NONMETALS,
    NOBLE_GASES,
    UNKNOWN_CHEMICAL_PROPERTIES;

    @Override
    public String toString() {
        if (this == ALKALI_METALS) return "Alkali Metals";
        else if (this == ALKALINE_EARTH_METALS) return "Alkaline Earth Metals";
        else if (this == TRANSITION_METALS) return "Transition Metals";
        else if (this == LANTHANIDES) return "Lanthanides";
        else if (this == ACTINIDES) return "Actinides";
        else if (this == POST_TRANSITION_METALS) return "Post-Transition Metals";
        else if (this == METALLOIDS) return "Metalloids";
        else if (this == REACTIVE_NONMETALS) return "Reactive Nonmetals";
        else if (this == NOBLE_GASES) return "Noble Gases";
        else if (this == UNKNOWN_CHEMICAL_PROPERTIES) return "Unknown Chemical Properties";
        else return null;
    }

    public String getColor() {
        if (this == ALKALI_METALS) return "red";
        else if (this == ALKALINE_EARTH_METALS) return "orange";
        else if (this == TRANSITION_METALS) return "deepskyblue";
        else if (this == LANTHANIDES) return "dodgerblue";
        else if (this == ACTINIDES) return "lightseagreen";
        else if (this == POST_TRANSITION_METALS) return "mediumpurple";
        else if (this == METALLOIDS) return "yellow";
        else if (this == REACTIVE_NONMETALS) return "greenyellow";
        else if (this == NOBLE_GASES) return "hotpink";
        else if (this == UNKNOWN_CHEMICAL_PROPERTIES) return "darkgray";
        else return null;
    }
}