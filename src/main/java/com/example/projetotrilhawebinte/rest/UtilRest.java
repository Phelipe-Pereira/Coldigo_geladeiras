package com.example.projetotrilhawebinte.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UtilRest {
    private final Gson gson;

    public UtilRest() {
        this.gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    }

    public Response buildResponse(Object result) {
        try {
            System.out.println("Convertendo objeto para JSON...");
            String valorResposta = gson.toJson(result);
            System.out.println("JSON gerado: " + valorResposta);
            
            return Response.ok(valorResposta)
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .build();
        } catch (Exception e) {
            System.out.println("Erro ao gerar JSON: " + e.getMessage());
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    public Response buildErrorResponse(String errorMessage) {
        System.out.println("Gerando resposta de erro: " + errorMessage);
        ResponseBuilder responseBuilder = Response.status(Response.Status.INTERNAL_SERVER_ERROR);

        String jsonError = gson.toJson(new ErrorResponse(errorMessage));
        
        responseBuilder = responseBuilder.entity(jsonError);
        responseBuilder = responseBuilder.type(MediaType.APPLICATION_JSON);

        return responseBuilder.build();
    }

    private class ErrorResponse {
        private final String error;

        public ErrorResponse(String message) {
            this.error = message;
        }
    }
}
