<script setup>
defineModel('book', {
  default: () => ({
    ten: '',
    loai: '',
    tacGia: '',
    gia: 0
  })
})
</script>

<template>
  <section>
    <form>
      <div class="mb-3">
        <label for="tenSach" class="form-label">Tên</label>
        <input type="text" class="form-control" id="tenSach" v-model="book.ten">
      </div>
      <div class="mb-3">
        <label for="loaiSach" class="form-label">Loại Sách</label>
        <select class="form-select" id="loaiSach" v-model="book.loai">
          <option value="Sách thiếu nhi">Sách thiếu nhi</option>
          <option value="Sách khoa học">Sách khoa học</option>
          <option value="Truyện tranh">Truyện tranh</option>
          <option value="Loại 1">Loại 1</option>
          <option value="Loại 2">Loại 2</option>
          <option value="Loại 3">Loại 3</option>
          <option value="Loại 4">Loại 4</option>
          <option value="Loại 5">Loại 5</option>
          <option value="Loại 6">Loại 6</option>
          <option value="Loại 7">Loại 7</option>
          <option value="Loại 8">Loại 8</option>
          <option value="Loại 9">Loại 9</option>
          <option value="Loại 10">Loại 10</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="tacGia" class="form-label">Tên</label>
        <input type="text" class="form-control" id="tacGia" v-model="book.tacGia">
      </div>
      <div class="mb-3">
        <label for="gia" class="form-label">Giá</label>
        <input type="text" class="form-control" id="gia" v-model="book.gia">
      </div>
    </form>
  </section>
</template>

<style scoped>

</style>
