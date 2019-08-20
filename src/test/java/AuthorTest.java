import com.xsk.cart.CartApplication;
import com.xsk.cart.mapper.AuthorMapper;
import com.xsk.cart.model.Author;
import junit.framework.TestCase;
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
    AuthorMapper authorMapper;

    @Test
    public void testInsertAuthor() {
        Author author = new Author();
        author.setId(1);
        author.setBio("bio");
        author.setEmail("emai");
        author.setPassword("password");
        author.setUserName("username");

        int result = authorMapper.insertAuthor(author);

        TestCase.assertEquals(1, result);
    }

    @Test
  public   void testUpdateAuthor() {
        Author author = new Author();
        author.setBio("bio");
        author.setEmail("emai");
        author.setPassword("password");
        author.setUserName("username");

        int result = authorMapper.insertAuthor(author);
        author.setId(result);
        author.setUserName(author.getUserName() + result);

        int next = authorMapper.updateAuthor(author);
        TestCase.assertEquals(1, next);
    }

    @Test
    public void testFindAll() {
        List<Author> authorList = authorMapper.findAll();
        TestCase.assertFalse("获取错误"+authorList,authorList.size()==0);

        Author author = authorMapper.findSomeAuthor(2);
        TestCase.assertFalse(author == null);
    }
}
