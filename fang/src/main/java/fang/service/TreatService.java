package fang.service;

import fang.entity.Daily;
import fang.entity.Treat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatService extends JpaRepository<Treat, Long> {
    List<Treat> findByDaily_IdEquals(Long dailyId);
}
