import fang.FangApplication;
import fang.entity.Daily;
import fang.service.DailyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = FangApplication.class)
@RunWith(SpringRunner.class)
public class DailyTest {
    @Autowired
    DailyService dailyService;

    public Page<Daily> getSourceCode(int pageNumber, int pageSize) {
        PageRequest request = this.buildPageRequest(pageNumber, pageSize);
        Page<Daily> sourceCodes = this.dailyService.findAll(request);

        return sourceCodes;
    }

    private PageRequest buildPageRequest(int pageNumber, int pagzSize) {
        return new PageRequest(pageNumber - 1, pagzSize, null);
    }

    @Test
    public void testDaily() {
        PageRequest pageRequest = new PageRequest(1, 20);
        Page<Daily> page = dailyService.findAll(pageRequest);
        while (page.hasNext()) {
            List content = page.getContent();
            System.out.println(content);
            Pageable pageable = page.nextPageable();
           page = dailyService.findAll(pageable);

        }

        System.out.println(page.getTotalPages());
    }
}
