package fang.service;

import fang.entity.Daily;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DailyService extends CrudRepository<Daily, Long> , PagingAndSortingRepository<Daily,Long> {
}
