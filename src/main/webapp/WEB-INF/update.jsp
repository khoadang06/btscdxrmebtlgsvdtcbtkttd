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
    <form action="/cong-phap/sua" method="POST">
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Tàng Kinh Các</h1>
                </div>
                <div class="card-body">
                    <div class="mb-3">
                        <label for="id" class="form-label">ID</label>
                        <input type="number" name="id" id="id" class="form-control" value="${congPhap.id}" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="tenCongPhap" class="form-label">Tên Công Pháp</label>
                        <input type="text" name="tenCongPhap" id="tenCongPhap" class="form-control" value="${congPhap.tenCongPhap}">
                    </div>
                    <div class="mb-3">
                        <label for="moTa" class="form-label">Mô Tả</label>
                        <input type="text" name="moTa" id="moTa" class="form-control" value="${congPhap.moTa}">
                    </div>
                    <div class="mb-3">
                        <label for="phamChat" class="form-label">Phẩm Chất</label>
                        <select name="phamChat" id="phamChat" class="form-select">
                            <c:forEach items="${listPhamChat}" var="pc">
                                <option value="${pc.id}" ${pc.id == congPhap.phamChat.id ? 'selected' : ''}>${pc.tenPhamChat}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="ngayTao" class="form-label">Ngày Tạo</label>
                        <input type="date" name="ngayTao" id="ngayTao" class="form-control" value="${congPhap.ngayTao}">
                    </div>
                    <div class="mb-3">
                        <label for="ngayCapNhat" class="form-label">Ngày Cập Nhật</label>
                        <input type="date" name="ngayCapNhat" id="ngayCapNhat" class="form-control" value="${congPhap.ngayCapNhat}">
                    </div>
                    <div class="mb-3">
                        <label for="tenLoaiCongPhap" class="form-label">Loại Công Pháp</label>
                        <select name="tenLoaiCongPhap" id="tenLoaiCongPhap" class="form-select">
                            <c:forEach items="${listLoaiCongPhap}" var="lcp">
                                <option value="${lcp.id}" ${lcp.id == congPhap.loaiCongPhap.id ? 'selected' : ''}>${lcp.tenLoaiCongPhap}</option>
                            </c:forEach>
                        </select>
                        <input type="hidden" name="loaiCongPhapId" id="loaiCongPhapId">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Thất Truyền</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="thatTruyen" id="chuaThatTruyen" value="false" ${!congPhap.thatTruyen ? "checked" : ""}>
                            <label class="form-check-label" for="chuaThatTruyen">
                                Chưa Thất Truyền
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="thatTruyen" id="daThatTruyen" value="true" ${congPhap.thatTruyen ? "checked" : ""}>
                            <label class="form-check-label" for="daThatTruyen">
                                Đã Thất Truyền
                            </label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn btn-primary">Sửa</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
  </body>
</html>