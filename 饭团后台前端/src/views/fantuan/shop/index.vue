<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="uuid" prop="shopId">
        <el-input
          v-model="queryParams.shopId"
          placeholder="请输入uuid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入店铺名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <!-- <el-form-item label="店铺图" prop="img">
        <el-input
          v-model="queryParams.img"
          placeholder="请输入店铺图"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item> -->
      <el-form-item label="营业时间" prop="openTime">
        <el-input
          v-model="queryParams.openTime"
          placeholder="请输入营业时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺公告" prop="notice">
        <el-input
          v-model="queryParams.notice"
          placeholder="请输入店铺公告"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商铺电话" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入商铺电话"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商家id" prop="businessId">
        <el-input
          v-model="queryParams.businessId"
          placeholder="请输入商家id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第几餐厅" prop="restaurant">
        <el-input
          v-model="queryParams.restaurant"
          placeholder="请输入第几餐厅"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="团购资格" prop="groupFlag">
        <el-input
          v-model="queryParams.groupFlag"
          placeholder="设置团购资格"
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
          v-hasPermi="['fantuan:shop:add']"
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
          v-hasPermi="['fantuan:shop:edit']"
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
          v-hasPermi="['fantuan:shop:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fantuan:shop:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="shopList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="uuid" align="center" prop="shopId" />
      <el-table-column label="店铺名" align="center" prop="name" />
      <el-table-column label="店铺图" align="center" prop="img" >
        <template slot-scope="{row}">
          <img :src="row.img" alt="" width="100">
        </template>
      </el-table-column>
      <el-table-column label="营业时间" align="center" prop="openTime" />
      <el-table-column label="店铺公告" align="center" prop="notice" />
      <el-table-column label="商铺电话" align="center" prop="phone" />
      <el-table-column label="商家id" align="center" prop="businessId" />
      <el-table-column label="第几餐厅" align="center" prop="restaurant" />
      <el-table-column label="店铺状态" align="center" prop="status" />
      <el-table-column label="是否有团购资格" align="center" prop="groupFlag" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fantuan:shop:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fantuan:shop:remove']"
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

    <!-- 添加或修改店铺管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="uuid" prop="shopId">
          <el-input v-model="form.shopId" :disabled="true" placeholder="请输入uuid" />
        </el-form-item>
        <el-form-item label="店铺名" prop="name">
          <el-input v-model="form.name" placeholder="请输入店铺名" />
        </el-form-item>
      <!--  <el-form-item label="店铺图" prop="img">
          <el-input v-model="form.img" placeholder="请输入店铺图" />
        </el-form-item> -->
        <el-form-item label="营业时间" prop="openTime">
          <el-input v-model="form.openTime" placeholder="请输入营业时间" />
        </el-form-item>
        <el-form-item label="店铺公告" prop="notice">
          <el-input v-model="form.notice" placeholder="请输入店铺公告" />
        </el-form-item>
        <el-form-item label="商铺电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入商铺电话" />
        </el-form-item>
        <el-form-item label="商家id" prop="businessId">
          <el-input v-model="form.businessId" placeholder="请输入商家id" />
        </el-form-item>
        <el-form-item label="第几餐厅" prop="restaurant">
          <el-input v-model="form.restaurant" placeholder="请输入第几餐厅" />
        </el-form-item>
        <el-form-item label="是否有团购资格" prop="groupFlag">
          <el-input v-model="form.groupFlag" placeholder="请输入是否有团购资格" />
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
import { listShop, getShop, delShop, addShop, updateShop } from "@/api/fantuan/shop";

export default {
  name: "Shop",
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
      // 店铺管理表格数据
      shopList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopId: null,
        name: null,
        img: null,
        openTime: null,
        notice: null,
        phone: null,
        businessId: null,
        restaurant: null,
        status: null,
        groupFlag: null
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
    /** 查询店铺管理列表 */
    getList() {
      this.loading = true;
      listShop(this.queryParams).then(response => {
        this.shopList = response.rows;
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
        shopId: null,
        name: null,
        img: null,
        openTime: null,
        notice: null,
        phone: null,
        businessId: null,
        restaurant: null,
        status: null,
        groupFlag: null
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
      this.title = "添加店铺管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getShop(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改店铺管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateShop(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addShop(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除店铺管理编号为"' + ids + '"的数据项？').then(function() {
        return delShop(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fantuan/shop/export', {
        ...this.queryParams
      }, `shop_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
