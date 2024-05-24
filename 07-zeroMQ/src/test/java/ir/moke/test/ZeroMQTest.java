package ir.moke.test;

import org.junit.jupiter.api.Test;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZeroMQTest {

    @Test
    public void sendMessage() {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket socket = context.createSocket(SocketType.REQ);
            socket.connect("tcp://localhost:5555");

            String request = "Hello";
            socket.send(request.getBytes(ZMQ.CHARSET), 0);

            byte[] reply = socket.recv();
            System.out.printf("Reply : %s%n", new String(reply));
        }
    }
}
