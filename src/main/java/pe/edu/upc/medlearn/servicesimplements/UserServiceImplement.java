package pe.edu.upc.medlearn.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.medlearn.entities.User;
import pe.edu.upc.medlearn.repositories.IUserRepository;
import pe.edu.upc.medlearn.servicesinterfaces.IUserService;

import java.util.List;

@Service
public class
UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;

    @Override
    public List<User> list() {
        return uR.findAll();
    }
    @Override
    public void insert(User user) {
        uR.save(user);
    }

    @Override
    public User listId(int id) {
        return uR.findById(id).orElse(new User());
    }


}
