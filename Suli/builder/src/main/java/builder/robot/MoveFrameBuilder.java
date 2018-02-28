package builder.robot;

public class MoveFrameBuilder {
    private byte[] data = {125, 0, 0, 0, 0, 0};

    public MoveFrameBuilder setXSpeed(byte speed) {
        data[1] = speed;
        return this;
    }

    public MoveFrameBuilder setYSpeed(byte speed) {
        data[2] = speed;
        return this;
    }

    public MoveFrameBuilder setRotationSpeed(byte speed) {
        data[3] = speed;
        return this;
    }

    public MoveFrameBuilder setMaximumSpeed(byte speed) {
        data[4] = speed;
        return this;
    }

    private byte checksum() {
        byte sum = 0;
        for (byte b: data) {
            sum += b;
        }
        data[5] = sum;
        return sum;
    }

    public Frame build() {
        checksum();
        return new Frame(data);
    }

}
