# gRPC-Springboot
gRPC-server/client setup with Spring boot

## How to run
1. Clone the repository.
2. Comment out the `main` method in `src/main/java/GrpcServer.java`.
3. Run `pom.xml`.
4. In `target/generated-sources/protobuf/grpc-java/org/anda/grpcspring/lib/MyServiceGrpc.java` add the following class to override method `SayHello`.

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
5. Uncomment the `main` method in `src/main/java/GrpcServer.java`. (Commented lines in step 2)
6. Run `src/main/java/GrpcServer.java`.
7. Run `src/main/java/GrpcClient.java`.
