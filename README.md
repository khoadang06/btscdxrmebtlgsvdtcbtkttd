# Môi trường
| Tên | Version |
| --- | --- |
| jdk | 17 |
| Spring Boot | 3.4 |
| IDE | IntelliJ IDEA 202x |

## Dependencies
| Tên | Maven Repo |
| --- | --- |
| Spring Boot DevTools | [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools) |
| Spring Web | [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) |
| Lombok | [Maven](https://mvnrepository.com/artifact/org.projectlombok/lombok) |
| Thymeleaf | [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-thymeleaf) |
| Starter Validation | [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation) |

# Cấu trúc dự án
| Tên | Mục đích |
| --- | --- |
| controller | chứa controller |
| request | |
| templates | chứa html |

# Annotation quan trọng
| Tên | Mục đích |
| --- | --- |
| @Controller/@RestController | Tầng trung gian FE & BE |
| @Repository | Tầng làm việc với Database (DAO) |
| @Service | Tầng xử lý logic |
| @Component | Tầng cho tác vụ không thuộc các tầng trên |
| @Entity | Đối tượng cho ánh xạ Database |

# Thymeleaf Standard Dialects
| Tên | Tính năng |
| --- | --- |
| th:text | Thay nội dung phần tử HTML |
| th:if | Hiển thị có điều kiện |
| th:each | Vòng lặp |
| th:value | Thiết lập giá trị của trường nhập |
| th:object | Đối tượng |
| th:field | Thay cho name="" trong html |
| th:errors | Lấy lỗi |

## Expressions
| Tên | Mục đích | Ví dụ |
| --- | --- | --- |
| @{ } | Tạo URLs | `<a th:href="@{/home}">` |
| ${ } | Truy cập biến | `<p th:text="${message}">` |
| *{ } | Truy cập thuộc tính của đối tượng đã chọn | `<input th:field="*{name}">` |


# Hướng dẫn
