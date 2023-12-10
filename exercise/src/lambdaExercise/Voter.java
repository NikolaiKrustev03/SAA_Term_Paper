package lambdaExercise;

public class Voter {
    private String name;
    private String city;
    private String street;
    private String address;

    public Voter(String name, String city, String street, String address) {
        this.name = name;
        this.city = city;
        this.street = street;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("\n\nName: %s\nCity: %s\nStreet: %s\nAddress: %s", getName(), getCity(), getStreet(), getAddress());
    }
}
