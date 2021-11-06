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
      <el-select v-model="listQuery.college" class="filter-item" placeholder="学院" clearable style="width: 200px;margin-bottom: 0;">
        <el-option v-for="item in collegeOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" style="margin-right: 5px;margin-bottom: 0" icon="el-icon-search" @click="ReGetListByCollege">
        Search
      </el-button>
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
    </el-table>
  </div>
</template>
<script>
import waves from '@/directive/waves'
import axios from 'axios' // waves directive
// import Pagination from '@/components/Pagination'
export default {
  name: 'MyTable',
  directives: { waves },
  tableKey: 0,
  defaultSort: {
    'prop': 'id',
    'order': 'descending'
  },
  data() {
    return {
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
        '计算机与信息学院',
        '水利与环境学院',
        '土木与建筑学院',
        '电气与新能源学院',
        '机械与材料学院',
        '经济与管理学院',
        '理学院',
        '医学院',
        '化学与生命科学学院',
        '文学与传媒学院',
        '田家炳教育学院',
        '马克思主义学院',
        '外国语学院'
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
        })
        .catch((error) => {
          console.log(error)
        })
      setTimeout(() => {
        this.listLoading = false
      }, 1000)
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
