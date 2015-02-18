package org.dedda.games.scheisse.tool;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.geom.Point2D;

/**
 * Class for parsing {@link java.lang.String}s to numbers or number
 * based objects such as {@link java.awt.Dimension}s and casting numbers
 * to a different type.
 *
 * Created by dedda on 5/22/14.
 *
 * @author dedda
 */
public abstract class Parse {

    /**
     * Used for masking {@link java.lang.Short} values to the length of a
     * {@link java.lang.Byte}.
     */
    private static final short SHORT_TO_BYTE_MASK = 0x00FF;

    /**
     * Used for masking {@link java.lang.Integer} values to the length of a
     * {@link java.lang.Byte}.
     */
    private static final int INT_TO_BYTE_MASK = 0x000000FF;

    /**
     * Parsing a {@link java.lang.String} to an {@link java.lang.Integer}.
     *
     * @see Integer#parseInt(java.lang.String)
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.lang.Integer}
     */
    public static int toInteger(final String string) {
        return Integer.parseInt(string);
    }

    /**
     * Parsing a {@link java.lang.String} to a {@link java.lang.Long}.
     *
     * @see Long#parseLong(java.lang.String)
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.lang.Long}
     */
    public static long toLong(final String string) {
        return Long.parseLong(string);
    }

    /**
     * Parsing a {@link java.lang.String} to a {@link java.lang.Float}.
     *
     * @see Float#parseFloat(java.lang.String)
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.lang.Float}
     */
    public static float toFloat(final String string) {
        return Float.parseFloat(string);
    }

    /**
     * Parsing a {@link java.lang.String} to a {@link java.lang.Double}.
     *
     * @see Double#parseDouble(java.lang.String)
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.lang.Double}
     */
    public static double toDouble(final String string) {
        return Double.parseDouble(string);
    }

    /**
     * Parsing a {@link java.lang.String} to a {@link java.awt.Point}.
     *
     * Syntax for {@link java.awt.Point}s in {@link java.lang.String}
     * representation looks like this: "locationX,locationY"
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.awt.Point}
     */
    public static Point toPoint(final String string) {
        int x = toInteger(string.substring(0, string.indexOf(',')));
        int y = toInteger(string.substring(string.indexOf(',') + 1));
        return new Point(x, y);
    }

    /**
     * Parsing a {@link java.lang.String} to a
     * {@link java.awt.geom.Point2D.Float}.
     *
     * Syntax for {@link java.awt.geom.Point2D.Float}s in
     * {@link java.lang.String} representation looks
     * like this: "locationX.xX,locationY.yY"
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.awt.geom.Point2D.Float}
     */
    public static Point2D.Float toPoint2DFloat(final String string) {
        float x = toFloat(string.substring(0, string.indexOf(',')));
        float y = toFloat(string.substring(string.indexOf(',') + 1));
        return new Point2D.Float(x, y);
    }

    /**
     * Parsing a {@link java.lang.String} to a
     * {@link java.awt.geom.Point2D.Double}.
     *
     * Syntax for {@link java.awt.geom.Point2D.Double}s
     * in {@link java.lang.String} representation looks
     * like this: "locationX.xX,locationY.yY"
     *
     * @param string {@link java.lang.String} to be parsed
     * @return Parsed {@link java.awt.geom.Point2D.Double}
     */
    public static Point2D.Double toPoint2DDouble(final String string) {
        double x = toDouble(string.substring(0, string.indexOf(',')));
        double y = toDouble(string.substring(string.indexOf(',') + 1));
        return new Point2D.Double(x, y);
    }

    /**
     * Parsing a {@link java.lang.String} to a {@link java.lang.Boolean} value.
     *
     * Every {@link java.lang.String} that is not "1" or "true"
     * evaluates to "false". Evaluation is case insensitive.
     *
     * @param string {@link java.lang.String} to parse
     * @return Parsed {@link java.lang.Boolean}
     */
    public static boolean toBoolean(final String string) {
        if (string.equals("1") || string.toLowerCase().equals("true")) {
            return true;
        }
        return false;
    }

    /**
     * Parsing a {@link java.lang.String} to a
     * {@link java.awt.Dimension} value.
     *
     * Syntax for {@link java.awt.Dimension}s in {@link java.lang.String}
     * representation looks like this: "width,height"
     *
     * @param string {@link java.lang.String} to parse
     * @return Parsed {@link java.awt.Dimension}
     */
    public static Dimension toDimension(final String string) {
        Point point = toPoint(string);
        return new Dimension(point.x, point.y);
    }

    /**
     * Casting a {@link java.lang.Short} to a {@link java.lang.Byte}.
     *
     * The left (most significant) 8 bit get cut off and the
     * right (least significant) 8 bit are pushed in the
     * {@link java.lang.Byte}.
     *
     * @param value {@link java.lang.Short} to cast
     * @return Casted {@link java.lang.Byte}
     */
    public static byte toByte(final short value) {
        return (byte)((short) (value & SHORT_TO_BYTE_MASK));
    }

    /**
     * Casting a {@link java.lang.Integer} to a {@link java.lang.Byte}.
     *
     * The left (most significant) 24 bit get cut off and the
     * right (least significant) 8 bit are pushed in the {@link java.lang.Byte}.
     *
     * @param value {@link java.lang.Integer} to cast
     * @return Casted {@link java.lang.Byte}
     */
    public static byte toByte(final int value) {
        return (byte)((int) (value & INT_TO_BYTE_MASK));
    }

    /**
     * Casting a {@link java.lang.Short} array to a
     * {@link java.lang.Byte} array.
     *
     * @see #toByte(short)
     *
     * @param values Array of {@link java.lang.Short} values to cast
     * @return Array of casted {@link java.lang.Byte} values
     */
    public static byte[] toByteArray(final short[] values) {
        byte[] ret = new byte[values.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = toByte(values[i]);
        }
        return ret;
    }

    /**
     * Casting a {@link java.lang.Integer} array to a
     * {@link java.lang.Byte} array.
     *
     * @see #toByte(int)
     *
     * @param values Array of {@link java.lang.Integer} values to cast
     * @return Array of casted {@link java.lang.Byte} values
     */
    public static byte[] toByteArray(final int[] values) {
        byte[] ret = new byte[values.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = toByte(values[i]);
        }
        return ret;
    }
}
