import controller.CarroController;
import model.Carro;

import static spark.Spark.port;

public class Main {
    public static void main(String[] args) {
        CarroController controller = new CarroController();
        Carro carro = new Carro();
        controller.respostasRequisicoes();
    }
}