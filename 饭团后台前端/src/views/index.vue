<template>
  <div class="app-container" style="padding-top: 30px;">
    <el-row>
      <el-col :span="12" class="card-box">
        <el-card>
          <div slot="header"><span><i class="el-icon-pie-chart"></i> 订单数量统计</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <div ref="commandstats" style="height: 420px" />
          </div>
        </el-card>
      </el-col>

      <el-col :span="12" class="card-box">
        <el-card>
          <div slot="header"><span><i class="el-icon-odometer"></i> 餐厅店铺数量</span></div>
          <div class="el-table el-table--enable-row-hover el-table--medium">
            <div ref="usedmemory" style="height: 420px" />
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { getCache } from "@/api/monitor/cache";
import * as echarts from "echarts";

export default {
  name: "Cache",
  data() {
    return {
      // 统计命令信息
      commandstats: null,
      // 使用内存
      usedmemory: null,
      // cache信息
      cache: []
    }
  },
  mounted() {
    this.getList();
  },
  methods: {
    /** 查缓存询信息 */
    getList() {
        this.commandstats = echarts.init(this.$refs.commandstats, "macarons");
        this.commandstats.setOption({
          xAxis: {
              type: 'category',
              boundaryGap: false
            },
            yAxis: {
              type: 'value',
              boundaryGap: [0, '30%']
            },
            visualMap: {
              type: 'piecewise',
              show: false,
              dimension: 0,
              seriesIndex: 0,
              pieces: [
                {
                  gt: 1,
                  lt: 3,
                  color: 'rgba(0, 0, 180, 0.4)'
                },
                {
                  gt: 5,
                  lt: 7,
                  color: 'rgba(0, 0, 180, 0.4)'
                }
              ]
            },
            series: [
              {
                type: 'line',
                smooth: 0.6,
                symbol: 'none',
                lineStyle: {
                  color: '#5470C6',
                  width: 5
                },
                markLine: {
                  symbol: ['none', 'none'],
                  label: { show: false },
                  data: [{ xAxis: 1 }, { xAxis: 3 }, { xAxis: 5 }, { xAxis: 7 }]
                },
                areaStyle: {},
                data: [
                  ['2022-05-07', 200],
                  ['2022-06-07', 400],
                  ['2022-07-07', 555],
                  ['2022-08-07', 1400],
                  ['2022-09-07', 2000],
                  ['2022-10-07', 2400],
                  ['2022-11-07', 2800],
                  ['2022-12-07', 3800],
                  ['2023-01-07', 3400],
                  ['2023-02-07', 3100],
                  ['2023-03-07', 3400],
                  ['2023-04-07', 3100],
                ]
              }
            ]
        });
        this.usedmemory = echarts.init(this.$refs.usedmemory, "macarons");
        this.usedmemory.setOption({
          title: {
              text: '餐厅入驻商家数量',
              subtext: 'Fake Data'
            },
            tooltip: {
              trigger: 'axis'
            },
            legend: {
              data: ['一餐厅', '二餐厅']
            },
            toolbox: {
              show: true,
              feature: {
                dataView: { show: true, readOnly: false },
                magicType: { show: true, type: ['line', 'bar'] },
                restore: { show: true },
                saveAsImage: { show: true }
              }
            },
            calculable: true,
            xAxis: [
              {
                type: 'category',
                // prettier-ignore
                data: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
              }
            ],
            yAxis: [
              {
                type: 'value'
              }
            ],
            series: [
              {
                name: '一餐厅',
                type: 'bar',
                data: [
                  15, 10, 12, 20, 21, 17, 15, 16, 24, 10, 14, 12
                ],
                markPoint: {
                  data: [
                    { type: 'max', name: 'Max' },
                    { type: 'min', name: 'Min' }
                  ]
                },
                markLine: {
                  data: [{ type: 'average', name: 'Avg' }]
                }
              },
              {
                name: '二餐厅',
                type: 'bar',
                data: [
                  8, 11, 17, 20, 21, 14, 12, 17, 13, 18, 21, 24
                ],
                markPoint: {
                  data: [
                    { name: 'Max', value: 182.2, xAxis: 7, yAxis: 183 },
                    { name: 'Min', value: 2.3, xAxis: 11, yAxis: 3 }
                  ]
                },
                markLine: {
                  data: [{ type: 'average', name: 'Avg' }]
                }
              }
            ]
        });
    },
  }
};
</script>
