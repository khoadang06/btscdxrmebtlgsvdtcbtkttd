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
| Tên | Định nghĩa | Use Cases |
| --- | --- | --- |
| @{ } | Biểu thức cho URL, đường dẫn | th:href, th:src, th:action |
| ${ } | Biểu thức biến | Hiển thị dữ liệu trong văn bản hoặc thuộc tính |
| *{ } | Biểu thức biến lựa chọn | thường sử dụng chung với `th:object` hay `th:each` |


# Hướng dẫn
