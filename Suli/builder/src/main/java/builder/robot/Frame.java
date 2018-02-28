package builder.robot;

public class Frame {
    private byte [] bytes;

    public Frame(byte bytes[]) {
        this.bytes = bytes;
    }

    public String toHexString() {
        if (bytes.length == 0) {
            return "";
        }
        StringBuilder hex = new StringBuilder();
        for (byte b: bytes) {
            hex.append(String.format("%02x", b).toUpperCase());
            hex.append("-");
        }
        return hex.substring(0, hex.length()-1).toString();
    }



    public byte [] getBytes() {
        return bytes;
    }
}
