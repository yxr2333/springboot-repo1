/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const nestedRouter = {
  path: '/nested',
  component: Layout,
  redirect: '/nested/menu1/menu1-1',
  name: 'Nested',
  meta: {
    title: '信息管理',
    icon: 'nested'
  },
  children: [
    {
      path: 'menu1',
      component: () => import('@/views/nested/menu1/index'), // Parent router-view
      name: 'Menu1',
      meta: { title: '网页模块' },
      redirect: '/nested/menu1/menu1-1',
      children: [
        {
          path: 'menu1-1',
          component: () => import('@/views/nested/menu1/menu1-1'),
          name: 'Menu1-1',
          meta: { title: '数据表格演示' }
        },
        {
          path: 'subject',
          name: 'Subject',
          component: () => import('@/views/nested/menu1/subject'),
          meta: { title: '学科列表' }
        },
        {
          path: 'teacher',
          component: () => import('@/views/nested/menu1/teacher'),
          name: 'MyTable',
          meta: { title: '小导师信息管理' }
        }
      ]
    },
    {
      path: 'menu2',
      name: 'Menu2',
      component: () => import('@/views/nested/menu2/index'),
      meta: { title: 'Menu 2' }
    }
  ]
}

export default nestedRouter
