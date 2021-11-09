<template>
  <div>
    <div class="filter-container">
      <el-input v-model="listQuery.name" placeholder="请输入名称" style="width: 150px;margin-right: 5px;"></el-input>
      <el-button v-waves type="primary" class="filter-item" icon="el-icon-edit" style="margin-bottom: 0" @click="handleAddOne">添加</el-button>
    </div>
    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="tableData"
      :default-sort="defaultSort"
      style="width: 80%;"
      fit
      border
    >
      <el-table-column type="expand">
        <template slot-scope="{row}">
          <el-form label-position="left" class="demo-table-expand">
            <el-form-item label="编号">
              <span>{{ row.id }}</span>
            </el-form-item>
            <el-form-item label="名称">
              <span>{{ row.name }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column label="编号" prop="id" sortable align="center">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学科名称" prop="subjectName" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="{row, $index}">
          <el-button
            size="mini"
            @click="handleEdit($index, row)">编辑</el-button>
          <el-button
            size="mini"
            type="danger"
            @click="handleDelete($index, row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="编辑" :visible.sync="editDialogVisible">
      <el-form :model="editData">
        <el-form-item label="名称">
          <el-input v-model="editData.name" placeholder="请输入名称"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="editDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleUpdate">确定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<style>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
<script>
import axios from 'axios'
import waves from '@/directive/waves'
axios.defaults.baseURL = 'http://localhost:8083'
export default {
  name: 'Subject',
  directives: { waves },

  data() {
    return {
      defaultSort: {
        'prop': 'id',
        'order': 'ascending'
      },
      tableKey: 2,
      tableData: [],
      listLoading: true,
      editDialogVisible: false,
      deleteDialogVisible: false,
      editData: {
        'id': null,
        'name': null
      },
      listQuery: {
        'name': null
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      axios.get('/subject/all')
        .then((res) => {
          console.log(res)
          if (res.data.code === 5000) {
            this.tableData = res.data.data
            setTimeout(() => {
              this.listLoading = false
            }, 1000)
          } else {
            this.$notify.error({
              message: '获取失败！',
              title: 'error'
            })
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },
    handleEdit(index, row) {
      console.log(row)
      this.editData.name = row.name
      this.editData.id = row.id
      this.editDialogVisible = true
    },
    handleUpdate() {
      const data = this.editData
      axios.put('/subject', data)
        .then((res) => {
          const code = res.data.code
          if (code === 4000) {
            this.$notify.error({
              message: '更新错误',
              title: 'error'
            })
          } else {
            this.$notify({
              title: 'success',
              message: '提交成功',
              type: 'success'
            })
          }
          this.editDialogVisible = false
          this.getList()
        })
    },
    handleDelete(index, row) {
      const id = row.id
      axios.delete('/subject?id=' + id)
        .then((res) => {
          const code = res.data.code
          if (code === 4000) {
            this.$notify.error({
              message: '删除失败',
              title: 'error'
            })
          } else {
            this.$notify({
              title: 'success',
              message: '删除成功',
              type: 'success'
            })
          }
          this.getList()
        })
    },
    handleAddOne() {
      const data = this.listQuery
      axios.post('/subject', data)
        .then((res) => {
          const code = res.data.code
          if (code === 4000) {
            this.$notify.error({
              message: '添加失败',
              title: 'error'
            })
          } else {
            this.$notify({
              title: 'success',
              message: '添加成功',
              type: 'success'
            })
          }
          this.getList()
        })
    }
  }
}
</script>
