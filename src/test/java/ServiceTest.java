import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.CarroDTOInput;
import dto.CarroDTOOutput;
import org.junit.Test;
import service.CarroService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static spark.Spark.port;


public class ServiceTest {
    CarroService carroService = new CarroService();

    @Test
    public void testarInserir(){
        CarroDTOInput carroDTOInput = new CarroDTOInput();
        carroService.inserir(carroDTOInput);
        assertEquals(1, carroService.listar().size());
    }

    @Test
    public void testarExcluir(){
        CarroDTOInput carroDTOInput = new CarroDTOInput();
        carroDTOInput.setId(1);
        carroService.inserir(carroDTOInput);
        carroService.excluir(1);
        assertEquals(0, carroService.listar().size());
    }

    @Test
    public void testarListagemCarros() throws IOException {
        URL urlObj = new URL("http://127.0.0.1:4567/carros");
        HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        assertEquals(200,responseCode);
    }


    @Test
    public void testarInsercaoCarro() throws IOException {
        URL urlObj = new URL("http://127.0.0.1:4567/carros/id");
        HttpURLConnection conexao = (HttpURLConnection) urlObj.openConnection();
        conexao.setRequestMethod("GET");
        int responseCode = conexao.getResponseCode();
        assertEquals(200,responseCode);
    }
}
