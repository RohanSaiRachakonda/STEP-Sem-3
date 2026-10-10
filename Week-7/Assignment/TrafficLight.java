public class TrafficLight {
    // Final identifier fixed at creation
    private final String id;
    // Current color can only cycle via next()
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; // A new light always starts on red
    }

    // Moves through cycle: RED -> GREEN -> YELLOW -> RED
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

    // Read-only getter for ID
    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
        System.out.println("t.next() -> \"" + t.next() + "\"");
    }
}
