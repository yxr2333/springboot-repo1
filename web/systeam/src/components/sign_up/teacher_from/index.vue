<!--  -->
<template>
  <div class="from_container">2
    <el-form
      ref="ruleFrom"
      :model="ruleForm"
      :rules="rules"
    >
      <el-form-item
        label="姓名"
        label-width=".5rem"
        prop="name"
        v-model="ruleForm.name"
      >
        <el-input></el-input>
      </el-form-item>
      <el-form-item
        label="学号"
        label-width=".5rem"
      >
        <el-input></el-input>
      </el-form-item>
      <!-- <el-form-item
        label="年纪"
        label-width=".5rem"
      >
        <el-select>
          <el-option>大一</el-option>
          <el-option>大二</el-option>
          <el-option>大三</el-option>
          <el-option>大四</el-option>
        </el-select>
      </el-form-item> -->
      <el-form-item
        label="专业"
        label-width=".5rem"
      >
        <el-cascader></el-cascader>
      </el-form-item>
      <el-form-item
        label="电话"
        label-width=".5rem"
      >
        <el-input label="phone"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">Create</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { reactive, toRefs } from '@vue/reactivity'
export default {
  name: '',
  components: {},
  setup () {
    const ruleCont = reactive({
      ruleForm: { name: '' },
      rules: {
        name: [
          {
            required: true,
            message: 'Please input Activity name',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 5,
            message: 'Length should be 3 to 5',
            trigger: 'blur'
          }
        ]
      }
    })
    return { ...toRefs(ruleCont) }
  }
}
</script>
<style lang='scss' scoped>
.from_container {
  position: absolute;
  top: 10%;
  left: 50%;
  transform: translateX(-50%);
  width: 80%;
  height: 80%;
  .el-form {
    width: 100%;
    .el-form-item {
      width: 100%;
      .el-input {
        width: 40%;
      }
    }
  }
}
</style>
