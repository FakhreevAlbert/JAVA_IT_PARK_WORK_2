package ru.itpark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Manager;
import ru.itpark.repository.ManagerRepository;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    @Override
    public List<Manager> findAll(){
        return managerRepository.findAll();
    }

    @Override
    public Manager findById(int id){
        return managerRepository.findById(id);
    }
    @Override
    public List<Manager> findByName(String name){
        return managerRepository.findByNameContainingIgnoreCase(name);
    }
}
