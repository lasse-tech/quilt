public class foo {
    public static void main(String[] args) {
        short port = 80;
        Light light = new Light(270, 0.8, 0.5);
        light.initAdapter("127.0.0.1", port, "light/0");
    }
}


public class Light {
    //private Adapter adapter;

    private boolean isOn;
    private int hue;
    private double brightness;
    private double saturation;

    public Light() {

    }

    public Light(int hue, double brightness, double saturation) {
        setHue(hue);
        //// .....
        turnOff();
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public void initAdapter(String ipAddress, short Port, String endPoint) {
        //adapter = new Adapter(ip, Port, endPoint);
        return;
    }

    public void turnOn() {
        //adapter.send("on");
    }

    public void turnOff() {
        //adapter.send("off");
    }
}
