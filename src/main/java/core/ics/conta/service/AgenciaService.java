package core.ics.conta.service;

import core.ics.conta.model.Agencia;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class AgenciaService {

    public Agencia gerarAgencia() {

        Integer[] agencias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Agencia agencia = new Agencia();

        Random r = new SecureRandom();

        int dOne = r.nextInt(10);
        int dTwo = r.nextInt(10);
        int dThree = r.nextInt(10);

        agencia.setAgencia(agencias[dOne].toString()+agencias[dTwo].toString()+agencias[dThree].toString());

        return agencia;
    }

}
