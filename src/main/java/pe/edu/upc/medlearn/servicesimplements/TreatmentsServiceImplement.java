package pe.edu.upc.medlearn.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medlearn.entities.Treatment;
import pe.edu.upc.medlearn.repositories.ITreatmentsRepository;
import pe.edu.upc.medlearn.servicesinterfaces.ITreatmentsService;

import java.util.List;

@Service
public class TreatmentsServiceImplement implements ITreatmentsService {

    @Autowired
    private ITreatmentsRepository tR;

    @Override
    public List<Treatment> list() {
        return tR.findAll();
    }

    @Override
    public void insert(Treatment treatment) {
        tR.save(treatment);
    }

    @Override
    public Treatment listId(int id) {
        return tR.findById(id).orElse(new Treatment());
    }

    @Override
    public void update(Treatment treatment) {
        tR.save(treatment);
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }
}
