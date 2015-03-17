package org.dedda.games.scheisse.tool;

import org.junit.Test;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParseTest {

    @Test
    public void testToInteger() throws Exception {
        String string = "123";
        assertTrue(123 == Parse.toInteger(string));
    }

    @Test
    public void testToLong() throws Exception {
        String string = "123";
        assertTrue(123L == Parse.toLong(string));
    }

    @Test
    public void testToFloat() throws Exception {
        String string = "123.45";
        assertTrue(123.45f == Parse.toFloat(string));
    }

    @Test
    public void testToDouble() throws Exception {
        String string = "123.45";
        assertTrue(123.45 == Parse.toDouble(string));
    }

    @Test
    public void testToPoint() throws Exception {
        String string = "123,456";
        assertEquals(new Point(123, 456), Parse.toPoint(string));
    }

    @Test
    public void testToPoint2DFloat() throws Exception {
        String string = "123.45,678.9";
        assertEquals(
                new Point2D.Float(123.45f, 678.9f),
                Parse.toPoint2DFloat(string)
        );
    }

    @Test
    public void testToPoint2DDouble() throws Exception {
        String string = "123.45,678.9";
        assertEquals(
                new Point2D.Double(123.45, 678.9),
                Parse.toPoint2DDouble(string)
        );
    }

    @Test
    public void testToBoolean() throws Exception {
        String one = "1";
        String t = "true";
        String zero = "0";
        String f = "false";
        assertTrue(Parse.toBoolean(one));
        assertTrue(Parse.toBoolean(t));
        assertFalse(Parse.toBoolean(zero));
        assertFalse(Parse.toBoolean(f));
    }

    @Test
    public void testToDimension() throws Exception {
        String string = "123,456";
        assertEquals(new Dimension(123, 456), Parse.toDimension(string));
    }

    @Test
    public void testToByteShort() throws Exception {
        short value = 0x00FE;
        byte expected = (byte) 0xFE;
        assertTrue(expected == Parse.toByte(value));
    }

    @Test
    public void testToByteInt() throws Exception {
        int value = 0x000000FE;
        byte expected = (byte) 0xFE;
        assertTrue(expected == Parse.toByte(value));
    }

    @Test
    public void testToByteArrayShort() throws Exception {
        short values[] = {0x00FE, 0x00A7, 0x0010};
        byte expected[] = {(byte) 0xFE, (byte) 0xA7, 0x10};
        byte actual[] = Parse.toByteArray(values);
        for(int i = 0; i < values.length; i++){
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void testToByteArrayInt() throws Exception {
        int values[] = {0x000000FE, 0x000000A7, 0x00000010};
        byte expected[] = {(byte) 0xFE, (byte) 0xA7, 0x10};
        byte actual[] = Parse.toByteArray(values);
        for(int i = 0; i < values.length; i++){
            assertTrue(expected[i] == actual[i]);
        }
    }
}