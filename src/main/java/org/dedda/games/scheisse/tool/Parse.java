package org.dedda.games.scheisse.tool;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 * Class for parsing {@link String}s to numbers or number based objects
 * such as {@link Dimension}s and casting numbers to a different type.
 *
 * Created by dedda on 5/22/14.
 *
 * @author dedda
 */
public abstract class Parse {

    /**
     * Used for masking {@link Short} values to the length of a {@link Byte}.
     */
    private static final short SHORT_TO_BYTE_MASK = 0x00FF;

    /**
     * Used for masking {@link Integer} values to the length of a {@link Byte}.
     */
    private static final int INT_TO_BYTE_MASK = 0x000000FF;

    /**
     * Parsing a {@link String} to an {@link Integer}.
     *
     * @see Integer#parseInt(String)
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Integer}
     */
    public static int toInteger(final String string) {
        return Integer.parseInt(string);
    }

    /**
     * Parsing a {@link String} to a {@link Long}.
     *
     * @see Long#parseLong(String)
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Long}
     */
    public static long toLong(final String string) {
        return Long.parseLong(string);
    }

    /**
     * Parsing a {@link String} to a {@link Float}.
     *
     * @see Float#parseFloat(String)
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Float}
     */
    public static float toFloat(final String string) {
        return Float.parseFloat(string);
    }

    /**
     * Parsing a {@link String} to a {@link Double}.
     *
     * @see Double#parseDouble(String)
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Double}
     */
    public static double toDouble(final String string) {
        return Double.parseDouble(string);
    }

    /**
     * Parsing a {@link String} to a {@link Point}.
     *
     * Syntax for {@link Point}s in {@link String} representation looks
     * like this: "locationX,locationY"
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Point}
     */
    public static Point toPoint(final String string) {
        int x = toInteger(string.substring(0, string.indexOf(',')));
        int y = toInteger(string.substring(string.indexOf(',') + 1));
        return new Point(x, y);
    }

    /**
     * Parsing a {@link String} to a {@link Point2D.Float}.
     *
     * Syntax for {@link Point2D.Float}s in {@link String} representation looks
     * like this: "locationX.xX,locationY.yY"
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Point2D.Float}
     */
    public static Point2D.Float toPoint2DFloat(final String string) {
        float x = toFloat(string.substring(0, string.indexOf(',')));
        float y = toFloat(string.substring(string.indexOf(',') + 1));
        return new Point2D.Float(x, y);
    }

    /**
     * Parsing a {@link String} to a {@link Point2D.Double}.
     *
     * Syntax for {@link Point2D.Double}s in {@link String} representation looks
     * like this: "locationX.xX,locationY.yY"
     *
     * @param string {@link String} to be parsed
     * @return Parsed {@link Point2D.Double}
     */
    public static Point2D.Double toPoint2DDouble(final String string) {
        double x = toDouble(string.substring(0, string.indexOf(',')));
        double y = toDouble(string.substring(string.indexOf(',') + 1));
        return new Point2D.Double(x, y);
    }

    /**
     * Parsing a {@link String} to a {@link Boolean} value.
     *
     * Every {@link String} that is not "1" or "true" evaluates to "false".
     * Evaluation is case insensitive.
     *
     * @param string {@link String} to parse
     * @return Parsed {@link Boolean}
     */
    public static boolean toBoolean(final String string) {
        if (string.equals("1") || string.toLowerCase().equals("true")) {
            return true;
        }
        return false;
    }

    /**
     * Parsing a {@link String} to a {@link Dimension} value.
     *
     * Syntax for {@link Dimension}s in {@link String} representation looks
     * like this: "width,height"
     *
     * @param string {@link String} to parse
     * @return Parsed {@link Dimension}
     */
    public static Dimension toDimension(final String string) {
        Point point = toPoint(string);
        return new Dimension(point.x, point.y);
    }

    /**
     * Casting a {@link Short} to a {@link Byte}.
     *
     * The left (most significant) 8 bit get cut off and the
     * right (least significant) 8 bit are pushed in the {@link Byte}.
     *
     * @param value {@link Short} to cast
     * @return Casted {@link Byte}
     */
    public static byte toByte(final short value) {
        return (byte)((short) (value & SHORT_TO_BYTE_MASK));
    }

    /**
     * Casting a {@link Integer} to a {@link Byte}.
     *
     * The left (most significant) 24 bit get cut off and the
     * right (least significant) 8 bit are pushed in the {@link Byte}.
     *
     * @param value {@link Integer} to cast
     * @return Casted {@link Byte}
     */
    public static byte toByte(final int value) {
        return (byte)((int) (value & INT_TO_BYTE_MASK));
    }

    /**
     * Casting a {@link Short} array to a {@link Byte} array.
     *
     * @see #toByte(short)
     *
     * @param values Array of {@link Short} values to cast
     * @return Array of casted {@link Byte} values
     */
    public static byte[] toByteArray(final short[] values) {
        byte[] ret = new byte[values.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = toByte(values[i]);
        }
        return ret;
    }

    /**
     * Casting a {@link Integer} array to a {@link Byte} array.
     *
     * @see #toByte(int)
     *
     * @param values Array of {@link Integer} values to cast
     * @return Array of casted {@link Byte} values
     */
    public static byte[] toByteArray(final int[] values) {
        byte[] ret = new byte[values.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = toByte(values[i]);
        }
        return ret;
    }
}
