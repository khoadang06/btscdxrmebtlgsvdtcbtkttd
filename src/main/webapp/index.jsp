<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Title</title>
  </head>
  <body>
    <form action="/cong-phap/them" method="POST">
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Tàng Kinh Các</h1>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label for="id" class="form-label">ID</label>
                        <input type="number" name="id" id="id" class="form-control" disabled>
                    </div>
                    <div class="mb-3">
                        <label for="tenCongPhap" class="form-label">Tên Công Pháp</label>
                        <input type="text" name="tenCongPhap" id="tenCongPhap" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="moTa" class="form-label">Mô Tả</label>
                        <input type="text" name="moTa" id="moTa" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="phamChat" class="form-label">Phẩm Chất</label>
                        <select name="phamChat" id="phamChat" class="form-select">
                            <c:forEach items="${listPhamChat}" var="listPC">
                                <option value="${listPC.id}">${listPC.tenPhamChat}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="ngayTao" class="form-label">Ngày Tạo</label>
                        <input type="date" name="ngayTao" id="ngayTao" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="ngayCapNhat" class="form-label">Ngày Cập Nhật</label>
                        <input type="date" name="ngayCapNhat" id="ngayCapNhat" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="loaiCongPhap" class="form-label">Danh Mục</label>
                        <select name="loaiCongPhap" id="loaiCongPhap" class="form-select">
                            <c:forEach items="${listLoaiCongPhap}" var="listLCP">
                                <option value="${listLCP.id}">${listLCP.tenLoaiCongPhap}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Thất Truyền</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="thatTruyen" id="chuaThatTruyen" value="false">
                            <label class="form-check-label" for="chuaThatTruyen">
                                Chưa Thất Truyền
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="thatTruyen" id="daThatTruyen" value="true" checked>
                            <label class="form-check-label" for="daThatTruyen">
                                Đã Thất Truyền
                            </label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary" onclick="return confirm('Confirm?')">Add</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Công Pháp</th>
            <th>Mô Tả</th>
            <th>Phẩm Chất</th>
            <th>Ngày Tạo</th>
            <th>Ngày Cập Nhật</th>
            <th>Danh Mục</th>
            <th>Thất Truyền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCongPhap}" var="listCP">
            <tr>
                <td>${listCP.id}</td>
                <td>${listCP.tenCongPhap}</td>
                <td>${listCP.moTa}</td>
                <td>${listCP.phamChat}</td>
                <td>${listCP.ngayTao}</td>
                <td>${listCP.ngayCapNhat}</td>
                <td>${listCP.tenLoaiCongPhap}</td>
                <td>${listCP.thatTruyen==true? "Đã Thất Truyền": "Chưa Thất Truyền"}</td>
                <td>
                    <button class="btn btn-primary">Chi Tiết</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
  </body>
</html>