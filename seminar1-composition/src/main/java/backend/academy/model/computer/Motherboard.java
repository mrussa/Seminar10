package backend.academy.model.computer;

public class Motherboard extends Component {
    public static final String TYPE = "MB";
    private final String socketType;
    private final int maxRamSlots;

    public Motherboard(
        String name,
        double price,
        String socketType,
        int maxRamSlots
    ) {
        super(name, price);
        this.socketType = socketType;
        this.maxRamSlots = maxRamSlots;
    }

    public String getSocketType() {
        return socketType;
    }

    public int getMaxRamSlots() {
        return maxRamSlots;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getSpecs() {
        return "Motherboard{name=" + getName()
               + ", socketType='" + getSocketType()
               + "', maxRamSlots=" + maxRamSlots +
               "}";
    }
}
