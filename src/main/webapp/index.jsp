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
    <script src="${pageContext.request.contextPath}/static/js/congphap.js"></script>
    <form action="/logout" method="GET">
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <button type="submit" class="btn btn-primary">Logout</button>
                </div>
            </div>
        </div>
    </form>
    <form action="/cong-phap/them" method="POST">
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Tàng Kinh Các</h1>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label for="id" class="form-label">ID</label>
                        <input type="number" name="id" id="id" class="form-control" readonly>
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
                            <c:forEach items="${listPhamChat}" var="pc">
                                <option value="${pc.id}">${pc.tenPhamChat}</option>
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
                        <label for="tenLoaiCongPhap" class="form-label">Loại Công Pháp</label>
                        <select name="tenLoaiCongPhap" id="tenLoaiCongPhap" class="form-select">
                            <c:forEach items="${listLoaiCongPhap}" var="lcp">
                                <option value="${lcp.id}">${lcp.tenLoaiCongPhap}</option>
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
                        <button type="submit" class="btn btn-primary" onclick="return confirm('Confirm?')">Thêm</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <div class="mb-3">
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tên Công Pháp</th>
                            <th>Mô Tả</th>
                            <th>Phẩm Chất</th>
                            <th>Ngày Tạo</th>
                            <th>Ngày Cập Nhật</th>
                            <th>Loại Công Pháp</th>
                            <th>Thất Truyền</th>
                            <th>Nút</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${danhSachCongPhap}" var="congPhap">
                            <tr>
                                <td>${congPhap.id}</td>
                                <td>${congPhap.tenCongPhap}</td>
                                <td>${congPhap.moTa}</td>
                                <td>${congPhap.phamChat}</td>
                                <td>${congPhap.ngayTao}</td>
                                <td>${congPhap.ngayCapNhat}</td>
                                <td>${congPhap.tenLoaiCongPhap}</td>
                                <td>${congPhap.thatTruyen==true? "Đã Thất Truyền":"Chưa Thất Truyền"}</td>
                                <td colspan="2">
                                    <div class="btn-group">
                                        <button class="btn btn-primary" onclick="chiTiet(${congPhap.id})">Chi Tiết</button>
                                        <button class="btn btn-danger" onclick="xoa(${congPhap.id})">Xóa</button>
                                        <button class="btn btn-warning" onclick="window.location.href='/cong-phap/sua?id=${congPhap.id}'">Sửa</button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <button class="btn btn-warning" onclick="window.location.href='/cong-phap/hien-thi?page=${page - 1}'">Prev</button>
                    <button class="btn btn-warning" onclick="window.location.href='/cong-phap/hien-thi?page=${page + 1}'">Next</button>
                </div>
            </div>
        </div>
    </div>

  </body>
</html>