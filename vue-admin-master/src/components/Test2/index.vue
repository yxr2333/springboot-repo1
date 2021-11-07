<template>
    <div id="myChart" ref="chart" :style="{width: width,height: height}"></div>
</template>

<script>

import resize from "./mixins/resize"
import $ from 'jquery'
let echarts = require("echarts/lib/echarts");
require("echarts/lib/chart/bar");
require("echarts/lib/component/tooltip");
require("echarts/lib/component/title");
import request from '../../utils/request.js'


// import resize from '@/componets/Charts'
export default {
    name: "Hello",
    mixins: [resize],
    props: {
        className: {
            type: String,
            default: 'chart'
        },
        width: {
            type: String,
            default: '100%'
        },
        height: {
            type: String,
            default: '300px'
        }
    },
    data(){
        return {
            woman: 15,
            man: 1,
        }
    },
    mounted(){
        this.initCharts();
    },
    methods:{
        initCharts(){
            this.chart = echarts.init(this.$el);
            this.get();

            this.setOptions();
        },
        get(){
            $.ajax({
                type: "GET",
                url: "http://localhost:8081/user/sex",
                success: function (res) {
                    console.log(res)
                    console.log(res.data.woman)
                    this.woman = res.data.woman
                    this.man = res.data.man
                    console.log("woman = ",this.woman)
                    console.log("man = ",this.man)
                }
            });
        },
        setOptions(){
            console.log("woman2 = ",this.woman)
            console.log("man2 = ",this.man)
            this.chart.setOption({
                title: {
                    text: '某站点用户访问来源',
                    subtext: '纯属虚构',
                    left: 'center'
                },
                tooltip: {
                    trigger: 'item'
                },
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '50%',
                        data: [
                            {value: this.man, name: '男'},
                            {value: this.woman, name:'女'},
                        ],
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            });
        }
    },
}
</script>
<style >

</style>