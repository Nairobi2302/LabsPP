package lab5;
class FabricMetadata {
    private String metadata;

    public FabricMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getMetadata() {
        return metadata;
    }
}

class FabricMetadataDecorator extends AbstractFabric {
    private AbstractFabric fabric;
    private FabricMetadata metadata;

    public FabricMetadataDecorator(AbstractFabric fabric, String metadata) {
        super(fabric.getBrand(), fabric.getType(), fabric.getWeight());
        this.fabric = fabric;
        this.metadata = new FabricMetadata(metadata);
    }

    public FabricMetadata getMetadata() {
        return metadata;
    }

    @Override
    public String getType() {
        return fabric.getType();
    }

    @Override
    public String getBrand() {
        return fabric.getBrand();
    }

    @Override
    public String getWeight() {
        return fabric.getWeight();
    }
}

class FabricBuilder {
    private String type;
    private String brand;
    private String weight;
    private static FabricBuilder instance;

    private FabricBuilder() {
        // Private constructor to prevent instantiation outside this class
    }

    public static FabricBuilder getInstance() {
        if (instance == null) {
            instance = new FabricBuilder();
        }
        return instance;
    }
    public FabricBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public FabricBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public FabricBuilder setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public Fabric build() {
        return new Fabric(brand, type, weight);
    }
}
abstract class AbstractFabric {
    protected String Type;
    protected String Brand;
    protected String Weight;

    public AbstractFabric(String Brand, String Type, String Weight) {
        this.Type = Type;
        this.Brand = Brand;
        this.Weight = Weight;
    }

    public abstract String getWeight();

    public abstract String getType();

    public abstract String getBrand();
}

class Fabric extends AbstractFabric {
    public Fabric(String Brand, String Type, String Weight) {
        super(Brand, Type, Weight);
    }

    @Override
    public String getWeight() {
        return Weight;
    }

    @Override
    public String getType() {
        return Type;
    }

    @Override
    public String getBrand() {
        return Brand;
    }
}
