package lab4;
public class Fabric {
    private String Type;
    private String Weight;
	private String Brand;

    Fabric(String Brand, String Type, String Weight) {
        this.Brand = Brand;
        this.Type = Type;
        this.Weight = Weight;
    }

    public String getWeight() {
        return Weight;
    }

    public String getType() {
        return Type;
    }

    public String getBrand() {
        return Brand;
    }
}
