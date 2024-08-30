package pe.edu.upc.medlearn.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medlearn.dtos.IllnessDTO;
import pe.edu.upc.medlearn.entities.Illness;
import pe.edu.upc.medlearn.servicesinterfaces.IIllnessService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Enfermedades")
public class IllnessController {
    @Autowired
    private IIllnessService iS;

    @GetMapping("/listar")
    public List<IllnessDTO> list(){
        return iS.list().stream().map(y-> {
            ModelMapper m = new ModelMapper();
            return m.map(y,IllnessDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/crear")
    public void guardar(@RequestBody IllnessDTO illnessDTO){
        ModelMapper  m = new ModelMapper();
        Illness i=m.map(illnessDTO, Illness.class);
        iS.create(i);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
    iS.delete(id);
    }

    @GetMapping("/{id}")
    public IllnessDTO listarporId(@PathVariable("id") Integer id){
        ModelMapper modelMapper=new ModelMapper();
        IllnessDTO illnessDTO=modelMapper.map(iS.listId(id),IllnessDTO.class);
        return illnessDTO;
    }

    @PutMapping
    public void editar(@RequestBody IllnessDTO illnessDTO){
        ModelMapper m=new ModelMapper();
        Illness illness=m.map(illnessDTO,Illness.class);
        iS.create(illness);
    }
}
