package com.haytam.reservation.grpc.services;

import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.repositories.ClientRepository;
import com.haytam.reservation.grpc.stubs.Client.ClientListResponse;
import com.haytam.reservation.grpc.stubs.Client.ClientRequest;
import com.haytam.reservation.grpc.stubs.Client.ClientResponse;
import com.haytam.reservation.grpc.stubs.Client.CreateClientRequest;
import com.haytam.reservation.grpc.stubs.ClientServiceGrpc;
import com.haytam.reservation.grpc.stubs.Common.DeleteResponse;
import com.haytam.reservation.grpc.stubs.Common.Empty;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("grpcClientServiceImpl")
public class GrpcClientServiceImpl extends ClientServiceGrpc.ClientServiceImplBase {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void getClients(Empty request, StreamObserver<ClientListResponse> responseObserver) {
        List<ClientResponse> clientResponses = clientRepository.findAll().stream()
                .map(client -> ClientResponse.newBuilder()
                        .setId(client.getId())
                        .setNom(client.getNom())
                        .setPrenom(client.getPrenom())
                        .setEmail(client.getEmail())
                        .setNumTelephone(client.getNumTelephone())
                        .build())
                .collect(Collectors.toList());

        ClientListResponse response = ClientListResponse.newBuilder()
                .addAllChambres(clientResponses)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createClient(CreateClientRequest request, StreamObserver<ClientResponse> responseObserver) {
        Client client = new Client(null, request.getNom(), null, request.getEmail(), null, null);
        Client savedClient = clientRepository.save(client);
        ClientResponse response = ClientResponse.newBuilder()
                .setId(savedClient.getId())
                .setNom(savedClient.getNom())
                .setPrenom(savedClient.getPrenom())
                .setEmail(savedClient.getEmail())
                .setNumTelephone(savedClient.getNumTelephone())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deleteClient(ClientRequest request, StreamObserver<DeleteResponse> responseObserver) {
        if (clientRepository.existsById(request.getId())) {
            clientRepository.deleteById(request.getId());
            DeleteResponse response = DeleteResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            responseObserver.onNext(response);
        } else {
            DeleteResponse response = DeleteResponse.newBuilder()
                    .setSuccess(false)
                    .build();
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }
}
