<!--  -->
<template>
  <div class="home">
    <div class="home_container">
      <el-menu class="tabList">
        <div class="tab_head">
          <el-avatar :size="80"></el-avatar>
        </div>
        <el-menu-item
          index="1"
          @click="handleIntroCont('introduct')"
        ><span>简介</span></el-menu-item>
        <el-sub-menu index="2">
          <template #title>
            <span>报名</span>
          </template>
          <el-menu-item
            index="1-1"
            @click="handleIntroCont('signUp','teacherfrom')"
            class="smallerTeacher"
          >小导师报名</el-menu-item>
          <el-menu-item
            index="1-2"
            @click="handleIntroCont('signUp','studentfrom')"
          >小学员报名</el-menu-item>
        </el-sub-menu>
        <el-menu-item
          index="3"
          @click="handleIntroCont('notice')"
        ><span>通知</span></el-menu-item>
      </el-menu>
      <div class="tabContent">
        <component
          :is="activeStr"
          :showFromId="showFromId"
        ></component>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import introduct from '../components/introduct/index.vue'
import notice from '../components/notice/index.vue'
import signUp from '../components/sign_up/index.vue'
export default {
  name: 'Home',
  components: { introduct, notice, signUp },
  setup () {
    const activeStr = ref('introduct')
    const showFromId = ref('')
    const handleIntroCont = (n, b) => {
      activeStr.value = n
      if (b) {
        showFromId.value = b
      }
    }
    return { handleIntroCont, activeStr, showFromId }
  }
}
</script>
<style lang='scss' scoped>
.home {
  width: 100vw;
  height: 100vh;
  &_container {
    width: 100%;
    height: 100%;
    .tabList {
      float: left;
      width: 2rem;
      height: 100%;
      border-right: 0.01rem solid #e4e7ed;
      box-sizing: border-box;
      .tab_head {
        width: 100%;
        height: 20%;
        border-bottom: 0.01rem solid #e4e7ed;
        position: relative;
        .el-avatar {
          position: absolute;
          top: 30%;
          left: 50%;
          transform: translateX(-50%);
        }
      }
      .el-menu-item {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 0.5rem;
        border-bottom: 0.01rem solid #e4e7ed;
        span {
          font-size: 0.18rem;
        }
      }
      .el-sub-menu__title {
        span {
          width: 100%;
          height: 100%;
          font-size: 0.18rem;
          padding: 0 0.2rem;
          text-align: center;
          margin: 0 -0.2rem;
          border-bottom: 0.01rem solid #e4e7ed;
        }
      }
      .smallerTeacher {
        border-top: 0.01rem solid #e4e7ed;
      }
    }
    .tabContent {
      float: left;
      width: calc(100vw - 2rem);
      height: 100%;
    }
  }
}
</style>
