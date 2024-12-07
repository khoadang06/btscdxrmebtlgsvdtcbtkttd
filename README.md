
# SOF3012

Project mà thằng chủ repo tự chế để làm ôn thi <br/>
Project này có cái gì? <br/>
- Join bảng
- DTO
- Ajax
- Phân trang

# Triển khai môi trường

Đây là môi trường của project
| Tên | Phiên bản |
| --- | --- |
| JDK | 23 |
| Jakarta EE | 11 |
| Tomcat | 10 |
| IDE | Intellij IDEA 2024 |

- Nếu các bạn hỏi vì sao tôi lại dùng `jdk23` và `jakarta 11` trong khi các thầy cô dạy dùng `jdk17`, `jakarta 9` thì là do tôi thích đè bản mới nhất ra vụt 🐧
- Các thầy cô không cho các bạn dùng jdk hay jakarta mới hơn đơn giản là vì nó còn liên quan đến thư viện (dependencies) cũng như các `phương thức` và `hàm` bên trong thư viện đó, các thư viện mà các bạn hay lấy trong github của cô Hằng chỉ phù hợp với `jdk17 và jakarta 9`
- Còn nếu các bạn thích đâm đầu vào các bản latest, thấy bản mới phát là nhấn update như tôi, thì dùng đống dependencies tôi để ở dưới (nếu bị lỗi liên quan đến dependency, lên maven check xem có bản mới hơn không) cháu nào clone project về thì có sẵn rồi không cần copy
- Và quan trọng nhất là các bạn phải biết TỰ SỬA LỖI, muốn vọc thì ít nhất cũng phải biết nhìn log xem lỗi cái gì ở đâu mà sửa, không biết sửa thì google, stackoverflow; chứ còn cứ dùng bản khác thầy cô dạy xong lỗi tùm lum rồi lại hỏi "Ơ thầy/cô ơi sao của em lại bị lỗi như thế này thế nọ lọ chai", là ăn gõ đấy
- Ví dụ đơn giản là các bạn dùng jdk23 nhưng xài lombok 1.18.24, có khướt nó chạy
- Cho cháu nào không biết cái github thần thánh của cô Hằng thì [nhấn vào đây](https://github.com/HangNT169-POLY/Config_JAVA_WEB)

## Dependencies
pom.xml:

```
<dependencies>
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>7.0.0.Alpha3</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>4.0.5</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.servlet.jsp.jstl</groupId>
            <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
            <version>3.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>jakarta.servlet.jsp.jstl</artifactId>
            <version>3.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.34</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>12.8.1.jre11</version>
        </dependency>
        <dependency>
            <groupId>commons-beanutils</groupId>
            <artifactId>commons-beanutils</artifactId>
            <version>1.9.4</version>
        </dependency>
    </dependencies>
```

# Cấu trúc (Structure)
- Project của tôi sử dụng cấu trúc phân tầng (Layered Architecture)
- Bao gồm các package

| Tên package/directory | Mục đích |
| --- | --- |
| controller | Chứa servlet |
| dto | Chứa dto (Data Transfer Object) |
| filter | Chứa filter |
| model (hoặc entity) | Chứa các lớp thực thể |
| repository | Chứa các lớp dùng để tương tác với DB |
| service | Chứa các lớp logic nghiệp vụ |
| util | Chứa các lớp bổ trợ (ví dụ như HibernateConfig) |
| static | Chứa các tài nguyên web như css, js, ảnh |
| WEB-INF | Chứa jsp |

- Trong package util sẽ có 1 package là json kèm theo lớp `LocalDateTypeAdapter`, lớp này dùng để tạo TypeAdapter cho Gson parse kiểu LocalDate sang json
- Trong package static có package js dùng để chứa javascript, tức là ajax

# Một số thứ vớ vẩn khác
## File và Code Template
- Dành riêng cho các cháu dùng IntelliJ IDEA 2024 như thằng chủ repo và không tìm thấy servlet, filter khi chuột phải > new, thì là do IntelliJ nó xóa bà nó rồi, IntelliJ bản 21 trở về trước mới có:) làm theo như bên dưới để có lại
- Cách dùng code Template
    - Vào setting `Ctrl + Alt + S`
    - Đi đến `Editor > File and Code Template`
    - Bấm dấu + bên góc trái (Create Template)
    - Điền tên (Name) và Extension
    - Nhấn Apply rồi Ok
    - Xong, chuột phải > new xem có chưa

### Servlet
Extension: java

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "${Class_Name}", value = "/${Class_Name}")
public class ${Class_Name} extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
    }
}
```

### Filter
Extension: java

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "${Class_Name}")
public class ${Class_Name} implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
```

### HibernateConfig
Extension: java
- Nhớ điền tên DB với mật khẩu

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "");
        properties.put(Environment.PASS, "");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        //conf.addAnnotatedClass(.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
```

### Entity
Extension: java

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "")
public class ${Class_Name} {
    @Id
    @GeneratedValue(strategy = )
    private Integer id;
    
    @Nationalized
    @Column (name = "")
    private String;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")
    
}
```

### JSP
Extension: jsp
- Template này add sẵn bootstrap 5 và jQuery, việc của bạn chỉ là thêm `class=` và một đống `<div>`

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Title</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <form action="" method="POST">
        <label><input type="" name="" value="" required></label><br>
        <select name="">
            <c:forEach items="${}" var="">
                <option value="${}">${}</option>
            </c:forEach>
        </select>
        <br>
        <button type="" onclick="return confirm('Confirm?')"></button>
    </form>
    <table>
        <thead>
        <tr>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${}" var="">
            <tr>
                <td>${}</td>
                <td>
                    <button onclick="window.location.href='/?id=${}'">Details</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </body>
</html>
```
