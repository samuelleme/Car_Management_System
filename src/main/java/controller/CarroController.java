package controller;

import static spark.Spark.port;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CarroDTOOutput;
import service.CarroService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CarroController {
    private CarroService carroService = new CarroService();
    private ObjectMapper objMapper = new ObjectMapper();

    public void respostasRequisicoes() {
        port(4567);

        get("/carros", (request, response) -> {
            response.type("application/json");
            String json = objMapper.writeValueAsString(carroService.listar());
            response.status(200);
            return json;
        });

        get("/carros/:id", (request, response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            int id = Integer.parseInt(idParam);
            String json = objMapper.writeValueAsString(carroService.buscar(id));
            response.status(200);
            return json;
        });

        delete("/carros/:id", (request, response) -> {
            response.type("application/json");
            String idParam = request.params("id");
            int id = Integer.parseInt(idParam);
            carroService.excluir(id);
            response.status(200);
            return "Produto excluído com sucesso.";
        });


    }
}
