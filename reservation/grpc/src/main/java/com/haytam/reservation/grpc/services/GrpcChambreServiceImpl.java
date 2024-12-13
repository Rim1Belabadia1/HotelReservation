package com.haytam.reservation.grpc.services;

import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import com.haytam.reservation.grpc.stubs.Chambre.ChambreListResponse;
import com.haytam.reservation.grpc.stubs.Chambre.ChambreRequest;
import com.haytam.reservation.grpc.stubs.Chambre.ChambreResponse;
import com.haytam.reservation.grpc.stubs.Chambre.CreateChambreRequest;
import com.haytam.reservation.grpc.stubs.ChambreServiceGrpc;
import com.haytam.reservation.grpc.stubs.Common.DeleteResponse;
import com.haytam.reservation.grpc.stubs.Common.Empty;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service("grpcChambreServiceImpl")
public class GrpcChambreServiceImpl extends ChambreServiceGrpc.ChambreServiceImplBase {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public void getChambres(Empty request, StreamObserver<ChambreListResponse> responseObserver) {
        try {
            List<ChambreResponse> chambreResponses = chambreRepository.findAll().stream()
                    .map(this::mapChambreToChambreResponse)
                    .collect(Collectors.toList());

            ChambreListResponse response = ChambreListResponse.newBuilder()
                    .addAllChambres(chambreResponses)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Error fetching chambres: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void createChambre(CreateChambreRequest request, StreamObserver<ChambreResponse> responseObserver) {
        try {

            TypeChambre typeChambre;
            try {
                typeChambre = TypeChambre.valueOf(request.getTypeChambre());
            } catch (IllegalArgumentException e) {
                responseObserver.onError(Status.INVALID_ARGUMENT
                        .withDescription("Invalid typeChambre: " + request.getTypeChambre())
                        .asRuntimeException());
                return;
            }

            Chambre chambre = new Chambre(
                    null,
                    typeChambre,
                    BigDecimal.valueOf(request.getPrix()),
                    request.getDisponible(),
                    request.getNumeroChambre(),
                    request.getDescription(),
                    List.of()
            );


            Chambre savedChambre = chambreRepository.save(chambre);


            ChambreResponse response = mapChambreToChambreResponse(savedChambre);


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {

            responseObserver.onError(Status.INTERNAL
                    .withDescription("Error creating chambre: " + e.getMessage())
                    .asRuntimeException());
        }
    }


    @Override
    public void deleteChambre(ChambreRequest request, StreamObserver<DeleteResponse> responseObserver) {
        try {
            if (chambreRepository.existsById(request.getId())) {
                chambreRepository.deleteById(request.getId());
                DeleteResponse response = DeleteResponse.newBuilder().setSuccess(true).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                responseObserver.onError(Status.NOT_FOUND
                        .withDescription("Chambre with ID " + request.getId() + " not found")
                        .asRuntimeException());
            }
        } catch (Exception e) {
            responseObserver.onError(Status.INTERNAL
                    .withDescription("Error deleting chambre: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    private ChambreResponse mapChambreToChambreResponse(Chambre chambre) {
        return ChambreResponse.newBuilder()
                .setId(chambre.getId())
                .setTypeChambre(chambre.getTypeChambre().toString())
                .setPrix(chambre.getPrix().doubleValue())
                .setDisponible(chambre.getDisponible())
                .setNumeroChambre(chambre.getNumeroChambre())
                .setDescription(chambre.getDescription())
                .build();
    }
}