package ru.itpark.service;

import ru.itpark.domain.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> findAll();

    Manager findById(int id);

    List<Manager> findByName(String name);
}
