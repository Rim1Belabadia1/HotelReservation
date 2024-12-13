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
    comments = "Source: reservation.proto")
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final String SERVICE_NAME = "ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Common.Empty,
          Reservation.ReservationListResponse> getGetReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservations",
      requestType = Common.Empty.class,
      responseType = Reservation.ReservationListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Common.Empty,
          Reservation.ReservationListResponse> getGetReservationsMethod() {
    io.grpc.MethodDescriptor<Common.Empty, Reservation.ReservationListResponse> getGetReservationsMethod;
    if ((getGetReservationsMethod = ReservationServiceGrpc.getGetReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationsMethod = ReservationServiceGrpc.getGetReservationsMethod) == null) {
          ReservationServiceGrpc.getGetReservationsMethod = getGetReservationsMethod = 
              io.grpc.MethodDescriptor.<Common.Empty, Reservation.ReservationListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.ReservationListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservations"))
                  .build();
          }
        }
     }
     return getGetReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Reservation.ReservationRequest,
          Reservation.ReservationResponse> getGetReservationByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservationById",
      requestType = Reservation.ReservationRequest.class,
      responseType = Reservation.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Reservation.ReservationRequest,
          Reservation.ReservationResponse> getGetReservationByIdMethod() {
    io.grpc.MethodDescriptor<Reservation.ReservationRequest, Reservation.ReservationResponse> getGetReservationByIdMethod;
    if ((getGetReservationByIdMethod = ReservationServiceGrpc.getGetReservationByIdMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationByIdMethod = ReservationServiceGrpc.getGetReservationByIdMethod) == null) {
          ReservationServiceGrpc.getGetReservationByIdMethod = getGetReservationByIdMethod = 
              io.grpc.MethodDescriptor.<Reservation.ReservationRequest, Reservation.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "GetReservationById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservationById"))
                  .build();
          }
        }
     }
     return getGetReservationByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Reservation.CreateReservationRequest,
          Reservation.ReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = Reservation.CreateReservationRequest.class,
      responseType = Reservation.ReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Reservation.CreateReservationRequest,
          Reservation.ReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<Reservation.CreateReservationRequest, Reservation.ReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod = 
              io.grpc.MethodDescriptor.<Reservation.CreateReservationRequest, Reservation.ReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.ReservationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
                  .build();
          }
        }
     }
     return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Reservation.ReservationRequest,
      Common.DeleteResponse> getDeleteReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReservation",
      requestType = Reservation.ReservationRequest.class,
      responseType = Common.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Reservation.ReservationRequest,
      Common.DeleteResponse> getDeleteReservationMethod() {
    io.grpc.MethodDescriptor<Reservation.ReservationRequest, Common.DeleteResponse> getDeleteReservationMethod;
    if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getDeleteReservationMethod = ReservationServiceGrpc.getDeleteReservationMethod) == null) {
          ReservationServiceGrpc.getDeleteReservationMethod = getDeleteReservationMethod = 
              io.grpc.MethodDescriptor.<Reservation.ReservationRequest, Common.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ReservationService", "DeleteReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reservation.ReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.DeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("DeleteReservation"))
                  .build();
          }
        }
     }
     return getDeleteReservationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    return new ReservationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReservationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReservationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ReservationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getReservations(Common.Empty request,
                                io.grpc.stub.StreamObserver<Reservation.ReservationListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationsMethod(), responseObserver);
    }

    /**
     */
    public void getReservationById(Reservation.ReservationRequest request,
                                   io.grpc.stub.StreamObserver<Reservation.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetReservationByIdMethod(), responseObserver);
    }

    /**
     */
    public void createReservation(Reservation.CreateReservationRequest request,
                                  io.grpc.stub.StreamObserver<Reservation.ReservationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reference DeleteResponse
     * </pre>
     */
    public void deleteReservation(Reservation.ReservationRequest request,
                                  io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteReservationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetReservationsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Common.Empty,
                      Reservation.ReservationListResponse>(
                  this, METHODID_GET_RESERVATIONS)))
          .addMethod(
            getGetReservationByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Reservation.ReservationRequest,
                      Reservation.ReservationResponse>(
                  this, METHODID_GET_RESERVATION_BY_ID)))
          .addMethod(
            getCreateReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Reservation.CreateReservationRequest,
                      Reservation.ReservationResponse>(
                  this, METHODID_CREATE_RESERVATION)))
          .addMethod(
            getDeleteReservationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Reservation.ReservationRequest,
                Common.DeleteResponse>(
                  this, METHODID_DELETE_RESERVATION)))
          .build();
    }
  }

  /**
   */
  public static final class ReservationServiceStub extends io.grpc.stub.AbstractStub<ReservationServiceStub> {
    private ReservationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     */
    public void getReservations(Common.Empty request,
                                io.grpc.stub.StreamObserver<Reservation.ReservationListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservationById(Reservation.ReservationRequest request,
                                   io.grpc.stub.StreamObserver<Reservation.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createReservation(Reservation.CreateReservationRequest request,
                                  io.grpc.stub.StreamObserver<Reservation.ReservationResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reference DeleteResponse
     * </pre>
     */
    public void deleteReservation(Reservation.ReservationRequest request,
                                  io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ReservationServiceBlockingStub extends io.grpc.stub.AbstractStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Reservation.ReservationListResponse getReservations(Common.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Reservation.ReservationResponse getReservationById(Reservation.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetReservationByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public Reservation.ReservationResponse createReservation(Reservation.CreateReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reference DeleteResponse
     * </pre>
     */
    public Common.DeleteResponse deleteReservation(Reservation.ReservationRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteReservationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ReservationServiceFutureStub extends io.grpc.stub.AbstractStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReservationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Reservation.ReservationListResponse> getReservations(
        Common.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Reservation.ReservationResponse> getReservationById(
        Reservation.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetReservationByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Reservation.ReservationResponse> createReservation(
        Reservation.CreateReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reference DeleteResponse
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Common.DeleteResponse> deleteReservation(
        Reservation.ReservationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteReservationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_RESERVATIONS = 0;
  private static final int METHODID_GET_RESERVATION_BY_ID = 1;
  private static final int METHODID_CREATE_RESERVATION = 2;
  private static final int METHODID_DELETE_RESERVATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReservationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReservationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_RESERVATIONS:
          serviceImpl.getReservations((Common.Empty) request,
              (io.grpc.stub.StreamObserver<Reservation.ReservationListResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION_BY_ID:
          serviceImpl.getReservationById((Reservation.ReservationRequest) request,
              (io.grpc.stub.StreamObserver<Reservation.ReservationResponse>) responseObserver);
          break;
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((Reservation.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<Reservation.ReservationResponse>) responseObserver);
          break;
        case METHODID_DELETE_RESERVATION:
          serviceImpl.deleteReservation((Reservation.ReservationRequest) request,
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

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Reservation.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReservationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getGetReservationsMethod())
              .addMethod(getGetReservationByIdMethod())
              .addMethod(getCreateReservationMethod())
              .addMethod(getDeleteReservationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
