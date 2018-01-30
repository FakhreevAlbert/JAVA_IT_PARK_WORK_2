package ru.itpark.repository;

import ru.itpark.domain.Manager;

import java.util.List;

public interface ManagerRepository {
    List<Manager> findAll();

    Manager findById(int id);

    List<Manager> findByNameContainingIgnoreCase(String name);
}
