package socketPractice.Interfaces;

import java.io.IOException;

public interface IServerSocketWrapper {
    public ISocketWrapper accept() throws IOException;
}
