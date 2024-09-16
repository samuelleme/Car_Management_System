package dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarroDTOInput {
    int id;
    String modelo;
    String placa;
    String chassi;
}
