package com.fbb.sign;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortAliveService {
    private static Logger logger = LoggerFactory.getLogger(PortAliveService.class); 

    public static void main(String[] args) {
        exceCmd();

    }
    
    private static boolean tag = false;
    
    public static void start(){
        tag = true;
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while(tag) {
                    exceCmd();
                    try {
                        Thread.sleep(1000 * 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        
    }
    
    public static void stop(){
        tag = false; 
    }

    
    private static boolean exceCmd() {
        Runtime runtime = Runtime.getRuntime();
        try {
            
//            String cmd = "/Users/bu54/Library/Android/sdk/platform-tools/adb forward tcp:8000 tcp:9000";
            String cmd = "/home/fengbb/Android/android-sdk-linux/platform-tools/adb forward tcp:8000 tcp:9000";
            Process process = runtime.exec(cmd);
//            //String[] commands = new String[] { "/bin/bash", "-c", "adb forward tcp:8000 tcp:9000" };
//            //runtime.exec(commands);
//            BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            BufferedReader stderrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
//            String line;
//            System.out.println("OUTPUT");
//            while ((line = stdoutReader.readLine()) != null) {
//                System.out.println(line);
//            }
//            System.out.println("ERROR");
//            while ((line = stderrReader.readLine()) != null) {
//                System.out.println(line);
//            }
            int exitVal = process.waitFor();
            logger.info("process exit value is " + exitVal);
            return exitVal == 0? true : false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

}
