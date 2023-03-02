package com.example.grupptransportcars.repository;

import com.example.grupptransportcars.modell.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Cars, Long> {
}
