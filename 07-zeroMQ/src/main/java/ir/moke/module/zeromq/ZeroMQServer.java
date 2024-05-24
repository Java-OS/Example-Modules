package ir.moke.module.zeromq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Optional;

public class ZeroMQServer {
    public static final ZeroMQServer instance = new ZeroMQServer();
    private static final Logger logger = LoggerFactory.getLogger(ZeroMQServer.class);
    private static final String zeroMQServerUrl = System.getenv("ZMQ_SERVER_URL");
    private static ZContext zContext;
    private static ZMQ.Socket socket;

    private ZeroMQServer() {
    }

    public void start() {
        try {
            zContext = new ZContext();
            socket = zContext.createSocket(SocketType.REP);
            socket.bind(Optional.ofNullable(zeroMQServerUrl).orElse("tcp://*:5555"));
            consumeMessages(socket);
        } catch (Exception e) {
            logger.error("ZeroMQ error", e);
        }
    }

    public void stop() {
        try {
            socket.close();
            zContext.close();
            logger.info("ZeroMQ server stopped");
        } catch (Exception e) {
            logger.error("ZeroMQ error", e);
        }
    }

    public void consumeMessages(ZMQ.Socket socket) {
        while (!zContext.isClosed()) {
            byte[] recv = socket.recv();
            logger.info("Receive message : {}", new String(recv));

            socket.send("Message received");
        }
    }
}
