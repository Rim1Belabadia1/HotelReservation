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
    comments = "Source: client.proto")
public final class ClientServiceGrpc {

  private ClientServiceGrpc() {}

  public static final String SERVICE_NAME = "ClientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Common.Empty,
      Client.ClientListResponse> getGetClientsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClients",
      requestType = Common.Empty.class,
      responseType = Client.ClientListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Common.Empty,
      Client.ClientListResponse> getGetClientsMethod() {
    io.grpc.MethodDescriptor<Common.Empty, Client.ClientListResponse> getGetClientsMethod;
    if ((getGetClientsMethod = ClientServiceGrpc.getGetClientsMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getGetClientsMethod = ClientServiceGrpc.getGetClientsMethod) == null) {
          ClientServiceGrpc.getGetClientsMethod = getGetClientsMethod = 
              io.grpc.MethodDescriptor.<Common.Empty, Client.ClientListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "GetClients"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.ClientListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("GetClients"))
                  .build();
          }
        }
     }
     return getGetClientsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Client.ClientRequest,
      Client.ClientResponse> getGetClientByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClientById",
      requestType = Client.ClientRequest.class,
      responseType = Client.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Client.ClientRequest,
      Client.ClientResponse> getGetClientByIdMethod() {
    io.grpc.MethodDescriptor<Client.ClientRequest, Client.ClientResponse> getGetClientByIdMethod;
    if ((getGetClientByIdMethod = ClientServiceGrpc.getGetClientByIdMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getGetClientByIdMethod = ClientServiceGrpc.getGetClientByIdMethod) == null) {
          ClientServiceGrpc.getGetClientByIdMethod = getGetClientByIdMethod = 
              io.grpc.MethodDescriptor.<Client.ClientRequest, Client.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "GetClientById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("GetClientById"))
                  .build();
          }
        }
     }
     return getGetClientByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Client.CreateClientRequest,
      Client.ClientResponse> getCreateClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateClient",
      requestType = Client.CreateClientRequest.class,
      responseType = Client.ClientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Client.CreateClientRequest,
      Client.ClientResponse> getCreateClientMethod() {
    io.grpc.MethodDescriptor<Client.CreateClientRequest, Client.ClientResponse> getCreateClientMethod;
    if ((getCreateClientMethod = ClientServiceGrpc.getCreateClientMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getCreateClientMethod = ClientServiceGrpc.getCreateClientMethod) == null) {
          ClientServiceGrpc.getCreateClientMethod = getCreateClientMethod = 
              io.grpc.MethodDescriptor.<Client.CreateClientRequest, Client.ClientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "CreateClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.CreateClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.ClientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("CreateClient"))
                  .build();
          }
        }
     }
     return getCreateClientMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Client.ClientRequest,
      Common.DeleteResponse> getDeleteClientMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteClient",
      requestType = Client.ClientRequest.class,
      responseType = Common.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Client.ClientRequest,
      Common.DeleteResponse> getDeleteClientMethod() {
    io.grpc.MethodDescriptor<Client.ClientRequest, Common.DeleteResponse> getDeleteClientMethod;
    if ((getDeleteClientMethod = ClientServiceGrpc.getDeleteClientMethod) == null) {
      synchronized (ClientServiceGrpc.class) {
        if ((getDeleteClientMethod = ClientServiceGrpc.getDeleteClientMethod) == null) {
          ClientServiceGrpc.getDeleteClientMethod = getDeleteClientMethod = 
              io.grpc.MethodDescriptor.<Client.ClientRequest, Common.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ClientService", "DeleteClient"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Client.ClientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Common.DeleteResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ClientServiceMethodDescriptorSupplier("DeleteClient"))
                  .build();
          }
        }
     }
     return getDeleteClientMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientServiceStub newStub(io.grpc.Channel channel) {
    return new ClientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClientServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getClients(Common.Empty request,
                           io.grpc.stub.StreamObserver<Client.ClientListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClientsMethod(), responseObserver);
    }

    /**
     */
    public void getClientById(Client.ClientRequest request,
                              io.grpc.stub.StreamObserver<Client.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetClientByIdMethod(), responseObserver);
    }

    /**
     */
    public void createClient(Client.CreateClientRequest request,
                             io.grpc.stub.StreamObserver<Client.ClientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateClientMethod(), responseObserver);
    }

    /**
     */
    public void deleteClient(Client.ClientRequest request,
                             io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteClientMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetClientsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Common.Empty,
                Client.ClientListResponse>(
                  this, METHODID_GET_CLIENTS)))
          .addMethod(
            getGetClientByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Client.ClientRequest,
                Client.ClientResponse>(
                  this, METHODID_GET_CLIENT_BY_ID)))
          .addMethod(
            getCreateClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Client.CreateClientRequest,
                Client.ClientResponse>(
                  this, METHODID_CREATE_CLIENT)))
          .addMethod(
            getDeleteClientMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Client.ClientRequest,
                Common.DeleteResponse>(
                  this, METHODID_DELETE_CLIENT)))
          .build();
    }
  }

  /**
   */
  public static final class ClientServiceStub extends io.grpc.stub.AbstractStub<ClientServiceStub> {
    private ClientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceStub(channel, callOptions);
    }

    /**
     */
    public void getClients(Common.Empty request,
                           io.grpc.stub.StreamObserver<Client.ClientListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClientsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getClientById(Client.ClientRequest request,
                              io.grpc.stub.StreamObserver<Client.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetClientByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createClient(Client.CreateClientRequest request,
                             io.grpc.stub.StreamObserver<Client.ClientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteClient(Client.ClientRequest request,
                             io.grpc.stub.StreamObserver<Common.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteClientMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ClientServiceBlockingStub extends io.grpc.stub.AbstractStub<ClientServiceBlockingStub> {
    private ClientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Client.ClientListResponse getClients(Common.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetClientsMethod(), getCallOptions(), request);
    }

    /**
     */
    public Client.ClientResponse getClientById(Client.ClientRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetClientByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public Client.ClientResponse createClient(Client.CreateClientRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateClientMethod(), getCallOptions(), request);
    }

    /**
     */
    public Common.DeleteResponse deleteClient(Client.ClientRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteClientMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ClientServiceFutureStub extends io.grpc.stub.AbstractStub<ClientServiceFutureStub> {
    private ClientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClientServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Client.ClientListResponse> getClients(
        Common.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClientsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Client.ClientResponse> getClientById(
        Client.ClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetClientByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Client.ClientResponse> createClient(
        Client.CreateClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateClientMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Common.DeleteResponse> deleteClient(
        Client.ClientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteClientMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CLIENTS = 0;
  private static final int METHODID_GET_CLIENT_BY_ID = 1;
  private static final int METHODID_CREATE_CLIENT = 2;
  private static final int METHODID_DELETE_CLIENT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CLIENTS:
          serviceImpl.getClients((Common.Empty) request,
              (io.grpc.stub.StreamObserver<Client.ClientListResponse>) responseObserver);
          break;
        case METHODID_GET_CLIENT_BY_ID:
          serviceImpl.getClientById((Client.ClientRequest) request,
              (io.grpc.stub.StreamObserver<Client.ClientResponse>) responseObserver);
          break;
        case METHODID_CREATE_CLIENT:
          serviceImpl.createClient((Client.CreateClientRequest) request,
              (io.grpc.stub.StreamObserver<Client.ClientResponse>) responseObserver);
          break;
        case METHODID_DELETE_CLIENT:
          serviceImpl.deleteClient((Client.ClientRequest) request,
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

  private static abstract class ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Client.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientService");
    }
  }

  private static final class ClientServiceFileDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier {
    ClientServiceFileDescriptorSupplier() {}
  }

  private static final class ClientServiceMethodDescriptorSupplier
      extends ClientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientServiceFileDescriptorSupplier())
              .addMethod(getGetClientsMethod())
              .addMethod(getGetClientByIdMethod())
              .addMethod(getCreateClientMethod())
              .addMethod(getDeleteClientMethod())
              .build();
        }
      }
    }
    return result;
  }
}
