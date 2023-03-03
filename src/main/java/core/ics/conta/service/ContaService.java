package core.ics.conta.service;

import core.ics.conta.exception.RegraDeNegocioException;
import core.ics.conta.model.Conta;
import core.ics.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public Conta findContaByID(Long id){
        return contaRepository
                .findById(id).orElseThrow(() -> new RegraDeNegocioException("Conta "+ HttpStatus.NOT_FOUND));
    }

    public List<Conta> list(){
        return contaRepository
                .findAll()
                .stream()
                .collect(Collectors.toList());
    }

    public String delete(Long id){
        contaRepository.deleteById(id);
        return "Conta DELETADA";
    }

}
