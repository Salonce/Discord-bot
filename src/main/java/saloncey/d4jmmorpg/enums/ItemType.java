package saloncey.d4jmmorpg.enums;

public enum ItemType {
    PRIMARY_HAND (1),
    SECONDARY_HAND (2),
    ARMOR_SET (3),
    BOOTS (4);

    private final int numerical;
    ItemType(int numerical) {
        this.numerical = numerical;
    }

    public int asInt() {
        return numerical;
    }

    public static ItemType getType(int numerical){
        switch(numerical) {
            case 1:
                return PRIMARY_HAND;
            case 2:
                return SECONDARY_HAND;
            case 3:
                return ARMOR_SET;
            case 4:
                return BOOTS;
        }
        return null;
    }
}
