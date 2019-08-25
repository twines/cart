package fang.service;

import fang.entity.Daily;
import fang.entity.Treat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.security.auth.login.LoginContext;
import java.util.List;

public interface DailyService extends CrudRepository<Daily, Long>, PagingAndSortingRepository<Daily, Long> {
    List<Daily> findByDateLikeAndTreats_RegionEquals(String date, String region);
    Daily findByIdAndTreats_IdAfter(Long dId, Long tId);

    Daily findByIdGreaterThanAndDateEquals(Long id, String date);

    List<Daily> findByIdIn(List<Long> ids);
}
