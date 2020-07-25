package com.learn.databases_cluster;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

@SpringBootTest
class DatabasesClusterApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(DatabasesClusterApplicationTests.class);

    @Test
    void contextLoads() {
        checkIpPort("192.168.249.129", 3306);
    }

    public static boolean checkIpPort(String ip, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, port), 3000);
            logger.info("\n地址和端口号可用");
            return true;
        } catch (Exception e) {
            logger.info("\n地址和端口号不可用");
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

    }
}
