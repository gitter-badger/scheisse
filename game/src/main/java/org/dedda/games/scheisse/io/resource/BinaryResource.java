package org.dedda.games.scheisse.io.resource;

/**
 * Created by dedda on 6/27/14.
 */
public class BinaryResource {

    private int type;
    private byte[] dataBytes;

    public BinaryResource(final byte[] dataBytes, final int type) {
        this.dataBytes = dataBytes;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public byte[] getDataBytes() {
        return dataBytes;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj.getClass().equals(getClass())) {
            BinaryResource resource = (BinaryResource) obj;
            if (resource.type == this.type) {
                if (resource.getDataBytes().length == this.dataBytes.length) {
                    for (int i = 0; i < dataBytes.length; i++) {
                        if (resource.getDataBytes()[i] != dataBytes[i]) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
