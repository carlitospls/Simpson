package es.daw.simpson.service;

import es.daw.simpson.model.Personaje;
import es.daw.simpson.repository.PersonajeRepository;

import java.util.List;

// El servicio sí se conecta al repositorio!!!
public class PersonajeService {
    // En spring no usaremos new. Inyectaremos el respository con @Autowired
    private final PersonajeRepository personajeRepository = new PersonajeRepository();

    public List<Personaje> buscar() {
        return personajeRepository.findAll();
    }
}
