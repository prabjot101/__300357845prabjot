package com.example.__300357845prabjot.repositories;

import com.example.__300357845prabjot.entity.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface salesmanRepositories extends JpaRepository<Salesman,Long> {

    List<Salesman> findSalesmanById (long kw);
}
