<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="uuid" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入uuid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户外键" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户外键"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家外键" prop="businessId">
        <el-input
          v-model="queryParams.businessId"
          placeholder="请输入商家外键"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="原价格" prop="priceBegin">
        <el-input
          v-model="queryParams.priceBegin"
          placeholder="请输入原价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="优惠后价格" prop="priceEnd">
        <el-input
          v-model="queryParams.priceEnd"
          placeholder="请输入优惠后价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否为团购" prop="isGroup">
        <el-input
          v-model="queryParams.isGroup"
          placeholder="请输入是否为团购"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单编号" prop="orderNumber">
        <el-input
          v-model="queryParams.orderNumber"
          placeholder="请输入订单编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="下单时间" prop="orderTime">
        <el-date-picker clearable
          v-model="queryParams.orderTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择下单时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="商品信息" prop="goodsInfo">
        <el-input
          v-model="queryParams.goodsInfo"
          placeholder="请输入商品信息"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款人姓名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入付款人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['fantuan:order:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['fantuan:order:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['fantuan:order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fantuan:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="uuid" align="center" prop="orderId" />
      <el-table-column label="用户外键" align="center" prop="userId" />
      <el-table-column label="商家外键" align="center" prop="businessId" />
      <el-table-column label="原价格" align="center" prop="priceBegin" />
      <el-table-column label="优惠后价格" align="center" prop="priceEnd" />
      <el-table-column label="订单状态" align="center" prop="status" />
      <el-table-column label="是否为团购" align="center" prop="isGroup" />
      <el-table-column label="订单编号" align="center" prop="orderNumber" />
      <el-table-column label="下单时间" align="center" prop="orderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品信息" align="center" prop="goodsInfo" />
      <el-table-column label="付款人姓名" align="center" prop="userName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fantuan:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fantuan:order:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改订单管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="uuid" prop="orderId">
          <el-input v-model="form.orderId" placeholder="请输入uuid" :disabled="true"/>
        </el-form-item>
        <el-form-item label="用户外键" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户外键" />
        </el-form-item>
        <el-form-item label="商家外键" prop="businessId">
          <el-input v-model="form.businessId" placeholder="请输入商家外键" />
        </el-form-item>
        <el-form-item label="原价格" prop="priceBegin">
          <el-input v-model="form.priceBegin" placeholder="请输入原价格" />
        </el-form-item>
        <el-form-item label="优惠后价格" prop="priceEnd">
          <el-input v-model="form.priceEnd" placeholder="请输入优惠后价格" />
        </el-form-item>
        <el-form-item label="是否为团购" prop="isGroup">
          <el-input v-model="form.isGroup" placeholder="请输入是否为团购" />
        </el-form-item>
        <el-form-item label="订单编号" prop="orderNumber">
          <el-input v-model="form.orderNumber" placeholder="请输入订单编号" />
        </el-form-item>
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable
            v-model="form.orderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="商品信息" prop="goodsInfo">
          <el-input v-model="form.goodsInfo" placeholder="请输入商品信息" />
        </el-form-item>
        <el-form-item label="付款人姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入付款人姓名" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/fantuan/order";

export default {
  name: "Order",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 订单管理表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        userId: null,
        businessId: null,
        priceBegin: null,
        priceEnd: null,
        status: null,
        isGroup: null,
        orderNumber: null,
        orderTime: null,
        goodsInfo: null,
        userName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询订单管理列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        orderId: null,
        userId: null,
        businessId: null,
        priceBegin: null,
        priceEnd: null,
        status: null,
        isGroup: null,
        orderNumber: null,
        orderTime: null,
        goodsInfo: null,
        userName: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加订单管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrder(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除订单管理编号为"' + ids + '"的数据项？').then(function() {
        return delOrder(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fantuan/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
