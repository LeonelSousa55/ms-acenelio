package br.com.leonel.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonel.hrworker.entities.Worker;
import br.com.leonel.hrworker.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private Environment env;

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private WorkerRepository repository;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("CONFIG = {}", testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> fingAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> fingById(@PathVariable Long id) {

        // try {
        //     Thread.sleep(3000L);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        log.info("Port of Worker = {}", env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
