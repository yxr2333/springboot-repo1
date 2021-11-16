<!-- npm install v3-carousel -->
<template>
  <div class="banners">
    <Carousel
      :autoplay="false"
      :duration="2000"
      :initIndex="2"
      :direction="true"
      directionMode="always"
      :directionSize="20"
      directionColor="skyblue"
      :indicator="true"
      indicatorMode="always"
      indicatorColor="white"
      indicatorActiveColor="skyblue"
      @before-moving="beforeMoving"
      @after-moving="afterMoving"
    >
      <CarouselItem
        v-for="(item, index) in data"
        :key="index"
        :idx="index"
      >
        <img :src="item" />
      </CarouselItem>
    </Carousel>
  </div>
</template>

<script>
import { defineComponent, reactive, toRefs } from 'vue'
export default defineComponent({
  name: 'App',
  setup () {
    const state = reactive({
      data: [
        'https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00693-2745.jpg',
        'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2190440116,1436403087&fm=26&gp=0.jpg',
        'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3593656793,3600757928&fm=26&gp=0.jpg'
      ]
    })
    const beforeMoving = dire => {
      console.log('before', dire)
    }
    const afterMoving = obj => {
      console.log('before', obj)
    }
    return {
      ...toRefs(state),
      beforeMoving,
      afterMoving
    }
  }
})
</script>

<style lang="scss">
.banners {
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translate(-50%, -20%);
  width: 80%;
  height: 60%;
  .direction-container {
    .direction {
      .prev {
        i {
          position: absolute;
          left: 50%;
          transform: translateX(-50%);
        }
      }
      .next {
        i {
          position: absolute;
          left: 50%;
          transform: translateX(-50%);
        }
      }
    }
  }
}
</style>
