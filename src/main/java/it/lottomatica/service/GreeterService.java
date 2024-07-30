package it.lottomatica.service;

import io.grpc.stub.StreamObserver;
import it.lottomatica.grpcdemo.GreeterGrpc;
import it.lottomatica.grpcdemo.HelloReply;
import it.lottomatica.grpcdemo.HelloRequest;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Autowired
    CustomMongoService customMongoService;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "Hello, " + customMongoService.findById("66a9039346f5347e4fd77e53").getName();
        HelloReply reply = HelloReply.newBuilder().setMessage(message).build();

        ;
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
