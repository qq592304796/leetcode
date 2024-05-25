package org.jiangxinjun.l1542;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author jiangxinjun
 * @since 2024/5/23
 */
@Slf4j
public class L1424Test {

    @Test
    public void test() {
        log.info(String.valueOf(0 >> 1 << 1));

        log.info(String.valueOf(1 >> 1 << 1));

        log.info("{}, {}", 0x10, Integer.toHexString(0x10));

        log.info("{}, {}", 0b10, Integer.toBinaryString(0b10));

        log.info("{}, {}", 010, Integer.toString(010, 8));

        log.info("{}, {}", 1.2e+10, (long) 1.2e+10);

        log.info("{}, {}", 0b1011, Integer.toBinaryString(0b1011));

        log.info("{}, {}", 0b00010000, Integer.toBinaryString(0b00010000));

        log.info("{}, {}", 0b00010000 | (1 << 2), Integer.toBinaryString(0b00010000 | (1 << 2)));

    }

}
