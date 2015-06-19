package org.dedda.games.scheisse.tool;

/**
 * Created by dedda on 6/28/14.
 */
public abstract class Binary {

    /**
     * Gets a bit on a specific position in a {@link Byte} from left to right.
     *
     * @param value    {@link Byte} value
     * @param position Position from left to right
     * @return Bit on this position
     */
    public static boolean getBitOnPositionLTR(
        final byte value, final int position) {
        byte mask = (byte) Math.pow(2, position);
        return (value & mask) > 0;
    }

    /**
     * Gets a bit on a specific position in a {@link Byte} from right to left.
     *
     * @param value    {@link Byte} value
     * @param position Position from right to left
     * @return Bit on this position
     */
    public static boolean getBitOnPositionRTL(
        final byte value, final int position) {
        byte mask = (byte) Math.pow(2, Byte.SIZE - position - 1);
        return (value & mask) > 0;
    }

    /**
     * Gets a bit on a specific position in a {@link Short} from left to right.
     *
     * @param value    {@link Short} value
     * @param position Position from left to right
     * @return Bit on this position
     */
    public static boolean getBitOnPositionLTR(
        final short value, final int position) {
        short mask = (short) Math.pow(2, position);
        return (value & mask) > 0;
    }

    /**
     * Gets a bit on a specific position in a {@link Short} from right to left.
     *
     * @param value    {@link Short} value
     * @param position Position from right to left
     * @return Bit on this position
     */
    public static boolean getBitOnPositionRTL(
        final short value, final int position) {
        short mask = (short) Math.pow(2, Short.SIZE - position - 1);
        return (value & mask) > 0;
    }

    /**
     * Gets a bit on a specific position in an
     * {@link Integer} from left to right.
     *
     * @param value    {@link Integer} value
     * @param position Position from left to right
     * @return Bit on this position
     */
    public static boolean getBitOnPositionLTR(
        final int value, final int position) {
        double pow = Math.pow(2, Integer.SIZE - position - 1);
        int mask;
        if (pow > Integer.MAX_VALUE) {
            mask = Integer.MIN_VALUE;
        } else {
            mask = (int) Math.pow(2, Integer.SIZE - position - 1);
        }
        return (value & mask) > 0;
    }

    /**
     * Gets a bit on a specific position in an
     * {@link Integer} from right to left.
     *
     * @param value    {@link Integer} value
     * @param position Position from right to left
     * @return Bit on this position
     */
    public static boolean getBitOnPositionRTL(
        final int value, final int position) {
        double pow = Math.pow(2, position);
        int mask;
        if (pow > Integer.MAX_VALUE) {
            mask = Integer.MIN_VALUE;
        } else {
            mask = (int) Math.pow(2, position);
        }
        return (value & mask) > 0;
    }
}
