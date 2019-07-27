<template>
  <section>
    <el-container>
      <el-header>
        <【Lname】Search :search="search" :filters="filters" :add="add" :killSelection="killSelection"/>
      </el-header>
      <el-main>
        <el-table :data="sheet.rows" highlight-current-row v-loading="sheet.loading" stripe="stripe" border="border"
                  @sort-change="sortChange" style="width: 100%;" max-height="690" :row-style="tableRowStyle">
            <el-table-column type="selection" width="55"/>
【tableColumn】
          <el-table-column prop="createTime" label="时间" width="200" align="center" sortable="sortable"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-icon name="time"></el-icon>
              <span style="margin-left: 10px">{{ formatDate(scope.row.createTime) }}</span>
            </template>
          </el-table-column>

          <el-table-column label="操作" fixed="right" width="120" align="center" :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-dropdown @command="handleCommand">
           <span class="el-dropdown-link">
              <el-button size="small" type="text">更多<i class="el-icon-arrow-down el-icon--right"></i></el-button>
          </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item :command="{'method':'show【Uname】','args':scope.row}">编辑</el-dropdown-item>
                  <el-dropdown-item :command="{'method':'kill【Uname】','args':scope.row.id}">删除</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </template>
          </el-table-column>
        </el-table>
      </el-main>
      <lsz-pagination :getList="getList" :sheet="sheet"/>
    </el-container>

    <【Uname】Edit ref="【Lname】Edit" :search="search"/>
  </section>
</template>

<script>
  import LszPagination from '@/components/common/lsz-pagination.vue';
  import 【Uname】Search from './【Uname】Search.vue';
  import 【Uname】Edit from './【Uname】Edit.vue';

  let data = () => {
    return {
      filters: {},
      sheet: {
        rows: [],
        total: 0,
        pageNum: 1,
        pageSize: 20,
        sort: 'createTime',
        order:'desc',
        loading: false
      },
    }
  }
  let getList = function () {
    let param = {
      pageNum: this.sheet.pageNum,
      pageSize: this.sheet.pageSize,
      sort: this.sheet.sort,
      order: this.sheet.order,
      query: this.filters
    }
    this.sheet.loading = true
    this.$http.post('/【Lname】Controller/get【Uname】List', param).then(res => {

      let response = res.data.data;

      this.sheet.total = response.total
      this.sheet.rows = response.content
      this.sheet.loading = false
    }).catch(() => this.sheet.loading = false)
  }

  export default {
    data: data,
    components: {
      LszPagination,
      【Uname】Search,
      【Uname】Edit,
    },
    methods: {
      search: function () {
        this.sheet.pageNum = 1
        this.getList()
      },
      handleCommand: function (param) {
        this[param.method](param.args)
      },
      tableRowStyle({row, rowIndex}) {
        if (row.color){
          return 'color: ' + row.color;
        }
      },
        killSelection: function () {
            let rows = this.$refs.multipleTable.store.states.selection;
            if (rows && rows.length > 0) {
                let arr = [];
                for (let row of rows) {
                    arr.push(row.id);
                }
                this.kill【Uname】(arr.join(","));
            }
        },
      kill【Uname】: function (row) {
        let vm = this;
        vm.$confirm('是否确认提交?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          vm.$http.post('/【Lname】Controller/delete【Uname】' , {id:row.id}).then(res => {
            if (!res.data.success) {
              vm.$message({
                showClose: true,
                message: res.data.msg,
                type: 'error'
              });
              return
            }
            vm.$message({
              type: 'success',
              message: '保存成功!'
            })
            this.search();
          })
        }).catch(() => {

        })
      },
      show【Uname】: function (row) {
        this.$refs.【Lname】Edit.show(row);
      },
      add: function () {
        this.$refs.【Lname】Edit.showAdd();
      },
      formatDate: function (d, format) {
        if(!d){
          return "";
        }
        if (!format) {
          format = 'YYYY-MM-DD HH:mm:ss';
        }
        return this.$moment(d).format(format)
      },
      getList,
      sortChange: function (d) {
        this.sheet.sort = d && d.prop
        this.sheet.order = d && d.order && d.order.indexOf('asc') >= 0 ? 'ASC' : 'DESC'
        this.search()
      },
    },
    mounted: function () {
      this.search()
    },
    name: "【Uname】"
  }
</script>

<style scoped>
</style>
