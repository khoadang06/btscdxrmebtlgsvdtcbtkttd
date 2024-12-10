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
   - ![image](https://github.com/user-attachments/assets/e3d54c60-42a1-48e3-9057-dcbcfa0b9643)
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
SachPage.vue:
