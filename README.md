# SOF308
Thấy môn đề là backend mà thấy giống fullstack hơn
# Các bước làm
## Chuẩn bị
- [node.js](https://nodejs.org/en)
## I. Tạo project và thêm thư viện
### Visual Studio Code
- Mở Terminal
- Gõ <br/>
```npm create vue@latest``` <br/>
```cd [Tên project]``` <br/>
```npm install``` <br/>
```npm install bootstrap``` <br/>
```npm install bootstrap-vue``` <br/>
### IntelliJ IDEA/WebStorm
- New Project
- Chọn Vue.js
- Đặt tên project, đường dẫn
- Node interpreter: đường dẫn đến node, nếu chưa có node có thể nhấn vào Download
  ![image](https://github.com/user-attachments/assets/99049656-7bb6-48a2-af8d-d539022caad4)
- Bỏ tick `Use the default project setup`
  ![image](https://github.com/user-attachments/assets/c47ff1d9-86c6-4b12-81a0-f2222336be4f)
- Nhấn Create
- Chọn như sau (hoặc tuỳ các bạn)
  ![image](https://github.com/user-attachments/assets/ffe472f4-6d5b-4147-af06-26f8c434d426)
- Nhấn RUN NPM INSTALL (góc dưới bên phải) <br/>
  ![image](https://github.com/user-attachments/assets/35f7947d-74c8-4362-be66-9f04b084ed3f)
- Mở Terminal, chạy
  ```cmd
  npm install bootstrap bootstrap-vue
  ```
  ![image](https://github.com/user-attachments/assets/b915d466-d430-4b13-886d-25d291383e1e)

## II. Điều chỉnh Project
- Xoá assets, components, views
  ![image](https://github.com/user-attachments/assets/a23c563d-2f03-4a0e-8c38-471088ee7862)
- Xoá hết nội dung trong `App.vue` và `router/index.js`
- `main.js`
  - Xoá
    ```javascript
    import './assets/main.css'
    ```
  - Và comment 2 dòng
    ```javascript
    import router from './router'
    app.use(router)
    ```
    ![image](https://github.com/user-attachments/assets/1d1f4875-3b28-4dee-9031-9de306378028)
  - Tại sao lại làm như vậy? Vì file `main.css` nằm trong directory `assets` đã bị xoá -> không import được và nếu không comment router thì bài không chạy lên đâu, trắng bóc luôn, khi nào làm đến router thì hẵng uncomment, không tin thử là biết
  - Import bootstrap
    ```javascript
    import 'bootstrap/dist/css/bootstrap.css'
    import 'bootstrap-vue/dist/bootstrap-vue.css'
    ```
    ![image](https://github.com/user-attachments/assets/ae4b548f-afd6-4216-960e-29d9588f0b72)

## III. Làm giao diện
### Header và Footer (Layout)
1. Tạo Directory mới đặt tên là `layout`, tạo thêm 2 `Vue Component` mới cho `Header` và `Footer`
   ![image](https://github.com/user-attachments/assets/34cba8c6-e9b9-4ed9-a45d-cd2070ef718f)
   ![image](https://github.com/user-attachments/assets/647ffa00-b8b1-4326-931c-dceb2fe5c9d9)
   - **Lưu ý:** Đừng đặt tên component là `Header` hay `Footer` vì nó trùng keyword
3. Lên [Bootstrap](https://getbootstrap.com/) shopping thôi
   - Bấm vào `Read the docs`
     ![image](https://github.com/user-attachments/assets/e3d54c60-42a1-48e3-9057-dcbcfa0b9643)
4. HeaderLayout.vue
   - Có thể chôm template bootstrap `Navbar` hoặc `Navs & Tabs`
   - Paste vào và xoá những thứ thừa ví dụ như `<form>`
   - Hoặc paste cái này vào
   ```vue
   <template>
    <header>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">Trang chủ</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Pages</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
   </template>
   ```
5. FooterLayout.vue
   - Thêm cái thẻ `<h1>` vào với nội dung trong đề là được
   - Ví dụ
   ```vue
   <template>
     <footer>
       <h1 style="text-align: center">Footer: FPT Polytechnic Hà Nội</h1>
     </footer>
   </template>
   ```
6. Gọi layout
   - Vào `App.vue`
   - Gọi `HeaderLayout` và `FooterLayout`, IDE tự import không cần import tay
     ```vue
     <script setup>
     import HeaderLayout from '@/layout/HeaderLayout.vue'
     import FooterLayout from '@/layout/FooterLayout.vue'
     </script>
     <template>
       <HeaderLayout/>
       <FooterLayout/>
     </template>
     ```
7. Kết quả
   ![image](https://github.com/user-attachments/assets/45a8af5f-48bb-4e89-b269-1f24254d49d4)
### Form (component)
1. Tạo Directory mới có tên `component`
2. Tạo form component, ví dụ `FormSachComponent`
3. Lại lên bootstrap chôm template thôi, lấy đại 1 cái template form, hoặc chôm cái ở dưới
   ```vue
   <template>
      <section>
        <form>
          <div class="mb-3">
            <label for="tenSach" class="form-label">Tên</label>
            <input type="text" class="form-control" id="tenSach">
          </div>
          <div class="mb-3">
            <label for="loaiSach" class="form-label">Loại Sách</label>
            <select class="form-select" id="loaiSach">
              <option>Sách thiếu nhi</option>
              <option>Sách khoa học</option>
              <option>Truyện tranh</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="tacGia" class="form-label">Tên</label>
            <input type="text" class="form-control" id="tacGia">
          </div>
          <div class="mb-3">
            <label for="gia" class="form-label">Giá</label>
            <input type="text" class="form-control" id="gia">
          </div>
        </form>
      </section>
   </template>
   ```
### Pages
1. Tạo directory mới có tên `pages`
2. Tạo 1 component, ví dụ `SachPage`
3. Thêm tiêu đề `<h1>`
4. Import Form
5. Thêm Button, ví dụ `add` và `update`
   ```vue
   <button type="submit" class="btn btn-success">Add</button>
   <button type="submit" class="btn btn-warning">Update</button>
   ```
6. Thêm 1 cái table nữa, chôm bootstrap tiếp thôi, hoặc:
   ```vue
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
  
     </tbody>
   </table>
   ```
SachPage.vue:
```vue
<script setup>
import FormSachComponent from '@/component/FormSachComponent.vue'
</script>

<template>
  <section class="container">
    <h1 style="text-align: center">Quản Lý Sách</h1>
    <FormSachComponent/>
    <button type="submit" class="btn btn-success">Add</button>
    <button type="submit" class="btn btn-warning">Update</button>
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

      </tbody>
    </table>
  </section>
</template>
```
7. Quay lại App.vue và gọi `<SachPage/>` ở giữa `<HeaderLayout/>` và `<FooterLayout/>`
8. Kết quả
   ![image](https://github.com/user-attachments/assets/1cc28ccd-c402-4a5b-b555-6cd279d59dc7)
## IV. Hàm và Phương thức (Tính năng)
### Dữ liệu mẫu `SachPage.vue`
<details>
	<summary>List Sách</summary>

`reactive` là `ref`, nhưng bố đời hơn

```javascript
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
```
</details>

### Load dữ liệu lên table `SachPage.vue`
1. Trong `<tbody>`, thêm vòng lặp như sau
   ```vue
   <template v-for="(sach, index) in listSach" :key="sach.id">
    <tr>
     <td>{{ sach.id }}</td>
     <td>{{ sach.ten }}</td>
     <td>{{ sach.loai }}</td>
     <td>{{ sach.tacGia }}</td>
     <td>{{ sach.gia }}</td>
     <td>
      <button type="submit" class="btn btn-danger">Delete</button>
     </td>
    </tr>
   </template>
   ```
   - `<tr>` là table row tức dòng trong bảng
   - `v-for="(sach, index) in listSach" :key="sach.id"`
     - `v-for=` là vòng lặp, giống `<c:forEach>`
     - `"(sach, index) in listSach"` "sach" là tên biến, có thể đặt là "s" hoặc bất cứ thứ gì, `index` là vị trí của `sach` trong mảng bắt đầu từ `0`, "listSach" là tên mảng dữ liệu chỗ `const listSach = reactive([])`
     - `:key` cứ nghĩ nó giống primary key trong sql ấy
   - `<td>` là cell, ô trong bảng
   - `{{ sach.id }}` là lấy ra đặc tính (properties)
2. Xong load rồi:)
### Xoá `SachPage.vue`
1. Trong thẻ `<button>`, thêm `@click="deleteSach(index)"`
   ```vue
   <button type="submit" class="btn btn-danger" @click="deleteSach(index)">Delete</button>
   ```
3. Khai báo hàm `deleteSach` trong thẻ `<script>`
   ```javascript
   const deleteSach = (index) => {
     listSach.splice(index, 1)
   }
   ```
   - **Lưu ý:** khai báo hàm **phải ở bên dưới khai báo mảng dữ liệu `const listSach = reactive([])`**, vì sao? Code chạy từ trên xuống dưới, phải khai báo mảng dữ liệu trước mới có dữ liệu để xoá
4. Xong xoá
### Thêm
1. Khai báo đối tượng "sach" trong thẻ `<script>` trong `SachPage.vue`
   ```js
   const sach = reactive({
    ten: '',
    loai: '',
    tacGia: '',
    gia: 0
   })
   ```
2. Khai báo hàm `addSach` trong thẻ `<script>` trong `SachPage.vue`
   ```js
   const addSach = () => {
    listSach.push({
     id: listSach.length + 1,
     ...sach
    })
   }
   ```
   - `...sach`, cái `...` ở đây được gọi là `"spread operator" hoặc "object spread syntax" ("toán tử trải rộng" hoặc "cú pháp trải rộng đối tượng")`, dùng để sao chép đặc tính `(properties)` của một đối tượng sang một đối tượng mới
3. Thêm `v-model` vào `<FormSachComponent/>` trong `SachPage.vue`
   ```vue
   <FormSachComponent v-model:book="sach"/>
   ```
   - `:book` có thể đặt bằng tên khác
4. `defineModel` bên `FormSachComponent.vue`
   ```js
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
   ```
   - Tên biến `'book'` phải trùng bới `v-model:book="sach"` ở `SachPage.vue`, ví dụ `v-model:book1="sach"` thì phải là `defineModel('book1',`
5. Gán `v-model=""` vào các `<input>` và `<select>` tương ứng, và gán `value` cho các `<option>` trong `<select>`
   ```
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
   ```
6. Trong thẻ `<button>` của Add, thêm `@click="addSach"`
   ```vue
   <button type="submit" class="btn btn-success" @click="addSach">Add</button>
   ```
8. Xong thêm
### Chi tiết `SachPage.vue`
1. Thêm button chi tiết ở trong `<table>`, cụ thể là trong `v-for`
   ```vue
   <button type="submit" class="btn btn-primary" @click="detailSach(sach)">Chi Tiết</button>
   ```
   - Hàm `detailSach` nhận giá trị truyền vào `sach` từ `v-for`
2. Khai báo hàm
   ```js
   const detailSach = (item) => {
    Object.assign(sach, item)
   }
   ```
   - Vì sao dùng `Object.assign` thay vì `sach.value = {...item}` như thường lệ? Vì *~~chatgpt bảo thế~~* mảng dữ liệu đang là `reactive`
3. Xong chi tiết

### Cập nhật `SachPage.vue`
1. Trong thẻ `<button>` của Update, thêm `@click="updateSach"`
   ```vue
   <button type="submit" class="btn btn-warning" @click="updateSach">Update</button>
   ```
2. Khai báo function `indexUpdate`
   ```js
   const indexUpdate = ref(-1)
   ```
3. Sửa hàm `detailSach`
   ```js
   const detailSach = (item) => {
    Object.assign(sach, item)
    indexUpdate.value = listSach.findIndex((sach) => sach.id === item.id)
   }
   ```
4. Khai báo hàm `updateSach`
   ```js
   const updateSach = () => {
    listSach[indexUpdate.value] = {...sach}
    indexUpdate.value = -1
   }
   ```
5. Như thế này là đúng
   ```js
   const indexUpdate = ref(-1)

   const detailSach = (item) => {
    Object.assign(sach, item)
    indexUpdate.value = listSach.findIndex((sach) => sach.id === item.id)
   }

   const updateSach = () => {
    listSach[indexUpdate.value] = {...sach}
    indexUpdate.value = -1
   }
   ```
6. Xong cập nhật
## V. Router *(CHỈ LÀM KHI ĐÃ XONG TOÀN BỘ PHẦN TRÊN)*
1. Quay lại `HeaderLayout.vue`
2. Import `RouterLink`
   ```js
   <script setup>
   import { RouterLink } from 'vue-router'
   </script>
   ```
   
3. Thay thế thẻ `<a>` bằng `<RouterLink to="/{path}">{Name}</RouterLink>`

   - `{path}` là đường dẫn, `{Name}` là tên
   - Ví dụ "Trang chủ" và "Page"
   ```vue
   <RouterLink to="/trang-chu" class="nav-link">Trang Chủ</RouterLink>
   <RouterLink to="/page" class="nav-link">Page</RouterLink>
   ```

   `HeaderLayout.vue`
   ```vue
   <script setup>
   import { RouterLink } from 'vue-router'
   </script>

   <template>
    <header>
     <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <RouterLink to="/trang-chu" class="nav-link">Trang Chủ</RouterLink>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <RouterLink to="/page" class="nav-link">Page</RouterLink>
            </li>
          </ul>
        </div>
      </div>
     </nav>
    </header>
   </template>
   ```
4. Tạo component mới cho đường dẫn `/page`
   - Ghi đại cái quần què gì cũng được
   - Ví dụ `RouterPage.vue`
     ```vue
     <template>
      <p>
       <strong>Đường dẫn hiện tại:</strong> {{ $route.fullPath }}
      </p>
     </template>
     ```
5. Vào `index.js` trong directory `router` và paste
   ```js
   import { createMemoryHistory, createRouter } from 'vue-router'

   const routes = [
    { path: '{path}', component: {component}},
    { path: '{path}', component: {component}}
   ]

   const router = createRouter({
    history: createMemoryHistory(),
    routes,
   })

   export default router
   ```
6. Sửa và liệt kê đường dẫn, component
   - Ví dụ
   ```js
   import { createMemoryHistory, createRouter } from 'vue-router'
   import SachPage from '@/pages/SachPage.vue'
   import RouterPage from '@/pages/RouterPage.vue'

   const routes = [
    { path: '/', component: SachPage },
    { path: '/trang-chu', component: SachPage },
    { path: '/page', component: RouterPage },
   ]

   const router = createRouter({
    history: createMemoryHistory(),
    routes,
   })

   export default router
   ```
   - Code trên có 3 path là "/", "/trang-chu" và "/page" lần lượt dẫn đến các component là `SachPage.vue`, `SachPage.vue` và `RouterPage.vue`
7. Về `App.vue`
   - Thay `<SachPage/>` ban đầu thành `<RouterView/>`
8. Cuối cùng sang `main.js`
   - Uncomment 2 dòng
     ```javascript
     import router from './router'
     app.use(router)
     ```
9. Xong
