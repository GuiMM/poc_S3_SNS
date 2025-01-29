package com.fiap.burguer.controller;

import com.amazonaws.services.sns.AmazonSNS;
import com.fiap.burguer.publish.SnsProducer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.identity.spi.AwsCredentialsIdentity;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class pocController {

    @Autowired
    private S3Client s3Client;
    @Autowired
    private AmazonSNS snsClient;

    @Autowired
    private SnsProducer snsProducer;

    private String BUCKET_NAME = "poc-video-bb";

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "poc-video-original")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Feito upload do arquivo com sucesso",
                    content = {@Content(mediaType = "Multipart/form-data",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Erro ao fazer upload do arquivo",
                    content = @Content)})

    public ResponseEntity<List<String>> uploadFile(@RequestPart("file") MultipartFile file) throws IOException {


        Map<String, String> metadata = new HashMap<>();
        metadata.put("company", "Baeldung");
        metadata.put("environment", "development");

        //criarBucket(BUCKET_NAME);



//        s3Client.putObject(request ->
//                        request
//                                .bucket(BUCKET_NAME)
//                                .key(file.getOriginalFilename())
//                                //.metadata(metadata)
//                                .ifNoneMatch("*"),
//                RequestBody.fromBytes(file.getBytes()));

        snsProducer.publishStatusEvent("feito upload do arquivo com sucesso");


        return ResponseEntity.ok(Collections.singletonList("feito upload do arquivo com sucesso"));

    }

    public void criarBucket(final String nomeBucket) {
        try {
            s3Client.createBucket(request -> request.bucket(nomeBucket));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
