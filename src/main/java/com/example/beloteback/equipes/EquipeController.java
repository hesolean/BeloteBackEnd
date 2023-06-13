package com.example.beloteback.equipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parties")
public class EquipeController {
    private EquipeService equipeService;
    public EquipeController(EquipeService equipeService){
        this.equipeService = equipeService;
    }

    @GetMapping("")
    public List<Equipe> findAll(){
        return equipeService.findAll();
    }

    @GetMapping("/{id}")
    public Equipe findById(@PathVariable Long id){
        return equipeService.findById(id);
    }

    @PostMapping("")
    public Equipe save(@RequestBody Equipe equipe){
        return equipeService.save(equipe);
    }

    @PutMapping("/{id}")
    public Equipe updateById(@RequestBody Equipe equipe){
        return equipeService.updateById(equipe);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Equipe equipe){
        equipeService.deleteById(equipe);
    }

    @DeleteMapping("")
    public void deleteAll(){
        equipeService.deleteAll();
    }
}
