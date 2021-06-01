# gRPC-Springboot
gRPC-server/client setup with Spring boot

## How to run
1. Clone the repository.
2. Run `pom.xml`.
3. In `target/generated-sources/protobuf/grpc-java/org/anda/grpcspring/lib/MyServiceGrpc.java` add the following class to override method `SayHello`.

```
@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello ==> " + request.getName())
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
```
4. Run `src/main/java/GrpcServer.java`.
5. Run `src/main/java/GrpcClient.java`.
