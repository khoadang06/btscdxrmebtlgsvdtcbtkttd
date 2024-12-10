import { createMemoryHistory, createRouter } from 'vue-router'
import SachPage from '@/pages/SachPage.vue'
import RouterPage from '@/pages/RouterPage.vue'

const routes = [
  { path: '/', component: SachPage },
  { path: '/trang-chu', component: SachPage },
  { path: '/page', component: RouterPage }
]

const router = createRouter({
  history: createMemoryHistory(),
  routes,
})

export default router
