import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.anda.grpcspring.lib.HelloReply;
import org.anda.grpcspring.lib.HelloRequest;
import org.anda.grpcspring.lib.MyServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);

        HelloReply helloResponse = stub.sayHello(HelloRequest
                .newBuilder()
                .setName("Anandi")
                .build());

        System.out.println("Response received from server:\n" + helloResponse);

        channel.shutdown();
    }
}
