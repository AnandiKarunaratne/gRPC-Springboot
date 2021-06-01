import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.anda.grpcspring.lib.MyServiceGrpc;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new MyServiceGrpc.MyServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }
}
