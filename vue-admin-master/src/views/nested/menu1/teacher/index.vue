<template>
  <div style="padding:30px;">
    <div class="filter-container">
      <el-input v-model="listQuery.id" placeholder="id" style="width: 100px;" @keyup.enter.native="ReGetListById" />
      <el-button v-waves class="filter-item" style="margin-bottom: 0;margin-right: 5px;" type="primary" icon="el-icon-search" @click="ReGetListById">
        Search
      </el-button>
      <el-input v-model="listQuery.name" placeholder="姓名" style="width: 150px;" @keyup.enter.native="ReGetListByName" />
      <el-button v-waves class="filter-item" type="primary" style="margin-right: 5px;margin-bottom: 0" icon="el-icon-search" @click="ReGetListByName">
        Search
      </el-button>
      <el-select v-model="listQuery.college" class="filter-item" placeholder="学院" clearable style="width: 200px;margin-bottom: 0;" @change="ReGetListByCollege">
        <el-option v-for="item in collegeOptions" :key="item.id" :label="item.name" :value="item.name" />
      </el-select>
      <el-button type="primary" style="float: right" icon="el-icon-plus" @click="resetEditTemp">添加</el-button>
    </div>
    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      :default-sort="{prop: 'date', order: 'descending'}"
      border
      fit
      highlight-current-row
      style="width: 100%;"
    >
      <el-table-column label="ID" prop="id" sortable align="center">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="姓名" prop="name" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学号" prop="number" align="center">
        <template slot-scope="{row}">
          <span>{{ row.number }}</span>
        </template>
      </el-table-column>
      <el-table-column label="年级" prop="grade" align="center">
        <template slot-scope="{row}">
          <span>{{ row.grade }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学院" prop="college" align="center">
        <template slot-scope="{row}">
          <span>{{ row.college }}</span>
        </template>
      </el-table-column>
      <el-table-column label="专业" prop="major" align="center">
        <template slot-scope="{row}">
          <span>{{ row.major }}</span>
        </template>
      </el-table-column>
      <el-table-column label="QQ" prop="qq" align="center">
        <template slot-scope="{row}">
          <span>{{ row.qq }}</span>
        </template>
      </el-table-column>
      <el-table-column label="电话" prop="phone" align="center">
        <template slot-scope="{row}">
          <span>{{ row.phone }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学科" prop="subjects" align="center">
        <template slot-scope="{row}">
          <el-tag
            style="margin-bottom: 5px;"
            :type="row.subjects[0].name === 'C语言' ? 'success' : 'primary'"
            disable-transitions
          >{{ row.subjects[0].name }}</el-tag>
          <el-tag
            :type="row.subjects[1].name === '高等数学' ? 'primary' : 'success'"
            disable-transitions
          >{{ row.subjects[1].name }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" @click="handleEdit(row)">编辑</el-button>
          <el-button type="danger" size="mini" @click="handleDelete(row,$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="编辑" :visible.sync="dialogTableVisible">
      <el-form ref="editForm" :model="editTemp" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="姓名:" prop="name" style="width: 250px;">
          <el-input v-model="editTemp.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="学号:" prop="number" style="width: 250px;">
          <el-input v-model="editTemp.number" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="年级:" prop="grade">
          <el-select v-model="editTemp.grade" placeholder="请选择年级">
            <el-option v-for="item in gradeList" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="学院：" prop="college">
          <el-select v-model="editTemp.college" placeholder="请选择学院">
            <el-option v-for="item in collegeOptions" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="专业：" prop="major">
          <el-select v-model="editTemp.major" placeholder="请选择专业">
            <el-option v-for="item in majorList" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="QQ：" prop="qq" style="width: 250px">
          <el-input v-model="editTemp.qq" placeholder="请输入qq号码" />
        </el-form-item>
        <el-form-item label="电话：" prop="phone" style="width: 250px">
          <el-input v-model="editTemp.phone" placeholder="请输入电话号码" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogTableVisible = false">取消</el-button>
        <el-button type="primary" @click="handleSubmit">提交</el-button>
      </div>
    </el-dialog>
    <el-dialog title="添加" :visible.sync="addDataDialog">
      <el-form ref="addForm" :model="editTemp" :rules="rules" label-position="left" label-width="70px" style="width: 400px;margin-left: 50px">
        <el-form-item label="姓名:" prop="name" style="width: 250px;">
          <el-input v-model="editTemp.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="学号:" prop="number" style="width: 250px;">
          <el-input v-model="editTemp.number" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="年级:" prop="grade">
          <el-select v-model="editTemp.grade" placeholder="请选择年级">
            <el-option v-for="item in gradeList" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="学院：" prop="college">
          <el-select v-model="editTemp.college" placeholder="请选择学院">
            <el-option v-for="item in collegeOptions" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="专业：" prop="major">
          <el-select v-model="editTemp.major" placeholder="请选择专业">
            <el-option v-for="item in majorList" :key="item.id" :label="item.name" :value="item.name" />
          </el-select>
        </el-form-item>
        <el-form-item label="QQ：" prop="qq" style="width: 250px">
          <el-input v-model="editTemp.qq" placeholder="请输入qq号码" maxLength="15" type="text" show-word-limit />
        </el-form-item>
        <el-form-item label="电话：" prop="phone" style="width: 250px">
          <el-input v-model="editTemp.phone" placeholder="请输入电话号码" maxLength="11" type="text" show-word-limit />
        </el-form-item>
        <el-form-item label="志愿一：" prop="subjects" style="width: 200px;">
          <el-select v-model="editTemp.subjects[0].id" placeholder="请选择第一志愿">
            <el-option v-for="item in subjectList" v-show="item.id != editTemp.subjects[1].id" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="志愿二：" prop="subjects" style="width: 200px;">
          <el-select v-model="editTemp.subjects[1].id" placeholder="请选择第二志愿">
            <el-option v-for="item in subjectList" v-show="item.id != editTemp.subjects[0].id" :key="item.id" :label="item.name" :value="item.id" />
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="addDataDialog = false">取消</el-button>
        <el-button type="primary" @click="handleAdd">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import waves from '@/directive/waves'
import axios from 'axios' // waves directive
// import Pagination from '@/components/Pagination'
export default {
  name: 'MyTable',
  directives: { waves },
  defaultSort: {
    'prop': 'id',
    'order': 'descending'
  },

  data() {
    return {
      addDataDialog: false,
      deleteDialogVisible: false,
      dialogTableVisible: false,
      tableKey: 0,
      listLoading: true,
      list: [],
      subjectList: [],
      tagList: [
        {
          'type': 'primary'
        },
        {
          'type': 'success'
        },
        {
          'type': 'info'
        },
        {
          'type': 'warning'
        },
        {
          'type': 'danger'
        }
      ],
      listQuery: {
        page: 1,
        limit: 15,
        id: undefined,
        name: undefined,
        college: undefined
      },
      collegeOptions: [
        {
          'id': 1,
          'name': '计算机与信息学院'
        },
        {
          'id': 2,
          'name': '水利与环境学院'
        },
        {
          'id': 3,
          'name': '土木与建筑学院'
        },
        {
          'id': 4,
          'name': '电气与新能源学院'
        },
        {
          'id': 5,
          'name': '经济与管理学院'
        },
        {
          'id': 6,
          'name': '理学院'
        }
      ],
      editTemp: {
        'id': null,
        'name': '',
        'number': '',
        'grade': '',
        'college': '',
        'major': '',
        'qq': '',
        'phone': '',
        'subjects': [
          {
            'id': null
          },
          {
            'id': null
          }
        ]
      },
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
        number: [{ required: true, message: '请输入学号', trigger: 'blur' }],
        grade: [{ required: true, message: '请选择年级', trigger: 'blur' }],
        college: [{ required: true, message: '请输入学院', trigger: 'blur' }]
      },
      gradeList: [
        { 'id': 1, 'name': '大一' },
        { 'id': 2, 'name': '大二' },
        { 'id': 3, 'name': '大三' },
        { 'id': 4, 'name': '大四' }
      ],
      majorList: [
        {
          'id': 1,
          'name': '计算机科学与技术'
        },
        {
          'id': 2,
          'name': '物联网'
        },
        {
          'id': 3,
          'name': '数字媒体技术'
        },
        {
          'id': 4,
          'name': '大数据与数据科学'
        },
        {
          'id': 5,
          'name': '其他'
        }
      ]
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      /**
       * 获取所有小导师的信息
       */
      axios.get('http://localhost:8083/teacher/all')
        .then((res) => {
          console.log(res)
          this.list = res.data.data
        })
        .catch((error) => {
          console.log(error)
        })
      /**
       * 获取所有的学科信息
       */
      axios.get('http://localhost:8083/subject/all')
        .then((res) => {
          console.log(res)
          this.subjectList = res.data.data
          console.log(this.subjectList)
        })
        .catch((error) => {
          console.log(error)
        })
      setTimeout(() => {
        this.listLoading = false
      }, 1000)
    },
    resetEditTemp() {
      this.editTemp.subjects = [
        {
          'id': null
        },
        {
          'id': null
        }
      ]
      this.editTemp.phone = ''
      this.editTemp.qq = ''
      this.editTemp.major = ''
      this.editTemp.college = ''
      this.editTemp.grade = ''
      this.editTemp.number = ''
      this.editTemp.name = ''
      this.editTemp.id = null
      this.addDataDialog = true
    },
    ReGetListById(e) {
      const id = this.listQuery.id
      if (id === undefined || id === '') {
        this.getList()
      } else {
        console.log(e)
        this.listLoading = true
        axios.get('http://localhost:8083/teacher/' + id)
          .then((res) => {
            console.log(res)
            this.list = []
            this.list.push(res.data.data)
          })
          .catch((err) => {
            console.log(err)
          })
      }
      setTimeout(() => {
        this.listLoading = false
      }, 1000)
    },
    ReGetListByName(e) {
      const name = this.listQuery.name
      if (name === undefined || name === '') {
        this.getList()
      } else {
        this.listLoading = true
        axios.get('http://localhost:8083/teacher/name?' + 'name=' + name).then((res) => {
          console.log(res)
          this.list = res.data.data
        }).catch((error) => {
          console.log(error)
        })
      }
      setTimeout(() => {
        this.listLoading = false
      }, 1000)
    },
    ReGetListByCollege(e) {
      const name = this.listQuery.college
      if (name === undefined || name === '') {
        this.getList()
      } else {
        this.listLoading = true
        axios.get('http://localhost:8083/teacher/college?name=' + name)
          .then((res) => {
            console.log(res)
            this.list = res.data.data
          })
          .catch((error) => {
            console.log(error)
          })
        setTimeout(() => {
          this.listLoading = false
        }, 1000)
      }
    },
    sortChange(data) {
      const { prop, order } = data
      console.log('prop:', prop)
      console.log('order:', order)
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleEdit(row) {
      console.log(row)
      this.editTemp = Object.assign({}, row)
      console.log(this.editTemp)
      this.dialogTableVisible = true
    },
    handleSubmit() {
      console.log(this.editTemp)
      const data = this.editTemp
      axios.put('http://localhost:8083/teacher', data)
        .then((res) => {
          const code = res.data.code
          if (code === 5000) {
            this.$notify({
              title: '修改成功',
              message: '数据已经成功修改',
              type: 'success'
            })
          } else if (code === 4000) {
            this.$notify.error({
              title: '错误',
              message: '修改失败！出错了！'
            })
          }
          console.log(res)
          this.dialogTableVisible = false
          this.getList()
        })
    },
    handleDelete(row, index) {
      console.log(row)
      console.log(index)
      const id = row.id
      axios.delete('http://localhost:8083/teacher?id=' + id)
        .then((res) => {
          console.log(res)
          if (res.data.code === 4000) {
            this.$notify.error({
              title: '错误',
              message: '出错了!'
            })
          } else if (res.data.code === 5000) {
            this.$notify({
              title: '修改成功',
              message: '数据已经成功删除',
              type: 'success'
            })
          }
          this.getList()
        })
    },
    handleAdd() {
      console.log(this.editTemp)
      const data = this.editTemp
      axios.post('http://localhost:8083/teacher',data)
        .then((res) => {
          console.log(res)
          const code = res.data.code
          if (code === 5000) {
            this.$notify({
              title: '成功',
              message: '添加成功',
              type: 'success'
            })
          } else if (code === 4000) {
            this.$notify.error({
              title: '错误',
              message: '添加失败！出错了！'
            })
          }
          this.addDataDialog = false
          this.getList()
        })
    }
  }
}
</script>
<style>
.filter-container{
  padding-bottom: 10px;
}
.filter-container .filter-item{
  display: inline-block;
  vertical-align: middle;
}
</style>
