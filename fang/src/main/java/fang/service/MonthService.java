package fang.service;

import fang.entity.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MonthService extends CrudRepository<Month, Long> {
    Month findFirstByOrderByDateDesc();
}
