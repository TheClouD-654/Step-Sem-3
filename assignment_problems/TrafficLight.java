public class TrafficLight {
    private final String id;
    private String color;

    // Constructor: locks the traffic light ID; starts on RED
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    // Advances the light state in a strict fixed cycle: RED -> GREEN -> YELLOW -> RED
    // Returns the new color after transition
    public String next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            case "YELLOW":
                color = "RED";
                break;
            default:
                color = "RED";
                break;
        }
        return color;
    }

    // Read-only getter for current color
    public String getColor() {
        return color;
    }

    // Read-only getter for traffic light ID
    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
        System.out.println("t.next() -> " + t.next());
    }
}
