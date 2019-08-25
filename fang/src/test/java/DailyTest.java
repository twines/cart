import fang.FangApplication;
import fang.entity.Daily;
import fang.entity.Month;
import fang.entity.Treat;
import fang.service.DailyService;
import fang.service.MonthService;
import fang.service.TreatService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testFindByTreatId() {
        Daily treat = dailyService.findByIdAndTreats_IdAfter(2L,2L);
        TestCase.assertNotNull("findByIdAndTreats_Id",treat);
        List<Daily> dailies = dailyService.findByDateLikeAndTreats_RegionEquals("2019-08%","青山区");
        TestCase.assertTrue("查询年代结合区域失败", dailies.size() > 0);
        TestCase.assertFalse(treat.getTreats().size() == 0);
        dailyService.findByIdGreaterThanAndDateEquals(2L, "2019-08-10");
        List<Daily> ins = dailyService.findByIdIn(Arrays.asList(10L, 20L));
        TestCase.assertEquals(2, ins.size());
    }

    @Autowired
    TreatService treatService;
    @Test
    public void testTreat() {
        Treat treat = treatService.findById(1L).get();
        System.out.println(treat);

         List<Treat> treats = treatService.findByDaily_IdEquals(2L);
        System.out.println(treats);
        for (Treat t : treats) {
            Set<Treat> tt = t.getDaily().getTreats();
            System.out.println(tt);
        }
    }

    @Autowired
    MonthService monthService;

    @Test
    public void testMonth() {
        Month month = monthService.findFirstByOrderByDateDesc();
        System.out.println(month);

    }
}
