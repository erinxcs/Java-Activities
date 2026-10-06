// CARL JAYSON ELI BONAOBRA
// CPE2A
// Activity: Custom MD5 Hashing Implementation

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CustomMD5Hasher {

    // Per-round left-rotation amounts defined by the MD5 algorithm.
    private static final int[] SHIFT_AMOUNTS = {
        7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
        5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
        4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
        6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21
    };

    // Constants derived from the sine function as required by MD5.
    private static final int[] CONSTANTS = new int[64];

    static {
        for (int index = 0; index < CONSTANTS.length; index++) {
            long value = (long) Math.floor(
                    Math.pow(2, 32) * Math.abs(Math.sin(index + 1))
            );
            CONSTANTS[index] = (int) value;
        }
    }

    public static String md5(String message) {
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        long messageLengthBits = (long) messageBytes.length * 8L;

        // Add one 1-bit, enough 0-bits, and 64 bits for the original length.
        int paddedLength = ((messageBytes.length + 8) / 64 + 1) * 64;
        byte[] paddedMessage = new byte[paddedLength];

        System.arraycopy(messageBytes, 0, paddedMessage, 0, messageBytes.length);
        paddedMessage[messageBytes.length] = (byte) 0x80;

        // MD5 stores the original bit length in little-endian order.
        for (int index = 0; index < 8; index++) {
            paddedMessage[paddedLength - 8 + index]
                    = (byte) (messageLengthBits >>> (8 * index));
        }

        int a0 = 0x67452301;
        int b0 = 0xefcdab89;
        int c0 = 0x98badcfe;
        int d0 = 0x10325476;

        for (int offset = 0; offset < paddedMessage.length; offset += 64) {
            int[] words = new int[16];

            for (int wordIndex = 0; wordIndex < 16; wordIndex++) {
                int byteIndex = offset + wordIndex * 4;
                words[wordIndex]
                        = (paddedMessage[byteIndex] & 0xff)
                        | ((paddedMessage[byteIndex + 1] & 0xff) << 8)
                        | ((paddedMessage[byteIndex + 2] & 0xff) << 16)
                        | ((paddedMessage[byteIndex + 3] & 0xff) << 24);
            }

            int a = a0;
            int b = b0;
            int c = c0;
            int d = d0;

            for (int step = 0; step < 64; step++) {
                int functionResult;
                int wordIndex;

                if (step < 16) {
                    functionResult = (b & c) | (~b & d);
                    wordIndex = step;
                } else if (step < 32) {
                    functionResult = (d & b) | (~d & c);
                    wordIndex = (5 * step + 1) % 16;
                } else if (step < 48) {
                    functionResult = b ^ c ^ d;
                    wordIndex = (3 * step + 5) % 16;
                } else {
                    functionResult = c ^ (b | ~d);
                    wordIndex = (7 * step) % 16;
                }

                int oldD = d;
                d = c;
                c = b;
                b = b + Integer.rotateLeft(
                        a + functionResult + CONSTANTS[step] + words[wordIndex],
                        SHIFT_AMOUNTS[step]
                );
                a = oldD;
            }

            a0 += a;
            b0 += b;
            c0 += c;
            d0 += d;
        }

        return toLittleEndianHex(a0)
                + toLittleEndianHex(b0)
                + toLittleEndianHex(c0)
                + toLittleEndianHex(d0);
    }

    private static String toLittleEndianHex(int value) {
        StringBuilder hex = new StringBuilder(8);

        for (int index = 0; index < 4; index++) {
            hex.append(String.format("%02x", value & 0xff));
            value >>>= 8;
        }

        return hex.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter message to hash: ");
            String input = scanner.nextLine();
            System.out.println("MD5 Hash: " + md5(input));
        }
    }
}
