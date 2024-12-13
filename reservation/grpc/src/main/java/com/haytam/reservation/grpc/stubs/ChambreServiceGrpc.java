package com.haytam.reservation.grpc.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chambre.proto")
public final class ChambreServiceGrpc {

  private ChambreServiceGrpc() {}

  public static final String SERVICE_NAME = "ChambreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Common.Empty,
      Chambre.ChambreListResponse> getGetChambresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChambres",
      requestType = Common.Empty.class,
      responseType = Chambre.ChambreListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Common.Empty,
      Chambre.ChambreListResponse> getGetChambresMethod() {
    io.grpc.MethodDescriptor<Common.Empty, Chambre.ChambreListResponse> getGetChambresMethod;
    if ((getGetChambresMethod = ChambreServiceGrpc.getGetChambresMethod) == null) {
      synchronized (ChambreServiceGrpc.class) {
        if ((getGetChambresMethod = ChambreServiceGrpc.getGetChambresMethod) == null) {
          ChambreServiceGrpc.getGetChambresMethod = getGetChambresMethod = 
              io.grpc.MethodDescriptor.<Common.Empty, Chambre.ChambreListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChambreService", "GetChambres"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Chambre.ChambreListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChambreServiceMethodDescriptorSupplier("GetChambres"))
                  .build();
          }
        }
     }
     return getGetChambresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Chambre.CreateChambreRequest,
      Chambre.ChambreResponse> getCreateChambreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChambre",
      requestType = Chambre.CreateChambreRequest.class,
      responseType = Chambre.ChambreResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Chambre.CreateChambreRequest,
      Chambre.ChambreResponse> getCreateChambreMethod() {
    io.grpc.MethodDescriptor<Chambre.CreateChambreRequest, Chambre.ChambreResponse> getCreateChambreMethod;
    if ((getCreateChambreMethod = ChambreServiceGrpc.getCreateChambreMethod) == null) {
      synchronized (ChambreServiceGrpc.class) {
        if ((getCreateChambreMethod = ChambreServiceGrpc.getCreateChambreMethod) == null) {
          ChambreServiceGrpc.getCreateChambreMethod = getCreateChambreMethod = 
              io.grpc.MethodDescriptor.<Chambre.CreateChambreRequest, Chambre.ChambreResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChambreService", "CreateChambre"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Chambre.CreateChambreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Chambre.ChambreResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChambreServiceMethodDescriptorSupplier("CreateChambre"))
                  .build();
          }
        }
     }
     return getCreateChambreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Chambre.ChambreRequest,
      Common.DeleteResponse> getDeleteChambreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChambre",
      requestType = Chambre.ChambreRequest.class,
      responseType = Common.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Chambre.ChambreRequest,
      Common.DeleteResponse> getDeleteChambreMethod() {
    io.grpc.MethodDescriptor<Chambre.ChambreRequest, Common.DeleteResponse> getDeleteChambreMethod;
    if ((getDeleteChambreMethod = ChambreServiceGrpc.getDeleteChambreMethod) == null) {
      synchronized (ChambreServiceGrpc.class) {
        if ((getDeleteChambreMethod = ChambreServiceGrpc.getDeleteChambreMethod) == null) {
          ChambreServiceGrpc.getDeleteChambreMethod = getDeleteChambreMethod = 
              io.grpc.MethodDescriptor.<Chambre.ChambreRequest, Common.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChambreService", "DeleteChambre"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Chambre.ChambreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.DeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChambreServiceMethodDescriptorSupplier("DeleteChambre"))
                  .build();
          }
        }
     }
     return getDeleteChambreMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChambreServiceStub newStub(io.grpc.Channel channel) {
    return new ChambreServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChambreServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChambreServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChambreServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChambreServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChambreServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getChambres(Common.Empty request,
                            io.grpc.stub.StreamObserver<Chambre.ChambreListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetChambresMethod(), responseObserver);
    }

    /**
     */
    public void createChambre(Chambre.CreateChambreRequest request,
                              io.grpc.stub.StreamObserver<Chambre.ChambreResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateChambreMethod(), responseObserver);
    }

    /**
     */
    public void deleteChambre(Chambre.ChambreRequest request,
                              io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteChambreMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetChambresMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Common.Empty,
                Chambre.ChambreListResponse>(
                  this, METHODID_GET_CHAMBRES)))
          .addMethod(
            getCreateChambreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Chambre.CreateChambreRequest,
                Chambre.ChambreResponse>(
                  this, METHODID_CREATE_CHAMBRE)))
          .addMethod(
            getDeleteChambreMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Chambre.ChambreRequest,
                Common.DeleteResponse>(
                  this, METHODID_DELETE_CHAMBRE)))
          .build();
    }
  }

  /**
   */
  public static final class ChambreServiceStub extends io.grpc.stub.AbstractStub<ChambreServiceStub> {
    private ChambreServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChambreServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChambreServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChambreServiceStub(channel, callOptions);
    }

    /**
     */
    public void getChambres(Common.Empty request,
                            io.grpc.stub.StreamObserver<Chambre.ChambreListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetChambresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createChambre(Chambre.CreateChambreRequest request,
                              io.grpc.stub.StreamObserver<Chambre.ChambreResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateChambreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteChambre(Chambre.ChambreRequest request,
                              io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteChambreMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChambreServiceBlockingStub extends io.grpc.stub.AbstractStub<ChambreServiceBlockingStub> {
    private ChambreServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChambreServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChambreServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChambreServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Chambre.ChambreListResponse getChambres(Common.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetChambresMethod(), getCallOptions(), request);
    }

    /**
     */
    public Chambre.ChambreResponse createChambre(Chambre.CreateChambreRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateChambreMethod(), getCallOptions(), request);
    }

    /**
     */
    public Common.DeleteResponse deleteChambre(Chambre.ChambreRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteChambreMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChambreServiceFutureStub extends io.grpc.stub.AbstractStub<ChambreServiceFutureStub> {
    private ChambreServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChambreServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChambreServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChambreServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Chambre.ChambreListResponse> getChambres(
        Common.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetChambresMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Chambre.ChambreResponse> createChambre(
        Chambre.CreateChambreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateChambreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Common.DeleteResponse> deleteChambre(
        Chambre.ChambreRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteChambreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CHAMBRES = 0;
  private static final int METHODID_CREATE_CHAMBRE = 1;
  private static final int METHODID_DELETE_CHAMBRE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChambreServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChambreServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CHAMBRES:
          serviceImpl.getChambres((Common.Empty) request,
              (io.grpc.stub.StreamObserver<Chambre.ChambreListResponse>) responseObserver);
          break;
        case METHODID_CREATE_CHAMBRE:
          serviceImpl.createChambre((Chambre.CreateChambreRequest) request,
              (io.grpc.stub.StreamObserver<Chambre.ChambreResponse>) responseObserver);
          break;
        case METHODID_DELETE_CHAMBRE:
          serviceImpl.deleteChambre((Chambre.ChambreRequest) request,
              (io.grpc.stub.StreamObserver<Common.DeleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChambreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChambreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Chambre.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChambreService");
    }
  }

  private static final class ChambreServiceFileDescriptorSupplier
      extends ChambreServiceBaseDescriptorSupplier {
    ChambreServiceFileDescriptorSupplier() {}
  }

  private static final class ChambreServiceMethodDescriptorSupplier
      extends ChambreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChambreServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChambreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChambreServiceFileDescriptorSupplier())
              .addMethod(getGetChambresMethod())
              .addMethod(getCreateChambreMethod())
              .addMethod(getDeleteChambreMethod())
              .build();
        }
      }
    }
    return result;
  }
}
