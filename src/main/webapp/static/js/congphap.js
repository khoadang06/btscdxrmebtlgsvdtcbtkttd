function chiTiet(id) {
    $.ajax({
        url: "/cong-phap/chi-tiet?id=" + id,
        method: "GET",
        contentType: "application/json",
        success: function (data) {
            console.log(data)
            document.getElementById("id").value = data.id
            document.getElementById("tenCongPhap").value = data.tenCongPhap
            document.getElementById("moTa").value = data.moTa
            document.getElementById("phamChat").value = data.idPhamChat
            document.getElementById("ngayTao").value = data.ngayTao
            document.getElementById("ngayCapNhat").value = data.ngayCapNhat
            document.getElementById("tenLoaiCongPhap").value = data.idLoaiCongPhap
            document.getElementById("daThatTruyen").checked = data.thatTruyen
            document.getElementById("chuaThatTruyen").checked = !data.thatTruyen
        }
    })
}

function xoa(id) {
    $.ajax({
        url: "/cong-phap/xoa?id=" + id,
        method: "DELETE",
        contentType: "application/json",
        success: function (data) {
            location.reload()
        }
    })
}



