package socketPractice;

import socketPractice.Interfaces.ISocketWrapper;

import java.net.Socket;

public class SocketWrapper implements ISocketWrapper {
    private final Socket socket;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }
}
