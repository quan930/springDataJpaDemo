package lilq.cn;

import lilq.cn.config.Config;
import lilq.cn.pojo.Book;
import lilq.cn.repository.BookRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        bookRepository.save(new Book(1L,"JAVA",12.11));
        System.out.println(bookRepository.findAll());
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = context.getBean(LocalContainerEntityManagerFactoryBean.class);
    }
}
