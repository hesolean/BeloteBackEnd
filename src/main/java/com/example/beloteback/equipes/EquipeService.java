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
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "equipe not found")
        );
    }
    public Equipe save(Equipe equipe){
        return equipeRepository.save(equipe);
    }
    public Equipe updateById(Equipe equipe){
        Equipe equipeActuelle = equipeRepository.findById(equipe.getId()).orElse(null);
        if (equipe.getId() != null){
            equipeActuelle.setNomEquipe(equipe.getNomEquipe());
            equipeActuelle.setPointsPlie(equipe.getPointsPlie());
            equipeActuelle.setTotalPartie(equipe.getTotalPartie());
            equipeActuelle.setArchivesParties(equipe.getArchivesParties());
            return equipeRepository.save(equipe);
        } else {
            throw new RuntimeException("equipe not found");
        }
    }
    public void deleteById(Equipe equipe){
        equipeRepository.deleteById(equipe.getId());
    }
    public void deleteAll(){
        equipeRepository.deleteAll();
    }
}
