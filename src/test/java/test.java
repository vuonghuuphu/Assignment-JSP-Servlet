import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Entity.ProductModel;
import com.example.assignmentjspservlet.Model.Categories;
import com.example.assignmentjspservlet.Model.Product;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class test {
    @Test
    public void finall() throws SQLException, ClassNotFoundException {
        ProductModel m = new ProductModel();
        List<Product> c = m.findAll();
        for (int i = 0 ; i< c.size();i++){
            System.out.println(c.get(i).toString());
        }
//        System.out.println(c.size());
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        ProductModel m = new ProductModel();
        Product c = m.findbyId(7);
        System.out.println(c.toString());
        c.setName("cate221");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        c.setUpdatedAt(strDate);
        boolean t = m.update(6,c);
        if (t == true){
            c = m.findbyId(3);
            System.out.println("ok");
        }else{
            System.out.println("no");
        }

    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        ProductModel m = new ProductModel();
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        Product c = new Product("a",1,"a","http://res.cloudinary.com/dcy8k4pqx/image/upload/v1649662666/qhfi6qoc95nytdpsy0cw.webp",30.0, strDate);

        boolean t = m.save(c);

    }

}
