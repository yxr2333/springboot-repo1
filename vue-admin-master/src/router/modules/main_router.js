import Layout from '@/layout'

const mainRouter = {
  path: '/main',
  component: Layout,
  name: 'Main',
  meta: {
    title: '核心数据管理',
    icon: 'education'
  },
  children: [
    {
      path: 'student',
      component: () => import('@/views/nested/main/student'),
      name: 'Student',
      meta: { title: '学员信息管理' }
    },
    {
      path: 'teacher',
      component: () => import('@/views/nested/main/teacher'),
      name: 'Teacher',
      meta: { title: '小导师信息管理' }
    }
  ]
}
export default mainRouter
