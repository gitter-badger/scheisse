package org.dedda.games.scheisse_server.util;

import java.security.MessageDigest;

/**
 * @author dedda
 */
public abstract class Util {

    /**
     * Hashes {@link String}s through MD5.
     *
     * @param md5 {@link String} to hash
     * @return MD5 hashed {@link String}
     * @see MessageDigest
     */
    public static String MD5(final String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
