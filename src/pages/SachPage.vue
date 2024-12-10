<script setup>
import FormSachComponent from '@/component/FormSachComponent.vue'
import { reactive, ref } from 'vue'

const listSach = reactive([
  {
    ten: 'Tên 1',
    loai: 'Loại 1',
    tacGia: 'Tác giả 1',
    gia: 60,
    id: '1'
  },
  {
    ten: 'Tên 2',
    loai: 'Loại 2',
    tacGia: 'Tác giả 2',
    gia: 95,
    id: '2'
  },
  {
    ten: 'Tên 3',
    loai: 'Loại 3',
    tacGia: 'Tác giả 3',
    gia: 19,
    id: '3'
  },
  {
    ten: 'Tên 4',
    loai: 'Loại 4',
    tacGia: 'Tác giả 4',
    gia: 50,
    id: '4'
  },
  {
    ten: 'Tên 5',
    loai: 'Loại 5',
    tacGia: 'Tác giả 5',
    gia: 44,
    id: '5'
  },
  {
    ten: 'Tên 6',
    loai: 'Loại 6',
    tacGia: 'Tác giả 6',
    gia: 24,
    id: '6'
  },
  {
    ten: 'Tên 7',
    loai: 'Loại 7',
    tacGia: 'Tác giả 7',
    gia: 90,
    id: '7'
  },
  {
    ten: 'Tên 8',
    loai: 'Loại 8',
    tacGia: 'Tác giả 8',
    gia: 38,
    id: '8'
  },
  {
    ten: 'Tên 9',
    loai: 'Loại 9',
    tacGia: 'Tác giả 9',
    gia: 64,
    id: '9'
  },
  {
    ten: 'Tên 10',
    loai: 'Loại 10',
    tacGia: 'Tác giả 10',
    gia: 40,
    id: '10'
  },
  {
    ten: 'Tên 11',
    loai: 'Loại 11',
    tacGia: 'Tác giả 11',
    gia: 87,
    id: '11'
  },
  {
    ten: 'Tên 12',
    loai: 'Loại 12',
    tacGia: 'Tác giả 12',
    gia: 93,
    id: '12'
  },
  {
    ten: 'Tên 13',
    loai: 'Loại 13',
    tacGia: 'Tác giả 13',
    gia: 15,
    id: '13'
  }
])

const deleteSach = (index) => {
  listSach.splice(index, 1)
}

const sach = reactive({
  ten: '',
  loai: '',
  tacGia: '',
  gia: 0
})

const addSach = () => {
  listSach.push({
    id: listSach.length + 1,
    ...sach
  })
}

const indexUpdate = ref(-1)

const detailSach = (item) => {
  Object.assign(sach, item)
  indexUpdate.value = listSach.findIndex((sach) => sach.id === item.id)
}

const updateSach = () => {
  listSach[indexUpdate.value] = {...sach}
  indexUpdate.value = -1
}
</script>

<template>
  <section class="container">
    <h1 style="text-align: center">Quản Lý Sách</h1>
    <FormSachComponent v-model:book="sach"/>
    <button type="submit" class="btn btn-success" @click="addSach">Add</button>
    <button type="submit" class="btn btn-warning" @click="updateSach">Update</button>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Loại</th>
        <th scope="col">Tác Giả</th>
        <th scope="col">Giá</th>
        <th scope="col">Chức Năng</th>
      </tr>
      </thead>
      <tbody>
        <template v-for="(sach, index) in listSach" :key="sach.id">
          <tr>
            <td>{{ sach.id }}</td>
            <td>{{ sach.ten }}</td>
            <td>{{ sach.loai }}</td>
            <td>{{ sach.tacGia }}</td>
            <td>{{ sach.gia }}</td>
            <td>
              <button type="submit" class="btn btn-danger" @click="deleteSach(index)">Delete</button>
              <button type="submit" class="btn btn-primary" @click="detailSach(sach)">Chi Tiết</button>
            </td>
          </tr>
        </template>
      </tbody>
    </table>
  </section>
</template>
