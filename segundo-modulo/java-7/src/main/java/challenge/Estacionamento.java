package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
        Motorista motorista = carro.getMotorista();

        if(motorista == null)
            throw new EstacionamentoException("Não é permitido carro autônomo. Informe um motorista.");
        if(motorista.getIdade() < 18)
            throw new EstacionamentoException("Não é permitido motorista menor de idade.");
        if(motorista.getPontos() > 20)
            throw new EstacionamentoException("O motorista está com a carteira suspensa.");

        if (carrosEstacionados() < 10) {
            carrosEstacionados.add(carro);
        }else{
            Boolean consegueEstacionar = false;
            for (int i = 0; i < 10; i++) {
                if(carrosEstacionados.get(i).getMotorista().getIdade() < 55) {
                    carrosEstacionados.set(i, carro);
                    consegueEstacionar = true;
                    break;
                }
            }
            if(!consegueEstacionar)
                throw new EstacionamentoException("Não foi possível estacionar.");
        }

    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }
}
