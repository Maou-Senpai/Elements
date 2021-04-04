import Elements.*;

public class ElementsInfo {
    private static final int elementsCount = 118;
    private static final Element[] allElements = new Element[elementsCount];

    public ElementsInfo() {
        allElements[0] = new ELEHydrogen();
        allElements[1] = new ELEHelium();
        allElements[2] = new ELELithium();
        allElements[3] = new ELEBeryllium();
        allElements[4] = new ELEBoron();
        allElements[5] = new ELECarbon();
        allElements[6] = new ELENitrogen();
        allElements[7] = new ELEOxygen();
        allElements[8] = new ELEFluorine();
        allElements[9] = new ELENeon();
        allElements[10] = new ELESodium();
        allElements[11] = new ELEMagnesium();
        allElements[12] = new ELEAluminium();
        allElements[13] = new ELESilicon();
        allElements[14] = new ELEPhosphorus();
        allElements[15] = new ELESulfur();
        allElements[16] = new ELEChlorine();
        allElements[17] = new ELEArgon();
        allElements[18] = new ELEPotassium();
        allElements[19] = new ELECalcium();
        allElements[20] = new ELEScandium();
        allElements[21] = new ELETitanium();
        allElements[22] = new ELEVanadium();
        allElements[23] = new ELEChromium();
        allElements[24] = new ELEManganese();
        allElements[25] = new ELEIron();
        allElements[26] = new ELECobalt();
        allElements[27] = new ELENickel();
        allElements[28] = new ELECopper();
        allElements[29] = new ELEZinc();
        allElements[30] = new ELEGallium();
        allElements[31] = new ELEGermanium();
        allElements[32] = new ELEArsenic();
        allElements[33] = new ELESelenium();
        allElements[34] = new ELEBromine();
        allElements[35] = new ELEKrypton();
        allElements[36] = new ELERubidium();
        allElements[37] = new ELEStrontium();
        allElements[38] = new ELEYttrium();
        allElements[39] = new ELEZirconium();
        allElements[40] = new ELENiobium();
        allElements[41] = new ELEMolybdenum();
        allElements[42] = new ELETechnetium();
        allElements[43] = new ELERuthenium();
        allElements[44] = new ELERhodium();
        allElements[45] = new ELEPalladium();
        allElements[46] = new ELESilver();
        allElements[47] = new ELECadmium();
        allElements[48] = new ELEIndium();
        allElements[49] = new ELETin();
        allElements[50] = new ELEAntimony();
        allElements[51] = new ELETellurium();
        allElements[52] = new ELEIodine();
        allElements[53] = new ELEXenon();
        allElements[54] = new ELECaesium();
        allElements[55] = new ELEBarium();
        allElements[56] = new ELELanthanum();
        allElements[57] = new ELECerium();
        allElements[58] = new ELEPraseodymium();
        allElements[59] = new ELENeodymium();
        allElements[60] = new ELEPromethium();
        allElements[61] = new ELESamarium();
        allElements[62] = new ELEEuropium();
        allElements[63] = new ELEGadolinium();
        allElements[64] = new ELETerbium();
        allElements[65] = new ELEDysprosium();
        allElements[66] = new ELEHolmiun();
        allElements[67] = new ELEErbium();
        allElements[68] = new ELEThulium();
        allElements[69] = new ELEYtterbium();
        allElements[70] = new ELELutetium();
        allElements[71] = new ELEHafnium();
        allElements[72] = new ELETantalum();
        allElements[73] = new ELETungsten();
        allElements[74] = new ELERhenium();
        allElements[75] = new ELEOsmium();
        allElements[76] = new ELEIridium();
        allElements[77] = new ELEPlatinum();
        allElements[78] = new ELEGold();
        allElements[79] = new ELEMercury();
        allElements[80] = new ELEThallium();
        allElements[81] = new ELELead();
        allElements[82] = new ELEBismuth();
        allElements[83] = new ELEPolonium();
        allElements[84] = new ELEAstatine();
        allElements[85] = new ELERadon();
        allElements[86] = new ELEFrancium();
        allElements[87] = new ELERadium();
        allElements[88] = new ELEActinium();
        allElements[89] = new ELEThorium();
        allElements[90] = new ELEProtactinium();
        allElements[91] = new ELEUranium();
        allElements[92] = new ELENeptunium();
        allElements[93] = new ELEPlutonium();
        allElements[94] = new ELEAmericium();
        allElements[95] = new ELECurium();
        allElements[96] = new ELEBerkelium();
        allElements[97] = new ELECalifornium();
        allElements[98] = new ELEEinsteinium();
        allElements[99] = new ELEFermium();
        allElements[100] = new ELEMendelevium();
        allElements[101] = new ELENobelium();
        allElements[102] = new ELELawrencium();
        allElements[103] = new ELERutherfordium();
        allElements[104] = new ELEDubnium();
        allElements[105] = new ELESeaborgium();
        allElements[106] = new ELEBohrium();
        allElements[107] = new ELEHassium();
        allElements[108] = new ELEMeitnerium();
        allElements[109] = new ELEDarmstadtium();
        allElements[110] = new ELERoentgenium();
        allElements[111] = new ELECopernicium();
        allElements[112] = new ELENihonium();
        allElements[113] = new ELEFlerovium();
        allElements[114] = new ELEMoscovium();
        allElements[115] = new ELELivermorium();
        allElements[116] = new ELETennessine();
        allElements[117] = new ELEOganesson();
    }

    public String getSymbol(int atomicNumber) {
        return allElements[atomicNumber - 1].getSymbol();
    }

    public String getName(int atomicNumber) {
        return allElements[atomicNumber - 1].getName();
    }

    public double getAtomicWeight(int atomicNumber) {
        return allElements[atomicNumber - 1].getAtomicWeight();
    }

    public StateOfMatter getStateOfMatter(int atomicNumber) {
        return allElements[atomicNumber - 1].getStateOfMatter();
    }

    public Subcategory getSubcategory(int atomicNumber) {
        return allElements[atomicNumber - 1].getSubcategory();
    }

    public String getDescription(int atomicNumber) {
        return allElements[atomicNumber - 1].getDescription();
    }

    public Element getElement(int atomicNumber) {
        return allElements[atomicNumber - 1];
    }

    public int getElementsCount() {
        return elementsCount;
    }
}