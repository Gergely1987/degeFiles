package builder.robot;

public class SetMovementCapabilityFrameBuilder {

    private byte[] data = {4, 96, 10, 98, 8, 0};

    public SetMovementCapabilityFrameBuilder setMaximumSpeed(byte speed) {
        data[1] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationSpeed(byte speed) {
        data[2] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumAcceleration(byte acceleration) {
        data[3] = acceleration;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationalAcceleration(byte acceleration) {
        data[4] = acceleration;
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
