<template>
  <el-dialog :title="'【describe】'" :visible.sync="visible"
             :close-on-click-modal="false" @close="hideDo">

    <el-form ref="form" :model="row" label-width="120px" align="left">
      【editForm】

      <el-form-item>
        <el-button icon="el-icon-edit" type="primary" @click="submitForm">提交</el-button>
        <el-button icon="el-icon-delete" @click="hide()">取消</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

</template>

<script>
  let data = () => {
    return {
      isAdd: false,
      visible: false,
      row: {},
      oldRow: {},
      isChange: false
    }
  }
  export default {
    data: data,
    props: ['search'],
    methods: {
      show: function (row) {
        this.oldRow = row;
        this.row = JSON.parse(JSON.stringify(row));
        this.visible = true;
        this.isChange = false;
      },
      showAdd: function () {
        this.isAdd = true;
        this.visible = true;
        this.oldRow = null;
        this.isChange = false;

        this.row = {
          【addInit】
      }
      },
      hide: function () {
        this.visible = false;
      },
      hideDo: function () {
        this.isAdd = false;
        if (this.isChange && this.oldRow) {
          for (let item in this.oldRow) {
            let val = this.row[item];
            this.oldRow[item] = val;
          }
        }else{
          this.search();
        }
      },
      submitForm() {
        this.$refs.form.validate((valid) => {
          if (valid) {
            this.onSubmit();
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      onSubmit: function () {
        let param = this.row;
        let vm = this;
        let url = this.isAdd ? '/【Lname】Controller/add【Uname】' : '/【Lname】Controller/update【Uname】';

        vm.$http.post(url, param).then(res => {
          if (!res.data.success) {
            vm.$message({
              showClose: true,
              message: res.data.message,
              type: 'error'
            });
            return
          }
          vm.isChange = true;
          vm.$message({
            type: 'success',
            message: '保存成功!'
          })
          vm.hide()
        })
      }
    },
    name: "【Uname】Edit"
  }
</script>

<style scoped>

</style>
