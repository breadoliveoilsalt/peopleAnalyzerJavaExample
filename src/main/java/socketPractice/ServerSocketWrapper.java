package socketPractice;

import socketPractice.Interfaces.IServerSocketWrapper;
import socketPractice.Interfaces.ISocketWrapper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Options:
// a) 1-to-1 wrappers
// b) simplify-your-life-dealing-with-pure-Java-library-method wrappers


// Option (a)
public class ServerSocketWrapper implements IServerSocketWrapper {

    ServerSocket serverSocket;

    public ServerSocketWrapper(int port) throws IOException {
       this.serverSocket = new ServerSocket(port);
    }

    @Override
    public ISocketWrapper accept() throws IOException {
        Socket socket = serverSocket.accept();
        return new SocketWrapper(socket);
    }
}

// Option (b)
public class SocketManager {

    ServerSocket serverSocket;

    public SocketManager() throws IOException {
        serverSocket = new ServerSocket();
    }

    public void startListening(int port) {
        serverSocket.bind(port);
    }
};


// get port from args

ServerSocketWrapper ssWrapper = new ServerSocketWrapper(100);
socketWrapper = ssWrapper.accept()

ISocketReader reader = new Reader(socketWrapper);
String message = reader.getInput();