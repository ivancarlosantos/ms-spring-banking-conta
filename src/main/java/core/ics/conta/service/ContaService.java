package core.ics.conta.service;

import core.ics.conta.exception.RegraDeNegocioException;
import core.ics.conta.model.Conta;
import core.ics.conta.repository.ContaRepository;
import core.ics.conta.utils.ValidateParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private AgenciaService agenciaService;

    public Conta save(){

        Conta conta = new Conta();
        Integer[] digito = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random r = new Random();

        int random_digito = r.nextInt(10);

        conta.setConta("00" + agenciaService.gerarAgencia().getAgencia());
        conta.setDataCriacao(new Date().toString());
        conta.setDataAtualizacao(new Date().toString());
        conta.setAgencia(agenciaService.gerarAgencia().getAgencia());
        conta.setConta(agenciaService.gerarAgencia().getAgencia() + conta.getConta() + "-" + digito[random_digito]);

        return contaRepository.save(conta);
    }

    public Conta findContaByID(String value){
        Long id = ValidateParameter.validate(value);
        return contaRepository
                .findById(id).orElseThrow(() -> new RegraDeNegocioException("Conta "+ HttpStatus.NOT_FOUND));
    }


    public List<Conta> list(){
        return new ArrayList<>(contaRepository.findAll());
    }

    public String delete(String value){
        Long id = ValidateParameter.validate(value);
        contaRepository.deleteById(id);
        return "Conta DELETADA";
    }
}
