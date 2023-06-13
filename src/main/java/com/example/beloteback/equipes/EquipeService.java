package com.example.beloteback.equipes;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EquipeService {
    private final EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository){
        this.equipeRepository = equipeRepository;
    }

    public List<Equipe> findAll(){
        return equipeRepository.findAll();
    }

    public Equipe findById(Long id){
        return equipeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "partie not found")
        );
    }
    public Equipe save(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public Equipe updateById(Equipe equipe){
        Equipe equipeActuelle = equipeRepository.findById(equipe.getId()).orElse(null);
        if (equipe.getId() != null){
            equipeActuelle.setDate(equipe.getDate());
            equipeActuelle.setEquipe1(equipe.getEquipe1());
            equipeActuelle.setEquipe2(equipe.getEquipe2());
            equipeActuelle.setPointsEquipe1(equipe.getPointsEquipe1());
            equipeActuelle.setPointsEquipe2(equipe.getPointsEquipe2());
            return equipeRepository.save(equipe);
        } else {
            throw new RuntimeException("partie not found");
        }
    }
    public void deleteById(Equipe equipe){
        equipeRepository.deleteById(equipe.getId());
    }
    public void deleteAll(){
        equipeRepository.deleteAll();
    }
}
