package com.fbb.sign;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VertifyUtil {
    private static Logger logger = LoggerFactory.getLogger(VertifyUtil.class);
    public static String getValueFromAndroid(String text) {
        String sign = "";
        try {
            Socket socket = new Socket("127.0.0.1", 8000);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(text);
            sign = dis.readUTF();
            System.out.println("sign:" + sign);
            socket.close();
        } catch (Exception e) {
            logger.error("sign", e);
        }
        return sign;
    }
}
