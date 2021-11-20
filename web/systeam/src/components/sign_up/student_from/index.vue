<!--  -->
<template>
  <div class="from_container">
    <el-form
      ref="ruleFrom"
      :model="ruleForm"
      :rules="rules"
    >
      <el-form-item
        label="姓名"
        label-width=".8rem"
        prop="name"
        v-model="ruleForm.name"
      >
        <el-input></el-input>
      </el-form-item>
      <el-form-item
        label="学号"
        label-width=".8rem"
      >
        <el-input></el-input>
      </el-form-item>
      <el-form-item
        label="学院"
        label-width=".8rem"
      >
        <el-cascader></el-cascader>
      </el-form-item>
      <el-form-item
        label="专业"
        label-width=".8rem"
      >
        <el-cascader></el-cascader>
      </el-form-item>
      <el-form-item
        label="电话"
        label-width=".8rem"
      >
        <el-input label="phone"></el-input>
      </el-form-item>
      <el-form-item
        label="应聘科目"
        label-width=".8rem"
      >
        <el-card>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
          <el-checkbox>1</el-checkbox>
        </el-card>

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
  width: 6rem;
  .el-form {
    width: 100%;
    .el-form-item {
      width: 100%;
      .el-input {
        width: 70%;
      }
    }
  }
}
</style>
