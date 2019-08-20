import com.xsk.cart.CartApplication;
import com.xsk.cart.mapper.AuthorMapper;
import com.xsk.cart.model.Author;
import com.xsk.cart.service.serviceimp.AuthorService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class AuthorTest {
    @Autowired
    AuthorService authorService;

    @Before
    public void initData() {
        for (int i = 0; i < 10; i++) {
            Author author = new Author();
            author.setBio("bio"+i);
            author.setEmail("emai"+i);
            author.setPassword("password"+i);
            author.setUserName("username"+i);
            authorService.insertAuthor(author);
        }
    }
    @Test
    public void testInsertAuthor() {
        Author author = new Author();
        author.setId(1);
        author.setBio("bio");
        author.setEmail("emai");
        author.setPassword("password");
        author.setUserName("username");

        int result = authorService.insertAuthor(author);

        TestCase.assertEquals(1, result);
    }

    @Test
  public   void testUpdateAuthor() {
        Author author = new Author();
        author.setBio("bio");
        author.setEmail("emai");
        author.setPassword("password");
        author.setUserName("username");

        int result = authorService.insertAuthor(author);
        author.setId(result);
        author.setUserName(author.getUserName() + result);

        int next = authorService.updateAuthor(author);
        TestCase.assertEquals(1, next);
    }

    @Test
    public void testFindAll() {
        List<Author> authorList = authorService.findAll();
        TestCase.assertFalse("获取错误"+authorList,authorList.size()==0);

        Author author = authorService.findSomeAuthor(2);
        TestCase.assertFalse(author == null);
    }
}
