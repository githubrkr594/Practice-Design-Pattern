package MachineCodingPractice.ParkingLotApplication.Model;

public enum DisplayType {
    FREE_COUNT("free_count"),
    FREE_SLOT("free_slots"),
    OCCUPIED_SLOTS("occupied_slots");

    private String displayName;

    DisplayType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
