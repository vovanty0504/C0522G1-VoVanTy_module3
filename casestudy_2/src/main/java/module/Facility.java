package module;

public class Facility {
    private int facilityId;
    private String facilityName;
    private int facilityArea;
    private double facilityCost;
    private int facilityMaxPeople;
    private String facilityStandardRoom;
    private String facilityDescriptionOtherConvenience;
    private double facilityPoolArea;
    private int facilityNumberOfFloors;
    private String facilityFree;
    private int rentTypeId;
    private int facilityTypeId;

    public Facility() {
    }

    public Facility(int facilityId, String facilityName, int facilityArea, double facilityCost, int facilityMaxPeople,
                    String facilityStandardRoom, String facilityDescriptionOtherConvenience, double facilityPoolArea,
                    int facilityNumberOfFloors, String facilityFree, int rentTypeId, int facilityTypeId) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityArea = facilityArea;
        this.facilityCost = facilityCost;
        this.facilityMaxPeople = facilityMaxPeople;
        this.facilityStandardRoom = facilityStandardRoom;
        this.facilityDescriptionOtherConvenience = facilityDescriptionOtherConvenience;
        this.facilityPoolArea = facilityPoolArea;
        this.facilityNumberOfFloors = facilityNumberOfFloors;
        this.facilityFree = facilityFree;
        this.rentTypeId = rentTypeId;
        this.facilityTypeId = facilityTypeId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(int facilityArea) {
        this.facilityArea = facilityArea;
    }

    public double getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(double facilityCost) {
        this.facilityCost = facilityCost;
    }

    public int getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(int facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public String getFacilityStandardRoom() {
        return facilityStandardRoom;
    }

    public void setFacilityStandardRoom(String facilityStandardRoom) {
        this.facilityStandardRoom = facilityStandardRoom;
    }

    public String getFacilityDescriptionOtherConvenience() {
        return facilityDescriptionOtherConvenience;
    }

    public void setFacilityDescriptionOtherConvenience(String facilityDescriptionOtherConvenience) {
        this.facilityDescriptionOtherConvenience = facilityDescriptionOtherConvenience;
    }

    public double getFacilityPoolArea() {
        return facilityPoolArea;
    }

    public void setFacilityPoolArea(double facilityPoolArea) {
        this.facilityPoolArea = facilityPoolArea;
    }

    public int getFacilityNumberOfFloors() {
        return facilityNumberOfFloors;
    }

    public void setFacilityNumberOfFloors(int facilityNumberOfFloors) {
        this.facilityNumberOfFloors = facilityNumberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(int facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }
}
