<!--  -->
<template>
  <div class="container">
    <component :is="showFrom"></component>
  </div>
</template>

<script>
import teacherfrom from './teacher_from/index.vue'
import studentfrom from './student_from/index.vue'
import { ref, watch } from 'vue'
export default {
  name: '',
  components: { teacherfrom, studentfrom },
  props: ['showFromId'],
  setup (props, contxt) {
    const showFrom = ref('teacherfrom')
    watch(
      () => props.showFromId,
      (val, prevVal) => {
        showFrom.value = val
      }
    )
    return { showFrom }
  }
}
</script>
<style lang='scss' scoped>
.container {
  width: 100%;
  height: 100%;
  position: relative;
}
</style>
