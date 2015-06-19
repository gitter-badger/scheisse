package org.dedda.games.scheisse.tool;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTest {

    @Test
    public void testGetBitOnPositionRTLByte() throws Exception {
        byte value = 0x20;
        for (int i = 0; i < Byte.SIZE; i++) {
            if (i == 2) {
                assertTrue(Binary.getBitOnPositionRTL(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionRTL(value, i));
            }
        }
    }

    @Test
    public void testGetBitOnPositionLTRByte() throws Exception {
        byte value = 0x04;
        for (int i = 0; i < Byte.SIZE; i++) {
            if (i == 2) {
                assertTrue(Binary.getBitOnPositionLTR(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionLTR(value, i));
            }
        }
    }

    @Test
    public void testGetBitOnPositionRTLShort() throws Exception {
        short value = 0x6003;
        for (int i = 0; i < Short.SIZE; i++) {
            if (i == 1 || i == 2 || i == 14 || i == 15) {
                assertTrue(Binary.getBitOnPositionRTL(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionRTL(value, i));
            }
        }
    }

    @Test
    public void testGetBitOnPositionLTRShort() throws Exception {
        short value = 0x6003;
        for (int i = 0; i < Short.SIZE; i++) {
            if (i == 14 || i == 13 || i == 1 || i == 0) {
                assertTrue(Binary.getBitOnPositionLTR(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionLTR(value, i));
            }
        }
    }

    @Test
    public void testGetBitOnPositionRTLInt() throws Exception {
        int value = 0x40008003;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (i == 0 || i == 1 || i == 15 || i == 30) {
                assertTrue(Binary.getBitOnPositionRTL(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionRTL(value, i));
            }
        }
    }

    @Test
    public void testGetBitOnPositionLTRInt() throws Exception {
        int value = 0x40008003;
        for (int i = 0; i < Integer.SIZE; i++) {
            if (i == 1 || i == 16 || i == 30 || i == 31) {
                assertTrue(Binary.getBitOnPositionLTR(value, i));
            } else {
                assertFalse(Binary.getBitOnPositionLTR(value, i));
            }
        }
    }
}
