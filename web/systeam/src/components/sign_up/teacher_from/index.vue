<!--  -->
<template>
  <div class="continer">
    <froms
      :titleName="titleName"
      :tipProject="tipProject"
    />
  </div>
</template>

<script>
import { ref } from '@vue/reactivity'
import froms from '../base/index.vue'
export default {
  name: '',
  components: { froms },
  setup () {
    const titleName = ref('导师')
    const tipProject = ref('应聘')
    return { titleName, tipProject }
  }
}
</script>
<style lang='scss' scoped>
</style>
