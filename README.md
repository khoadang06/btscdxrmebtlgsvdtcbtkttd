# Môi trường
| Tên | Version |
| --- | --- |
| jdk | 17 |
| Spring Boot | 3.4 |
| IDE | IntelliJ IDEA 202x |

## Dependencies
| Tên | Version |
| --- | --- |
| Spring Boot DevTools | |
| Spring Web | |
| Lombok | |
| Thymeleaf | |

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

## Expressions
| Tên | Mục đích | Ví dụ |
| --- | --- | --- |
| @{ } | Tạo URLs | `<a th:href="@{/home}">` |
| ${ } | Truy cập biến | `<p th:text="${message}">` |
| *{ } | Truy cập thuộc tính của đối tượng đã chọn | `<input th:field="*{name}">` |


# Hướng dẫn
