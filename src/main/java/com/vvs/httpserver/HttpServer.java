package com.vvs.httpserver;

import com.vvs.httpserver.config.Configuration;
import com.vvs.httpserver.config.ConfigurationManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * Driver Class for the HTTP Server
 *
 */

public class HttpServer {
    public static void main(String[] args){
        System.out.println("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        System.out.println("Using Port: " + conf.getPort());
        System.out.println("Using WebRoot: " + conf.getWebroot());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // TODO we would read
            String html = "<html><head><title>VVS Java HTTP Server</title></head><body><h1>This page was served using my VVS Java HTML Server</h1></body></html>";

            final String CRLF = "\n\r"; // 13,10
            //TODO we would do the writing
            String response =
                    "HTTP/1.1 200 OK" + CRLF + // Status line : HTTP  VERIOSN RESPONSE CODE RESPONSE MESSAGE
                     "Content-Length: " + html.getBytes().length + CRLF + //HEADER
                            CRLF +
                            html +
                            CRLF + CRLF ;

            outputStream.write(response.getBytes());

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
