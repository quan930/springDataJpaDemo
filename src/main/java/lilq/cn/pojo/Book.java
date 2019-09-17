package lilq.cn.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "book")
@Entity
@Table(name="book")
public class Book {
    @Id
    private Long id;
    private String name;
    private Double price;

    public Book() {
    }

    public Book(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
