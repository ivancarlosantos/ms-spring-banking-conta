package core.ics.conta.controller;

import core.ics.conta.model.Conta;
import core.ics.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping(path = "/conta/save")
    public ResponseEntity<Conta> save(){
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save());
    }

    @GetMapping(path = "/conta/list")
    public ResponseEntity<List<Conta>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.list());
    }

    @GetMapping(path = "/conta/{id}")
    public ResponseEntity<Conta> findConta(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findContaByID(id));
    }

    @DeleteMapping(path = "/conta/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(contaService.delete(id));
    }
}
