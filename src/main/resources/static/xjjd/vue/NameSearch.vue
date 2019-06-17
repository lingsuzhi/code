<template>
  <el-col :span="24" style="padding-bottom: 0px;">
    <el-form :inline="true" v-model="filters">
      【paramSearch】
      <el-form-item>
        <el-button type="primary" @click="search" icon="el-icon-search">查询</el-button>
        <el-button type="warning" @click="add" icon="el-icon-plus">添加</el-button>
      </el-form-item>
    </el-form>
  </el-col>
</template>

<script>
  export default {
    name: "lsz-pagination",
    props: ['search', 'filters', 'add'],
    methods: {}
  }
</script>

