<!--  -->
<template>
  <div class="container">
    <Banners />
    <div class="introduct_text">
      <strong>简介内容</strong>
      <div class="text_content">
        <textarea
          rows="3"
          readonly
        >重庆大学党委教师工作部于2017年11月30日成立，正处级建制，与党委宣传部合署办公，设部长1名（由宣传部部长兼任），专职副部长1名，是学校党委领导下的主管教师思想政治工作和师德师风建设的职能部门。下设师德师风建设办公室，专职开展教师师德师风建设工作。</textarea>
      </div>
    </div>
  </div>
</template>

<script>
import Banners from './banner/index.vue'
export default {
  name: 'Banner',
  components: { Banners },
  setup () {
    return {}
  }
}
</script>
<style lang='scss' scoped>
.container {
  width: 100%;
  height: 100%;
  position: relative;
  .introduct_text {
    display: flex;
    flex-direction: column;
    position: absolute;
    top: 75%;
    left: 50%;
    transform: translate(-50%);
    width: 80%;
    strong {
      font-size: 0.2rem;
    }
    .text_content {
      width: 100%;
      textarea {
        width: 100% !important;
        height: 1.2rem;
        padding: 0.1rem 0;
        resize: none;
        font-size: 0.17rem;
        border: none;
        outline: none;
      }
    }
  }
}
</style>
