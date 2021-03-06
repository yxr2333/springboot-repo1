/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const nestedRouter = {
  path: '/web',
  component: Layout,
  name: 'Nested',
  meta: {
    title: '前端网页数据管理',
    icon: 'nested'
  },
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
    },
    {
      path: 'student',
      component: () => import('@/views/nested/menu1/student'),
      name: 'Student',
      meta: { title: '学员列表' }
    }
  ]
  // children: [
  //   {
  //     path: 'menu1',
  //     component: () => import('@/views/nested/menu1/index'), // Parent router-view
  //     name: 'Menu1',
  //     meta: { title: '网页模块' },
  //     redirect: '/nested/menu1/menu1-1',
  //     children: [
  //
  //     ]
  //   },
  //   {
  //     path: 'class',
  //     name: 'Menu2',
  //     component: () => import('@/views/nested/menu2/index'),
  //     meta: { title: '班级管理模块' },
  //     children: [
  //       {
  //         path: 'teacher',
  //         component: () => import('@/views/nested/menu2/teacher'),
  //         name: 'Teacher',
  //         meta: { title: '小导师列表' }
  //       },
  //       {
  //         path: 'student',
  //         component: () => import('@/views/nested/menu2/student'),
  //         name: 'Student',
  //         meta: { title: '学员列表' }
  //       },
  //       {
  //         path: 'class',
  //         component: () => import('@/views/nested/menu2/class'),
  //         name: 'Class',
  //         meta: { title: '班级列表' }
  //       }
  //     ]
  //   }
  // ]
}

export default nestedRouter
