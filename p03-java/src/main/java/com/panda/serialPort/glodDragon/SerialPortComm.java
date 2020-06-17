/*
package com.panda.serialPort.glodDragon;*/
/**
 * Created by My on 2019-10-26.
 *//*


import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

*/
/**
 * @Author: Likaisheng
 * @Description:该类负责串口通信，只负责最基础的数据读写，不添加任何额外的功能
 * @Date: Created in 09:49:59 2019-10-26
 * @Modified By:
 *//*

public class SerialPortComm {
//    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,3,10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    private static ScheduledExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
    private InputStream inputStream;
    private OutputStream outputStream;
    private SerialPort serialPort;
    //设置起始位
    private byte startBit = 02; //默认为02
    private byte endBit = 03;   //默认为03
    private byte[] readBuf = new byte[1024];
    private int readLen = 0;

    public SerialPortComm(SerialPort serialPort) {
        this.serialPort = serialPort;
        try {
            inputStream = serialPort.getInputStream();
            outputStream = serialPort.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("初始化通信类失败!");
        }
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    */
/**
     * 根据起始位，读取一条数据
     * @param timeout 超时时间
     * @return
     * @throws IOException
     *//*

    public byte[] read(int timeout) throws IOException {
        byte[] buf = new byte[1024];
        int len = 0;
        int flag = 0; //用来控制数据 1-代表开始，2-代表结束
        long startTime = System.currentTimeMillis();
        long currentTime = startTime;

        loop1: while (true){
            currentTime = System.currentTimeMillis();
            if (currentTime - startTime > timeout){
                throw new RuntimeException("读超时");
            }
            while (inputStream.available() > 0){
                len = inputStream.read(buf);
                for (int i = 0; i < len; i++){
                    if (buf[i] == endBit && flag == 1){
                        flag = 2;
                        break loop1;
                    }
                    if (flag == 1){
                        readBuf[readLen++] = buf[i];
                    }
                    if (buf[i] == startBit){
                        flag = 1;
                    }
                }
            }
        }
        return Arrays.copyOf(readBuf, readLen);
    }
    //添加起始位后写出
    public void write(byte[] bytes) throws IOException {
        byte[] tmpBytes = new byte[bytes.length + 2];
        tmpBytes[0] = startBit;
        int idx = 1;
        for (int i = 0; i < bytes.length; i++) {
            tmpBytes[idx] = bytes[i];
        }
        outputStream.write(tmpBytes);
    }

    //关闭串口
    public void close(){
        serialPort.close();
        serialPort = null;
    }
    public void syncRead(){
        AsyRead asyRead = new AsyRead();
        threadPool.scheduleAtFixedRate(asyRead,0,100,TimeUnit.MILLISECONDS);
    }

    class AsyRead implements Runnable{

        @Override
        public void run() {
            try {
                asyRead();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
/**
         * 异步读，会有丢失数据的现象
         * @return
         * @throws IOException
         *//*

        public void asyRead() throws IOException {
            byte[] buf = new byte[1024];
            int len = 0;
            boolean flag = false;

            if (inputStream.available() > 0){
                len = inputStream.read(buf);
                for (int i = 0; i < len; i++){
                    if (buf[i] == endBit){
                        flag = false;
                        System.out.println();
                    }
                    if (flag){
                        System.out.print(buf[i]+" ");
                    }
                    if (buf[i] == startBit){
                        flag = true;
                    }
                }
            }
        }
    }
}
*/
