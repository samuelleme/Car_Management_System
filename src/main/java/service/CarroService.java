package service;
import dto.CarroDTOInput;
import dto.CarroDTOOutput;
import model.Carro;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;


public class CarroService {
    private List<Carro> listaCarros = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<CarroDTOOutput> listar(){
        return listaCarros.stream()
                .map(carro -> modelMapper.map(carro, CarroDTOOutput.class))
                .toList();
    }

    public void inserir(CarroDTOInput carroDtoInput){
        Carro carro = modelMapper.map(carroDtoInput, Carro.class);
        listaCarros.add(carro);
    }

    public void alterar(CarroDTOInput carroDtoInput) {
        int index = listaCarros.indexOf(carroDtoInput.getId());

        if (index != -1) {
            Carro carro = modelMapper.map(carroDtoInput, Carro.class);
            listaCarros.set(index, carro);
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public CarroDTOOutput buscar(int id){
        for (Carro c : listaCarros){
            if (c.getId() == id) return modelMapper.map(c, CarroDTOOutput.class);
            else System.out.println("Carro não encontrado.");
        }
        return null;
    }

    public void excluir(int id){
        listaCarros.removeIf(carro -> carro.getId() == id);
    }
}
