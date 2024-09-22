package pe.edu.upc.medlearn.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.medlearn.dtos.DietsDTO;
import pe.edu.upc.medlearn.entities.Diet;
import pe.edu.upc.medlearn.servicesinterfaces.IDietsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Diets")
public class DietsController {
    @Autowired
    private IDietsService dS;

    @GetMapping
    public List<DietsDTO>list(){
        return dS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return  m.map(x,DietsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DietsDTO dto){
        ModelMapper m=new ModelMapper();
        Diet ci=m.map(dto, Diet.class);
        dS.insert(ci);
    }
    @PutMapping("/{id}")
    public DietsDTO listId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        DietsDTO dto=m.map(dS.listId(id),DietsDTO.class);
        return dto;
    }
    @PutMapping
    public void modify(@RequestBody DietsDTO dto){
        ModelMapper m=new ModelMapper();
        Diet ci=m.map(dto, Diet.class);
        dS.update(ci);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        dS.delete(id);
    }



}