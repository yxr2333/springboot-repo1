# 一、 父传子

```js
父组件
<div class="tabContent">
    <component
      :is="activeStr"
      :showFromId="showFromId"
    ></component>
</div>

子组件 接受父组件的数据(props)并监听该数据
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
```
