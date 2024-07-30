package it.lottomatica.client;


import it.lottomatica.grpcdemo.GreeterGrpc;
import it.lottomatica.grpcdemo.HelloReply;
import it.lottomatica.grpcdemo.HelloRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloReply response = stub.sayHello(HelloRequest.newBuilder().setName("World").build());

        System.out.println(response.getMessage());

        channel.shutdown();
    }
}

