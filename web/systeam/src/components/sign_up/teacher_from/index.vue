<!--  -->
<template>

  <div class="from_container">
    <h6>小导师报名</h6>
    <el-form
      ref="ruleFrom"
      :model="ruleForm"
      :rules="rules"
    >
      <el-form-item
        label="姓名"
        label-width=".8rem"
        prop="name"
      >
        <el-input v-model="ruleForm.name"></el-input>
      </el-form-item>
      <el-form-item
        label="学号"
        label-width=".8rem"
        prop="number"
      >
        <el-input v-model="ruleForm.number"></el-input>
      </el-form-item>

      <el-form-item
        label="学院"
        label-width=".8rem"
        prop="regionOne"
      >
        <el-select v-model="ruleForm.regionOne">
          <el-option
            label="1"
            value="1"
          ></el-option>
          <el-option
            label="1"
            value="1"
          ></el-option>
          <el-option
            label="1"
            value="1"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item
        label="专业"
        label-width=".8rem"
        prop="regionTwo"
      >
        <el-select v-model="ruleForm.regionTwo">
          <el-option
            label="1"
            value="1"
          ></el-option>
          <el-option
            label="1"
            value="1"
          ></el-option>
          <el-option
            label="1"
            value="1"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item
        label="年级"
        label-width=".8rem"
      >
        <el-checkbox-group
          v-model="ruleForm.gropitem"
          :max="1"
        >
          <el-checkbox-button
            v-for="item in cityOptions"
            :key="item"
            :label="item"
          >{{item}}</el-checkbox-button>
        </el-checkbox-group>

      </el-form-item>
      <el-form-item
        label="电话"
        label-width=".8rem"
        prop="phone"
      >
        <el-input v-model="ruleForm.phone"></el-input>
      </el-form-item>
      <el-form-item
        label="QQ"
        label-width=".8rem"
        prop="qq"
      >
        <el-input v-model="ruleForm.qq"></el-input>
      </el-form-item>
      <el-form-item
        label="报名科目"
        label-width=".8rem"
      >
        <el-checkbox-group
          class="subject"
          v-model="ruleForm.gropitems"
          :max="2"
          :min="1"
        >
          <el-checkbox
            v-for="item in cityOptions"
            :key="item"
            :label="item"
          >{{item}}</el-checkbox>
        </el-checkbox-group>

      </el-form-item>
      <el-form-item class="buttons">
        <el-button
          type="primary"
          @click="handleFrom"
        >Create</el-button>
        <el-button>Create</el-button>
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
    const cityOptions = ['大一', '大二', '大三', '大四']
    const ruleCont = reactive({
      ruleForm: {
        name: '',
        number: '',
        regionOne: '',
        regionTwo: '',
        phone: '',
        qq: '',
        gropitem: [],
        gropitems: []
      },
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
        ],
        number: [
          {
            required: true,
            message: 'Please input Activity Student number',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 5,
            message: 'Length should be 3 to 5',
            trigger: 'blur'
          }
        ],
        regionOne: [
          {
            required: true,
            message: 'Please select Activity zone',
            trigger: 'change'
          }
        ],
        regionTwo: [
          {
            required: true,
            message: 'Please select Activity zone',
            trigger: 'change'
          }
        ],
        phone: [
          {
            required: true,
            message: 'Please input Activity phone',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 5,
            message: 'Length should be 3 to 5',
            trigger: 'blur'
          }
        ],
        qq: [
          {
            required: true,
            message: 'Please input Activity qq',
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
    const handleFrom = () => {
      console.log(ruleCont.ruleForm)
    }
    return { ...toRefs(ruleCont), cityOptions, handleFrom }
  }
}
</script>
<style lang='scss' scoped>
.from_container {
  position: absolute;
  top: 4%;
  left: 50%;
  transform: translateX(-50%);
  width: 6rem;
  h6 {
    width: 1.3rem;
    text-align: right;
    font-size: 0.2rem;
    margin: 0;
    margin-bottom: 0.2rem;
  }
  .el-form {
    width: 100%;
    .el-form-item {
      width: 100%;
      position: relative;
      .el-input {
        width: 70%;
      }
      .major {
        display: inline-block;
        width: 0.8rem;
        box-sizing: border-box;
        padding-right: 0.12rem;
        text-align: right;
        font-size: 0.14rem;
        color: #606266;
      }
      .subject {
        padding-left: 0.1rem;
        overflow: auto;
        height: 1rem;
        background-color: #e4e7ed;
      }
    }
    .buttons {
      position: absolute;
      bottom: -0.7rem;
      left: 56%;
      transform: translateX(-43%);
      .el-button {
        margin-right: 0.1rem;
      }
    }
  }
}
</style>
