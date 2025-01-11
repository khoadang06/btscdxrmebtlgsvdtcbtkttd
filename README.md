
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

```xml
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
	<dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.11.0</version>
        </dependency>
    </dependencies>
```
## Database
```sql
-- Bảng loại công pháp
CREATE TABLE loai_cong_phap (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ten_loai_cong_phap NVARCHAR(100) NOT NULL,
    mo_ta NVARCHAR(MAX),
    ngay_tao DATE,
    ngay_cap_nhat DATE
);

-- Bảng phẩm chất
CREATE TABLE pham_chat (
	id int IDENTITY(1,1) PRIMARY KEY,
	ten_pham_chat NVARCHAR(100) NOT NULL,
);

-- Bảng công pháp
CREATE TABLE cong_phap (
    id INT IDENTITY(1,1) PRIMARY KEY,
    ten_cong_phap NVARCHAR(100) NOT NULL,
    mo_ta NVARCHAR(MAX),
    id_pham_chat INT,
    ngay_tao DATE,
    ngay_cap_nhat DATE,
    id_loai_cong_phap INT,
    that_truyen BIT DEFAULT 0,
    FOREIGN KEY (id_pham_chat) REFERENCES pham_chat(id),
    FOREIGN KEY (id_loai_cong_phap) REFERENCES loai_cong_phap(id)
);

-- Bảng đăng nhập
CREATE TABLE dang_nhap (
	id INT IDENTITY(1,1) PRIMARY KEY,
	ten_dang_nhap VARCHAR(100) NOT NULL,
	mat_khau VARCHAR(100) NOT NULL,
	admin BIT DEFAULT 0
);

-- Dữ liệu mẫu cho bảng loại công pháp
INSERT INTO loai_cong_phap (ten_loai_cong_phap, mo_ta, ngay_tao, ngay_cap_nhat)
VALUES 
(N'Kiếm Pháp', N'Các công pháp võ học sử dụng kiếm', '1000-01-01', '1000-01-01'),
(N'Thương Pháp', N'Các công pháp võ học sử dụng thương', '1000-01-01', '1000-01-01'),
(N'Côn Pháp', N'Các công pháp võ học sử dụng côn', '1000-01-01', '1000-01-01'),
(N'Bổng Pháp', N'Các công pháp võ học sử dụng bổng', '1000-01-01', '1000-01-01'),
(N'Cước Pháp', N'Các công pháp võ học sử dụng cước', '1000-01-01', '1000-01-01'),
(N'Chưởng Pháp', N'Các công pháp võ học sử dụng tay không, đánh chưởng', '1000-01-01', '1000-01-01'),
(N'Đao Pháp', N'Các công pháp võ học sử dụng đao', '1000-01-01', '1000-01-01'),
(N'Bảo Vệ Pháp', N'Các công pháp dùng để bảo vệ, phòng thủ', '1000-01-01', '1000-01-01');

-- Dữ liệu mẫu cho bảng phẩm chất
INSERT INTO pham_chat (ten_pham_chat)
VALUES 
(N'Hoàng Giai'),
(N'Huyền Giai'),
(N'Địa Giai'),
(N'Thiên Giai');

-- Dữ liệu mẫu cho bảng công pháp
INSERT INTO cong_phap (ten_cong_phap, mo_ta, muc_do, ngay_tao, ngay_cap_nhat, id_loai_cong_phap, that_truyen)
VALUES 
(N'Đại Hồng Thủ', N'Một công pháp sử dụng cước mạnh mẽ, có thể tấn công từ xa', 2, '1000-01-01', '1000-01-01', 5, 0),
(N'Thiết Cước', N'Một công pháp chuyên về các đòn đá chớp nhoáng, khiến đối phương không kịp phản ứng', 1, '1000-01-01', '1000-01-01', 5, 0),
(N'Bảo Vệ Thần Công', N'Công pháp bảo vệ, có khả năng chống lại mọi đòn tấn công', 3, '1000-01-01', '1000-01-01', 8, 0),
(N'Xích Bích Đao', N'Công pháp sử dụng đao, nổi bật với những đòn đánh chéo mạnh mẽ', 3, '1000-01-01', '1000-01-01', 7, 0),
(N'Thiên Đao Cửu Kiếm', N'Một công pháp huyền thoại, kết hợp giữa đao pháp và kiếm pháp', 3, '1000-01-01', '1000-01-01', 7, 1),
(N'Ngọc Diện Huyền Bảo', N'Công pháp bảo vệ sử dụng chưởng pháp, rất khó bị phá vỡ', 2, '1000-01-01', '1000-01-01', 6, 0),
(N'Hỏa Phụng Pháp', N'Công pháp đặc biệt, mạnh mẽ nhưng khó kiểm soát', 3, '1000-01-01', '1000-01-01', 1, 1),
(N'Vô Song Kiếm', N'Một công pháp kiếm pháp tuyệt thế, không ai sánh bằng', 3, '1000-01-01', '1000-01-01', 1, 1),
(N'Tuyệt Tình Thương', N'Công pháp thương, mạnh mẽ và vô cùng độc đáo', 3, '1000-01-01', '1000-01-01', 2, 1),
(N'Côn Lực Tăng Cường', N'Công pháp côn pháp tập trung vào sức mạnh và khả năng chiến đấu', 2, '1000-01-01', '1000-01-01', 3, 0),
(N'Lăng Ba Vi Bộ', N'Một công pháp sử dụng các bước di chuyển nhanh như chớp, không ai có thể đuổi kịp', 1, '1000-01-01', '1000-01-01', 8, 0),
(N'Cửu Âm Chân Kinh', N'Công pháp võ học cao cấp, bao gồm kiếm pháp, công phu nội công', 3, '1000-01-01', '1000-01-01', 1, 1),
(N'Thiên Long Bát Bộ', N'Một công pháp nổi tiếng trong sử thi, bao gồm nhiều kỹ thuật và bí kíp', 2, '1000-01-01', '1000-01-01', 1, 0),
(N'Xà Hình Thương', N'Công pháp sử dụng thương, với các thế đánh mạnh mẽ và linh hoạt', 2, '1000-01-01', '1000-01-01', 2, 0),
(N'Vô Tình Côn Pháp', N'Một công pháp huyền bí với côn dài, mạnh mẽ nhưng cũng đầy uyển chuyển', 3, '1000-01-01', '1000-01-01', 3, 1);

-- Dữ liệu mẫu bảng login
INSERT INTO dang_nhap (ten_dang_nhap, mat_khau, admin)
VALUES
('chuongmon', 'chuongmon', 1),
('detu', 'detu', 0);

DROP TABLE cong_phap
DROP TABLE loai_cong_phap
DROP TABLE pham_chat
DROP TABLE dang_nhap
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
