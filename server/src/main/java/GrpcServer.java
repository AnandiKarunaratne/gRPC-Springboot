import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.anda.grpcspring.lib.HelloReply;
import org.anda.grpcspring.lib.HelloRequest;
import org.anda.grpcspring.lib.MyServiceGrpc;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new MyServiceImpl())
                .build();

        server.start();
        server.awaitTermination();
    }


    @GrpcService
    public static class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

        @Override
        public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
            HelloReply reply = HelloReply.newBuilder()
                    .setMessage("Hello ==> " + request.getName())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

    }

}
