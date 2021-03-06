package annotations;

public class Address {

    @NotNull
    private String country;

    private String city;

    @NotNull(value = "A ZIP erteke nem lehet ures!", submessage = {"Javitsa ki a zip kodot!", "Ures ertek nem megendegett!"})
    private String zip;

    private String line;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", line='" + line + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
